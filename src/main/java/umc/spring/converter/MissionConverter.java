package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MissionAddResultDTO toJoinResultDTO(Mission Mission){
        return MissionResponseDTO.MissionAddResultDTO.builder()
                .missionId(Mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionAddDto request, Store store){

        return Mission.builder()
                .store(store)
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
