package com.jobhunter.dto.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

}
