package com.aurel.lms.validator.dummy;

import com.aurel.lms.model.courseUser.CourseUserType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CourseUserTypeSubsetValidator implements ConstraintValidator<CourseUserTypeSubset, CourseUserType> {

    CourseUserType [] subset;

    @Override
    public void initialize(CourseUserTypeSubset constrain) {

        this.subset = constrain.anyOf();
    }

    @Override
    public boolean isValid(CourseUserType value, ConstraintValidatorContext context) {

        return value == null || Arrays.asList(subset).contains(value);
    }
}
