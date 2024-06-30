package umc.study.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionResponseDTO {
    @NotNull
    private Long storeId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}
