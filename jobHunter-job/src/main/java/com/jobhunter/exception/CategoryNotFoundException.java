package com.jobhunter.exception;

import com.jobhunter.enums.ECode;

public class CategoryNotFoundException extends GlobalException {

    public CategoryNotFoundException(ECode code) {
        super(code);
    }

    public CategoryNotFoundException(ECode code, String message) {
        super(code, message);
    }

}
