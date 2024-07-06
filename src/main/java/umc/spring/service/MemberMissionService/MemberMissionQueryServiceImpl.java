package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMyMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Retrieve missionIds of "PROCEEDING" missions for the member
        List<Long> missionIds = memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.PROCEEDING)
                .stream()
                .map(MemberMission::getMissionId)
                .collect(Collectors.toList());

        // Fetch missions by their IDs with pagination
        Page<Mission> missions = missionRepository.findAllByIdIn(missionIds, PageRequest.of(page, 10));

        return missions;
    }
}
