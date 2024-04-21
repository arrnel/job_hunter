package com.jobhunter.service;

import com.jobhunter.dto.queryParamsDTO.CountrySearchRequestParams;
import com.jobhunter.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CountryService {

    Optional<Country> getCountryById(Integer id);
    Page<Country> getCountries(CountrySearchRequestParams queryParams, Pageable pageable);
    Page<Country> getAllCountries(Pageable pageable);

}
