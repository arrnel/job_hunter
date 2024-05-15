package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.enums.CityType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CityResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("region")
    private RegionResponseShort region;

    @JsonProperty("country")
    private CountryResponse country;

    @JsonProperty("population")
    private Long population;

    @JsonProperty("city_type")
    private CityType cityType;

}
