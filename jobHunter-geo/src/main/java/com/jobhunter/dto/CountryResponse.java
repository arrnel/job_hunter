package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
