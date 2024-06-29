package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.validation.annotation.MissionProgress;

@Component
@RequiredArgsConstructor
public class MissionProgressValidator implements ConstraintValidator<MissionProgress, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(MissionProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isMissionInProgress = memberMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.PROCEEDING);

        if (isMissionInProgress) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CHALLENGING.getMessage())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}