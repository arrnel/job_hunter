package com.jobhunter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@Accessors(chain = true)
public class StatusDTO {

    private boolean status;

}
