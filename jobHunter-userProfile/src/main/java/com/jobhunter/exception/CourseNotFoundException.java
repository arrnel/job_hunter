package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class CourseNotFoundException extends GlobalException {

    public CourseNotFoundException(ECode code) {
        super(code);
    }

    public CourseNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public CourseNotFoundException(String message) {
        super(ECode.COURSE_NOT_FOUND, message);
    }

    public CourseNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public CourseNotFoundException(String message, HttpStatus status) {
        super(ECode.COURSE_NOT_FOUND, message, status.value());
    }

}
