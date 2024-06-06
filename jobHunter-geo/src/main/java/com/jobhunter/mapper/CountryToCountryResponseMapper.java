package com.jobhunter.mapper;

import com.jobhunter.dto.CountryResponse;
import com.jobhunter.model.Country;

public interface CountryToCountryResponseMapper extends Mapper<CountryResponse, Country> {
    CountryResponse map(Country country);
}
