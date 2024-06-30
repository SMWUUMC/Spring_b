package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface MemberQueryService {
    Page<Review> getMyReviewList(Long memberId, Integer page);
}
