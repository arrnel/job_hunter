package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GlobalException extends RuntimeException{

    private final ECode code;
    private final String message;
    private final LocalDateTime time;
    private final Integer statusCode;

    public GlobalException(ECode code) {
        super(code.getMessage());
        this.code = code;
        this.statusCode = getStatusCode();
        this.message = code.getMessage();
        time = LocalDateTime.now();
    }

    public GlobalException(ECode code, String message) {
        super(message);
        this.code = code;
        this.statusCode = getStatusCode();
        this.message = message;
        time = LocalDateTime.now();
    }

    public GlobalException(ECode code, String message, Integer statusCode) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
        time = LocalDateTime.now();
    }

}