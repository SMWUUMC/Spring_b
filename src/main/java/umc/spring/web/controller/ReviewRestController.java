package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> join(@RequestBody @Valid ReviewRequestDTO.ReviewDto request,
                                                               @RequestParam(name = "memberId") Long memberId){
        Review review = reviewCommandService.joinReview(memberId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
