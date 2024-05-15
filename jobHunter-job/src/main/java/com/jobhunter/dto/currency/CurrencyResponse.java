package com.jobhunter.dto.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("rate")
    private BigDecimal rate;

}
