package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JobRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    @JsonProperty("title")
    private String title;

    @NotBlank
    @Size(min = 100, max = 10000)
    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("min_price")
    private BigDecimal minPrice;

    @JsonProperty("max_price")
    private BigDecimal maxPrice;

    @NotBlank
    @Size(min = 3, max = 3)
    @JsonProperty("currency")
    private String currency;

    @Size(min = 1, max = 2)
    @JsonProperty("price_type")
    private Integer priceType;

    @NotBlank
    @JsonProperty("job_type")
    private Set<String> jobTypes;

    @NotNull
    @Min(1)
    @JsonProperty("specializations")
    private Set<Integer> specializations;

    @NotNull
    @Min(1)
    @JsonProperty("industries")
    private Set<Integer> industries;

    @NotNull
    @Min(1)
    @JsonProperty("city")
    private Integer cityId;

}
