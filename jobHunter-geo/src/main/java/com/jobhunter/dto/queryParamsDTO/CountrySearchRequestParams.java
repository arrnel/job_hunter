package com.jobhunter.dto.queryParamsDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountrySearchRequestParams {

    private String name;
    private String partialName;

}
