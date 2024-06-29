package umc.spring.domain.mapping;
import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

import jakarta.persistence.*;

@Entity // JPA 엔티티임을 명시
@Getter // lombok에서 제공
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

    public void setMember(Member member) {
        if(this.member != null){
            member.getMemberMissionList().remove(this);
        }

        this.member = member;

        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission){
        if (this.mission != null){
            mission.getMemberMissionList().remove(this);
        }

        this.mission = mission;

        mission.getMemberMissionList().add(this);
    }
}
