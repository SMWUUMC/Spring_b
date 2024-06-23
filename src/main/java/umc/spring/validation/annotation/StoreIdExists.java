package umc.spring.validation.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.StoreIdExistsValidator;

import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션
@Constraint(validatedBy = StoreIdExistsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 적용 범위
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 생명주기
public @interface StoreIdExists {

    String message() default "해당하는 storeId가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}