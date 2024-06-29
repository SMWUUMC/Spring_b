package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission progressMemberMission(MemberMissionRequestDTO.MemberMissionDTO request) {

        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();

        // 회원 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        // 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 새로운 멤버 미션 생성
        MemberMission newMission = MemberMissionConverter.toMemberMission(request);
        newMission.setMember(member);
        newMission.setMission(mission);

        return memberMissionRepository.save(newMission);
    }
}
