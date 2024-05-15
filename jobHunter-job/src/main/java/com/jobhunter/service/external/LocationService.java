package com.jobhunter.service.external;

import com.jobhunter.dto.geo.CityResponse;
import com.jobhunter.dto.geo.CountryResponse;
import com.jobhunter.dto.geo.RegionResponse;

public interface LocationService {

    CityResponse getCity(Integer cityId);

    RegionResponse getRegion(Integer regionId);

    CountryResponse getCountry(Integer countryId);

}
