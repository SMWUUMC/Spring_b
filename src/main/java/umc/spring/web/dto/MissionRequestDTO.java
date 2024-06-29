package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.StoreIdExists;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionAddDto{
        @NotNull
        @StoreIdExists
        Long storeId;

        @NotNull
        Integer reward;

        @NotNull
        LocalDate deadline;

        String missionSpec;
    }


}
