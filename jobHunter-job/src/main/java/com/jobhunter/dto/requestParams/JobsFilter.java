package com.jobhunter.dto.requestParams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JobsFilter {

    private Long companyId;
    private String partialTitle;
    private String partialDescription;
    private String partialContent;
    private BigDecimal minPrice;
    private BigDecimal minPriceInDefaultCurrency;
    private BigDecimal maxPrice;
    private BigDecimal maxPriceInDefaultCurrency;
    private String currency;
    private Integer cityId;
    private Integer regionId;
    private Integer countryId;
    private LocalDate afterDate;
    private LocalDate beforeDate;

}
