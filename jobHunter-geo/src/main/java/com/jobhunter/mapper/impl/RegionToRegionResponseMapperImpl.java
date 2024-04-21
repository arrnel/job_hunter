package com.jobhunter.mapper.impl;

import com.jobhunter.dto.CountryResponse;
import com.jobhunter.dto.RegionResponse;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.mapper.RegionToRegionResponseMapper;
import com.jobhunter.model.Country;
import com.jobhunter.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegionToRegionResponseMapperImpl implements RegionToRegionResponseMapper {

    private final CountryToCountryResponseMapper countryMapper;

    @Override
    public RegionResponse map(Region region) {
        return RegionResponse.builder()
                .id(region.getId())
                .name(region.getName())
                .country(countryMapper.map(region.getCountry()))
                .build();
    }
}
