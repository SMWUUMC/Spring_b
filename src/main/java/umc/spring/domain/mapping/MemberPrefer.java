package umc.spring.domain.mapping;
import lombok.*;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import jakarta.persistence.*;

@Entity // JPA 엔티티임을 명시
@Getter // lombok에서 제공
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="category_id")
    private FoodCategory foodCategory;

}
