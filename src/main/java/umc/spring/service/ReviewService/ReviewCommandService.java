package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    //Review joinReview(ReviewRequestDTO.ReviewDto request);

    @Transactional
    Review joinReview(Long memberId, ReviewRequestDTO.ReviewDto request);
}
