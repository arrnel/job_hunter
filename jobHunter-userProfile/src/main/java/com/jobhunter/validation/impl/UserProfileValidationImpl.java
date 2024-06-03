package com.jobhunter.validation.impl;

import com.jobhunter.config.Config;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;
import com.jobhunter.exception.InvalidRequestParamException;
import com.jobhunter.validation.UserProfileValidation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.IntStream;

import static com.jobhunter.enums.ECode.REQUEST_PARAMS_COMBINATION_INVALID;
import static com.jobhunter.helper.DateHelper.validDatePattern;
import static com.jobhunter.helper.NumbersHelper.isNotNullOrZero;
import static com.jobhunter.helper.NumbersHelper.isNullOrZero;
import static com.jobhunter.helper.StringHelper.isNotNullOrBlank;
import static com.jobhunter.helper.StringHelper.isNullOrBlank;

@Component
public class UserProfileValidationImpl implements UserProfileValidation {

    public void validate(UserProfileFilterValues values) {

        validateContent(values.getPartialTitle(), values.getPartialDescription(), values.getPartialContent());
        validateLocations(values.getCity(), values.getRegion(), values.getCountry());
        validateCreationDates(values.getFrom(), values.getTo());
        validateAges(values.getAgeMin(), values.getAgeMax());
        validateStatus(values.getStatusId(), values.getStatusName());

    }

    private void validateAges(Integer minAge, Integer maxAge) {

        int allowedMinAge = Config.User.ageMin(),
                allowedMaxAge = Config.User.ageMax();

        boolean isMinAgeInvalid = isNotNullOrZero(minAge) && (minAge < allowedMinAge || minAge > allowedMaxAge),
                isMaxAgeInvalid = isNotNullOrZero(maxAge) && (maxAge < allowedMinAge || maxAge > allowedMaxAge),
                isAgeRangeInvalid = isNotNullOrZero(minAge) && isNotNullOrZero(maxAge) && minAge > maxAge;

        if (isMinAgeInvalid || isMaxAgeInvalid || isAgeRangeInvalid)
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID,
                    String.format("Invalid age range: min_age = [%d], max_age = [%d]. The age must be between %d and %d."
                            , minAge, maxAge, allowedMinAge, allowedMaxAge)
            );

    }

    private void validateContent(String partialTitle, String partialDescription, String partialContent) {
        if ((isNotNullOrBlank(partialTitle) || isNotNullOrBlank(partialDescription)) && isNotNullOrBlank(partialContent))
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Unable to search by part of content and part of title or description");
    }

    private void validateLocations(Integer city, Integer region, Integer country) {
        boolean isFilledMoreThanOneLocation = IntStream.of(
                        (city == null) ? 0 : city,
                        (region == null) ? 0 : region,
                        (country == null) ? 0 : country)
                .filter(Objects::nonNull)
                .filter(value -> value != 0)
                .count() > 1;
        if (isFilledMoreThanOneLocation)
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Invalid locations data: city_id = [" + city + "], region_id = [" + region + "]" +
                    ", country_id = [" + country + "]. Select only one of the following");
    }

    private void validateCreationDates(String dateFrom, String dateTo) {

        if (isNullOrBlank(dateFrom) && isNullOrBlank(dateTo)) return;

        boolean isDateFromParseable = dateFrom.matches(validDatePattern),
                isDateToParseable = dateTo.matches(validDatePattern);

        if (isNullOrBlank(dateFrom) && !isDateFromParseable)
            throw new InvalidRequestParamException("Invalid \"date_from\" pattern. Available pattern: dd.mm.yyyy");
        if (isNullOrBlank(dateTo) && !isDateToParseable)
            throw new InvalidRequestParamException("Invalid \"date_to\" pattern. Available pattern: dd.mm.yyyy");

        if (isDateFromParseable && isDateToParseable && LocalDate.parse(dateFrom).isAfter(LocalDate.parse(dateTo)))
            throw new InvalidRequestParamException(REQUEST_PARAMS_COMBINATION_INVALID
                    , "Invalid date range: [" + dateFrom + ";" + dateTo + "]");
    }

    private void validateStatus(Integer statusId, String statusName) {

        if (isNotNullOrZero(statusId) && isNotNullOrZero(statusName))
            throw new InvalidRequestParamException("Invalid combination. Use only \"status_id\" or \"status_name\"");

        if (isNotNullOrZero(statusId) && statusId < 0)
            throw new InvalidRequestParamException("Invalid value of \"status_id\"");

        if (isNotNullOrBlank(statusName))
            throw new InvalidRequestParamException("Invalid value of \"status_id\"");

    }

}
