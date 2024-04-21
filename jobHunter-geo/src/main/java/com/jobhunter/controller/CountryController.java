package com.jobhunter.controller;

import com.jobhunter.dto.CountryResponse;
import com.jobhunter.dto.PageResponse;
import org.springframework.data.domain.Pageable;

public interface CountryController {

    CountryResponse getCountryById(Integer id);
    PageResponse getCountries(String name, String partialName, Pageable pageable);
    PageResponse getAllCountries(Pageable pageable);
    
}
