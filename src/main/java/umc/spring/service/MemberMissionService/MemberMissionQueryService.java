package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.util.Optional;

public interface MemberMissionQueryService {
    Page<Mission> getMyMissionList(Long memberId, Integer page);
}
