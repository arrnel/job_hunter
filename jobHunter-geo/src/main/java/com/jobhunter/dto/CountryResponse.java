package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CountryResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
