package com.fpoly.springboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotBlank;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber,String> {

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context) {

        if(value == null){
            return false;
        }
    
        return value.matches("^0\\d{9}$");
    }
}