package umc.spring.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.StoreIdExists;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDto{
        @NotNull
        @StoreIdExists
        Long storeId;

        @Min(value = 1)
        @Max(value = 5)
        Float score;

        @Column(columnDefinition = "text")
        String body;
    }
}
