package com.jobhunter.mapper;

import com.jobhunter.dto.CityResponse;
import com.jobhunter.dto.CountryResponse;
import com.jobhunter.model.City;
import com.jobhunter.model.Country;

public interface CityToCityResponseMapper extends Mapper<CityResponse, City>{
    CityResponse map(City country);
}
