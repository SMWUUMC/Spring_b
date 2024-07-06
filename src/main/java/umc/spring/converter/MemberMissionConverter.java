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

        return MemberMission.builder()
                .status(request.getStatus())
                .build();

    }

    public static MemberMissionResponseDTO.MemberMissionCPResultDTO toMemberMissionCPResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionCPResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }


}
