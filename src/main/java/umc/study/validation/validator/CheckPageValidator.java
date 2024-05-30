package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.CheckPage;

import java.util.List;
@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        boolean isValid = true;
        if (page <= 0) {
            isValid = false;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_ERROR.toString()).addConstraintViolation();
        }
        return isValid;
    }

}
