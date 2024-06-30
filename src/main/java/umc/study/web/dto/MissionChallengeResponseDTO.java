package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionChallengeRequestDTO {
    @NotNull
    private Long missionId;
    @NotNull
    private Long userId;
}
