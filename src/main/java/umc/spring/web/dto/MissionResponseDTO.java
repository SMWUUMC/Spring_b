package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionAddResultDTO{
        Long missionId;
        LocalDateTime createdAt;
    }

    public static class MissionProgressResultDTO{
        Long missionId;
        LocalDateTime createdAt;
    }
}
