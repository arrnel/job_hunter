package com.jobhunter.validation.validator;

import com.jobhunter.validation.EqualPasswords;
import com.jobhunter.dto.RegistrationRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, RegistrationRequestDTO> {

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