package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CountryResponse;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryToCountryResponseMapperImpl implements CountryToCountryResponseMapper {

    @Override
    public CountryResponse map(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}
