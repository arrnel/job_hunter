package com.jobhunter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Accessors(chain = true)
public class CurrencyRateDTO {

    @JsonProperty("from")
    private Currency from;

    @JsonProperty("to")
    private Currency to;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("date_updated")
    private LocalDateTime dateUpdated;


}
