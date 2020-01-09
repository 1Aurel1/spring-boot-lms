package com.aurel.lms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberCompareValidator implements ConstraintValidator<ValidNumber, Integer> {

    int number;
    String message;
    boolean greaterThenThis;

    @Override
    public void initialize(ValidNumber constraint) {

        number = constraint.number();
        message = constraint.message();
        greaterThenThis = constraint.greaterThanThis();
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {

        if (greaterThenThis)
            return i >= number;
        else
            return i <= number;
    }
}
