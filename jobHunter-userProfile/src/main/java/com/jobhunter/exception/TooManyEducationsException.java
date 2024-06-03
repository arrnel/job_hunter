package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class TooManyCoursesException extends GlobalException {

    public TooManyCoursesException(ECode code) {
        super(code);
    }

    public TooManyCoursesException(ECode code, String message) {
        super(code, message);
    }

    public TooManyCoursesException(String message){
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message);
    }

    public TooManyCoursesException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public TooManyCoursesException(String message, HttpStatus status) {
        super(ECode.EXCEEDED_THE_COURSE_LIMIT, message, status.value());
    }

}
