package com.jobhunter.service;

import com.jobhunter.dto.requestParams.CitiesFilter;
import com.jobhunter.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CityService {

    Optional<City> getCityById(Integer id);
    Page<City> getCities(CitiesFilter requestParams, Pageable pageable);

}
