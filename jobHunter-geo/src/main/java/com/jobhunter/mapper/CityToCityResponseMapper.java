package com.jobhunter.mapper;

import com.jobhunter.dto.CityResponse;
import com.jobhunter.model.City;

public interface CityToCityResponseMapper extends Mapper<CityResponse, City> {
    CityResponse map(City country);
}
