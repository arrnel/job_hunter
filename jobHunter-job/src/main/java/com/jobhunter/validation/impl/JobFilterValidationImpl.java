package com.jobhunter.validation.impl;

import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.exception.InvalidRequestParamException;
import com.jobhunter.validation.JobsFilterValidation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

import static com.jobhunter.config.Config.Currency.activeCurrencies;
import static com.jobhunter.enums.ECode.CURRENCY_NOT_FOUND;
import static com.jobhunter.enums.ECode.REQUEST_PARAMS_COMBINATION_INVALID;
import static com.jobhunter.helper.StringHelper.isNotNullOrBlank;

@Component
public class JobFilterValidationImpl implements JobsFilterValidation {

    @Override
    public void validate(JobsFilter requestParams) {

        // INFO: Title and description
        String partialTitle = requestParams.getPartialTitle(),
                partialDescription = requestParams.getPartialDescription(),
                partialContent = requestParams.getPartialContent();
        if ((isNotNullOrBlank(partialTitle) || isNotNullOrBlank(partialDescription)) && isNotNullOrBlank(partialContent))
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Unable to search by part of content and part of title or description");

        // INFO: Currency and price
        String currency = requestParams.getCurrency();
        BigDecimal minPrice = requestParams.getMinPrice(),
                maxPrice = requestParams.getMaxPrice();
        if ((minPrice != null && maxPrice != null) && maxPrice.compareTo(minPrice) < 0) {
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Invalid price range: [" + minPrice + ";" + maxPrice + "]");
        }
        if (isNotNullOrBlank(currency) && Arrays.stream(activeCurrencies()).noneMatch(x -> x.equalsIgnoreCase(currency))) {
            throw new InvalidRequestParamException(CURRENCY_NOT_FOUND, "Currency = [" + currency + "] not found");
        }

        // INFO: Location
        Integer cityId = requestParams.getCityId(),
                regionId = requestParams.getRegionId(),
                countryId = requestParams.getCountryId();
        boolean isFilledMoreThanOneLocation = IntStream.of(
                        (cityId == null) ? 0 : cityId,
                        (regionId == null) ? 0 : regionId,
                        (countryId == null) ? 0 : countryId)
                .filter(Objects::nonNull)
                .filter(value -> value != 0)
                .count() > 1;
        if (isFilledMoreThanOneLocation)
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Invalid locations data: city_id = [" + cityId + "], region_id = [" + regionId + "]" +
                    ", country_id = [" + countryId + "]. Select only one of the following");

        // INFO: Date
        LocalDate beforeDate = requestParams.getBeforeDate(),
                afterDate = requestParams.getAfterDate();
        if (!(beforeDate == null || afterDate == null) && afterDate.isBefore(beforeDate))
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Invalid date range: [" + beforeDate + ";" + afterDate + "]");

    }

}
