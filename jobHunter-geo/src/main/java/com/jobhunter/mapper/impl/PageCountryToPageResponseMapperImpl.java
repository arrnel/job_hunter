package com.jobhunter.mapper.impl;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.mapper.PageCountryToPageResponseMapper;
import com.jobhunter.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageCountryToPageResponseMapperImpl implements PageCountryToPageResponseMapper {

    private final CountryToCountryResponseMapper countryToCountryResponseMapper;

    @Override
    public PageResponse map(Page<Country> countries) {
        return PageResponse.builder()
                .data(countries.getContent().stream().map(countryToCountryResponseMapper::map).toList())
                .currentPage(countries.getPageable().getPageNumber())
                .perPage(countries.getSize())
                .total((int) countries.getTotalElements())
                .totalPages(countries.getTotalPages())
                .build();
    }
}
