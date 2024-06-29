package umc.spring.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.MissionProgress;

public class MemberMissionRequestDTO {
    @Getter
    public static class MemberMissionDTO{
        @MissionProgress
        Long memberId;
        @MissionProgress
        Long missionId;
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGE'")
        MissionStatus status;
    }
}
