package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository;
import umc.spring.validation.annotation.StoreIdExists;

@Component
@RequiredArgsConstructor
public class StoreIdExistsValidator implements ConstraintValidator<StoreIdExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(StoreIdExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // @NotNull 어노테이션으로 null 검증
        }

        boolean exists = storeRepository.existsById(value);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_ID_NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return exists;
    }
}
