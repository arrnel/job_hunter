package com.jobhunter.mapper.impl;

import com.jobhunter.config.Config;
import com.jobhunter.dto.JobRequest;
import com.jobhunter.dto.currency.CurrencyResponse;
import com.jobhunter.dto.geo.CityResponse;
import com.jobhunter.enums.Currency;
import com.jobhunter.enums.JobType;
import com.jobhunter.exception.PriceTypeNotFoundException;
import com.jobhunter.mapper.JobRequestToJobMapper;
import com.jobhunter.mapper.JobTypesToJobTypesEntityMapper;
import com.jobhunter.model.Job;
import com.jobhunter.model.JobTypeEntity;
import com.jobhunter.service.CategoryService;
import com.jobhunter.service.JobTypeService;
import com.jobhunter.service.PriceTypeService;
import com.jobhunter.service.external.CurrencyService;
import com.jobhunter.service.external.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import static com.jobhunter.enums.ECode.PRICE_TYPE_NOT_FOUND;
import static com.jobhunter.helper.EnumHelper.getEnumByNameIgnoreCase;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobRequestToJobMapperImpl implements JobRequestToJobMapper {

    private final JobTypeService jobTypeService;
    private final PriceTypeService priceTypeService;
    private final JobTypesToJobTypesEntityMapper jobTypeMapper;
    private final CurrencyService currencyService;
    private final LocationService locationService;
    private final CategoryService categoryService;

    @Override
    public Job map(JobRequest source) {

        BigDecimal minPrice = source.getMinPrice(),
                maxPrice = source.getMaxPrice();
        CurrencyResponse currencyResponse = currencyService.getRate(source.getCurrency(), Config.Currency.defaultCurrency());
        CityResponse cityResponse = locationService.getCity(source.getCityId());

//        Set<JobTypeEntity> jobTypes = jobTypeService.getJobTypesByNames(
//                source.getJobTypes()
//                        .stream().map(name -> getEnumByNameIgnoreCase(JobType.class, name))
//                        .collect(Collectors.toSet())
//        );
        Set<String> jobTypeNames = source.getJobTypes();
        Set<JobType> jobTypes = jobTypeNames.stream().map(name -> getEnumByNameIgnoreCase(JobType.class, name)).collect(Collectors.toSet());
        Set<JobTypeEntity> jobTypeEntities = jobTypeService.getJobTypesByNames(jobTypes);

        Job job = Job.builder()
                .title(source.getTitle())
                .description(source.getDescription())
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .minPriceInDefaultCurrency(minPrice.multiply(currencyResponse.getRate()))
                .maxPriceInDefaultCurrency(maxPrice.multiply(currencyResponse.getRate()))
                .currency(getEnumByNameIgnoreCase(Currency.class, source.getCurrency()))
                .priceType(
                        priceTypeService.getPriceTypeById(source.getPriceType())
                                .orElseThrow(() -> new PriceTypeNotFoundException(
                                        PRICE_TYPE_NOT_FOUND
                                        , "Provided price type = [" + source.getPriceType() + "]")))
                .jobTypes(jobTypeEntities)
                .specializationSubCategories(categoryService.getSpecializationsSubCategoriesWithIds(source.getSpecializations()))
                .industriesSubCategories(categoryService.getIndustriesSubCategoriesWithIds(source.getIndustries()))
                .cityId(source.getCityId())
                .regionId(cityResponse.getRegion().getId())
                .countryId(cityResponse.getCountry().getId())
                .build();

        return job;

    }

}
