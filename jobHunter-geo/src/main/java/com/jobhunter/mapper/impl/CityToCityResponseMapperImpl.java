package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CityResponse;
import com.jobhunter.dto.CountryResponse;
import com.jobhunter.dto.RegionResponseShort;
import com.jobhunter.mapper.CityToCityResponseMapper;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.mapper.RegionToRegionResponseShortMapper;
import com.jobhunter.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityToCityResponseMapperImpl implements CityToCityResponseMapper {

    private final RegionToRegionResponseShortMapper regionMapper;
    private final CountryToCountryResponseMapper countryMapper;

    @Override
    public CityResponse map(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .region(regionMapper.map(city.getRegion()))
                .country(countryMapper.map(city.getCountry()))
                .cityType(city.getCityType())
                .population(city.getPopulation())
                .build();
    }
}
