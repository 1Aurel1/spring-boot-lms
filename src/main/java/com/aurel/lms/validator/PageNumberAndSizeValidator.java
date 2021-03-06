package com.aurel.lms.validator;

import com.aurel.lms.exeption.BadRequestException;
import com.aurel.lms.util.AppConstants;

public class PageNumberAndSizeValidator {

    public static void validate(int page, int size){

        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size < 0) {
            throw new BadRequestException("Size number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }

    }
}
