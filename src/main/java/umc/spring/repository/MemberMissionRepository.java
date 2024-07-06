package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMission_IdAndStatus(Long missionId, MissionStatus status); // Corrected method
    List<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status);

    Optional<MemberMission> findByMember_IdAndMission_Id(Long memberId, Long missionId);
}
