package umc.spring.web.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class RegionRequestDTO {
    @Getter
    public static class AddDto {
        @NotNull
        Long regionId;

        @NotNull
        String name;

        @NotNull
        String address;

        @NotNull
        Float score;
    }
}
