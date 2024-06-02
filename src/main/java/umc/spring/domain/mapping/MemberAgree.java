package umc.spring.domain.mapping;
import lombok.*;
import umc.spring.domain.Terms;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.Member;
import jakarta.persistence.*;

@Entity // JPA 엔티티임을 명시
@Getter // lombok에서 제공
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberAgree extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="terms_id")
    private Terms terms;
}
