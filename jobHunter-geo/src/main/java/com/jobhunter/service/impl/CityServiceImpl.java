package com.jobhunter.service.impl;

import com.jobhunter.dto.requestParams.CitiesFilter;
import com.jobhunter.model.City;
import com.jobhunter.repository.CityRepository;
import com.jobhunter.service.CityService;
import com.jobhunter.specification.modelSpecification.CitySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CitySpecification citySpecification;

    @Override
    public Optional<City> getCityById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public Page<City> getCities(CitiesFilter requestParams, final Pageable pageable) {
        return cityRepository.findAll(citySpecification.findByCriteria(requestParams), pageable);
    }

}
