// ReviewQueryService.java
package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);
}
