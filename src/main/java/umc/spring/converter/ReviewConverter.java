package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.RegionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDto request, Store store){

        return Review.builder()
                .store(store)
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
