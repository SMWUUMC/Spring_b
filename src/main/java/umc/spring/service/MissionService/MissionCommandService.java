package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.MissionAddDto request);
}
