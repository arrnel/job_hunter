package com.jobhunter.validation.validator;

import com.jobhunter.dto.RegistrationRequestDTO;
import com.jobhunter.validation.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, RegistrationRequestDTO> {

    @Override
    public boolean isValid(RegistrationRequestDTO registrationData, ConstraintValidatorContext context) {

        boolean isValid = registrationData.getPassword().equals(registrationData.getConfirmPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("password")
                    .addConstraintViolation();
        }

        return isValid;

    }

}
