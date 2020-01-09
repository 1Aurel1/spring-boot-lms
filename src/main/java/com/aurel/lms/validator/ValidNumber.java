package com.aurel.lms.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NumberCompareValidator.class)
public @interface ValidNumber {

    int number() default 0;
    boolean greaterThanThis() default false;
    String message() default "Number is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
