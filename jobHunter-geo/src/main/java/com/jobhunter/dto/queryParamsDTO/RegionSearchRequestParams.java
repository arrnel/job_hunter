package com.jobhunter.dto.queryParamsDTO;

import com.jobhunter.enums.OrderBy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionSearchRequestParams {

    private String name;
    private String partialName;
    private Integer countryId;

}
