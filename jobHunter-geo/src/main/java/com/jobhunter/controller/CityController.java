package com.jobhunter.controller;

import com.jobhunter.dto.CityResponse;
import com.jobhunter.dto.PageResponse;
import org.springframework.data.domain.Pageable;

public interface CityController {

    CityResponse getCityById(Integer id);

    PageResponse getCities(String name, String partialName, Integer regionId, Integer countryId, Pageable pageable);

}
