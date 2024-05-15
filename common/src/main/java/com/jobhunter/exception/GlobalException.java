package com.jobhunter.exception;

import com.jobhunter.enums.ECode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GlobalException extends RuntimeException{

    private final ECode code;
    private final String message;
    private final LocalDateTime time;

    public GlobalException(ECode code) {
        super(code.getMessage());
        this.code = code;
        this.message = code.getMessage();
        time = LocalDateTime.now();
    }

    public GlobalException(ECode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        time = LocalDateTime.now();
    }

}