package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.StoreIdHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.ReviewDto request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreIdHandler(ErrorStatus.STORE_ID_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store);
        return reviewRepository.save(newReview);
    }
}
