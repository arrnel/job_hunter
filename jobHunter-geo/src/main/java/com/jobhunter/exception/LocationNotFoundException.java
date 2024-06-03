package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import org.springframework.http.HttpStatus;

public class LocationNotFoundException extends GlobalException {

    public LocationNotFoundException(ECode code) {
        super(code);
    }

    public LocationNotFoundException(ECode code, String message) {
        super(code, message);
    }

    public LocationNotFoundException(String message){
        super(ECode.LOCATION_NOT_FOUND, message);
    }

    public LocationNotFoundException(ECode code, String message, HttpStatus status) {
        super(code, message, status.value());
    }

    public LocationNotFoundException(String message, HttpStatus status) {
        super(ECode.LOCATION_NOT_FOUND, message, status.value());
    }

}
