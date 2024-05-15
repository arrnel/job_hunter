package com.jobhunter.dto.requestParams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CitiesFilter {

    private String name;
    private String partialName;
    private Integer regionId;
    private Integer countryId;

}
