package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 적용 범위
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "Invalid page number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
