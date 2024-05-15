package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.enums.Currency;
import com.jobhunter.enums.JobType;
import com.jobhunter.enums.PriceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JobResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("min_price")
    private BigDecimal minPrice;

    @JsonProperty("max_price")
    private BigDecimal maxPrice;

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("price_type")
    private PriceType priceType;

    @JsonProperty("job_type")
    private Set<JobType> jobTypes;

    @JsonProperty("specialization_id")
    private Set<Integer> specializations;

    @JsonProperty("industry_id")
    private Set<Integer> industries;

    @JsonProperty("city")
    private Integer cityId;

    @JsonProperty("date_created")
    private LocalDateTime dateCreated;

    @JsonProperty("date_updated")
    private LocalDateTime dateUpdated;

}
