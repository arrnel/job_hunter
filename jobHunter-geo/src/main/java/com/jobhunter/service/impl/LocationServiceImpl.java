package com.jobhunter.service.impl;

import com.jobhunter.dataParser.LocationUpdater;
import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.model.Region;
import com.jobhunter.repository.CityRepository;
import com.jobhunter.repository.RegionRepository;
import com.jobhunter.service.LocationService;
import com.jobhunter.service.RegionService;
import com.jobhunter.specification.modelSpecification.RegionSpecification;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationUpdater locationUpdater;
    private final CityRepository cityRepository;

    @Override
    @PostConstruct
    public void init() {

        log.info("Checking cities table for update.");
        if (cityRepository.count() == 0) {
            log.info("Table city is empty. Starting to update locations");
            update();

        }

    }

    @Override
    public void update() {
        log.info("Starting to update locations tables");
        locationUpdater.update();
    }
}
