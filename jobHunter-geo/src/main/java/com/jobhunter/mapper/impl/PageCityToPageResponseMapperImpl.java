package com.jobhunter.mapper.impl;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.mapper.CityToCityResponseMapper;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.mapper.Mapper;
import com.jobhunter.mapper.PageCityToPageResponseMapper;
import com.jobhunter.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageCityToPageResponseMapperImpl implements PageCityToPageResponseMapper {

    private final CityToCityResponseMapper cityToCityResponseMapper;

    @Override
    public PageResponse map(Page<City> cities) {
        return PageResponse.builder()
                .currentPage(cities.getPageable().getPageNumber())
                .perPage(cities.getSize())
                .total((int) cities.getTotalElements())
                .totalPages(cities.getTotalPages())
                .data(cities.getContent().stream().map(cityToCityResponseMapper::map).toList())
                .build();
    }
}
