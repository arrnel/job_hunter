package com.jobhunter.dto.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("region")
    private RegionResponseShort region;

    @JsonProperty("country")
    private CountryResponse country;

    @JsonProperty("city_type")
    private String cityType;

    @JsonProperty("population")
    private Long population;

}
