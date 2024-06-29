package umc.spring.converter;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionDTO request) {

        MissionStatus missionStatus = null;

//        switch (request.getStatus()) {
//            case 1:
//                missionStatus = MissionStatus.PROCEEDING;
//                break;
//            case 2:
//                missionStatus = MissionStatus.COMPLETE;
//                break;
//        }

        return MemberMission.builder()
                .status(missionStatus)
                .build();

    }


}
