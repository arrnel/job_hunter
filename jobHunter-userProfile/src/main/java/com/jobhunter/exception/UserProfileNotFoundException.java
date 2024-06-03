package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends GlobalException {

    public CategoryNotFoundException(ECode code) {
        super(code);
    }

    public CategoryNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public CategoryNotFoundException(String message){
        super(ECode.JOB_CATEGORY_NOT_FOUND, message);
    }

    public CategoryNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public CategoryNotFoundException(String message, HttpStatus status) {
        super(ECode.JOB_CATEGORY_NOT_FOUND, message, status.value());
    }

}
