package umc.spring.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.StoreIdExists;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDto{
        @NotNull
        @StoreIdExists
        Long storeId;

//        @NotBlank
//        String title;

        @Min(value = 1)
        @Max(value = 5)
        Float score;

        @Column(columnDefinition = "text")
        String body;
    }


}
