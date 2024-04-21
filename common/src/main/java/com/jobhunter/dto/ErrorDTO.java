package com.jobhunter.dto;

import com.jobhunter.enums.ECode;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorDTO {

    private final ECode code;
    private final String message;
    private final LocalDateTime time;

}
