package com.jobhunter.service.impl;

import com.jobhunter.dto.requestParams.RegionsFilter;
import com.jobhunter.model.Region;
import com.jobhunter.repository.RegionRepository;
import com.jobhunter.service.RegionService;
import com.jobhunter.specification.modelSpecification.RegionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionSpecification regionSpecification;

    public Optional<Region> getRegionById(Integer id) {
        return regionRepository.findById(id);
    }

    public Page<Region> getRegions(RegionsFilter requestParams, Pageable pageable) {
        return regionRepository.findAll(regionSpecification.findByCriteria(requestParams), pageable);
    }

}
