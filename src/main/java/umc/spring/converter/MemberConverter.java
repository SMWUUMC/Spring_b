package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
//            case 3:
//                gender = Gender.NONE;
//                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MyReviewPreViewDTO myreviewPreViewDTO(Review review){
        return MemberResponseDTO.MyReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static MemberResponseDTO.MyReviewPreViewListDTO myreviewPreViewListDTO(Page<Review> myreviewList){

        List<MemberResponseDTO.MyReviewPreViewDTO> myreviewPreViewDTOList = myreviewList.stream()
                .map(MemberConverter::myreviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyReviewPreViewListDTO.builder()
                .isLast(myreviewList.isLast())
                .isFirst(myreviewList.isFirst())
                .totalPage(myreviewList.getTotalPages())
                .totalElements(myreviewList.getTotalElements())
                .listSize(myreviewPreViewDTOList.size())
                .reviewList(myreviewPreViewDTOList)
                .build();
    }
}
