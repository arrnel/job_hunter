package com.jobhunter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Builder
@RequiredArgsConstructor
@Accessors(chain = true)
public class StatusDTO {
    private final boolean status;
}
