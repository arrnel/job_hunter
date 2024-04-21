package com.jobhunter.service.impl;

import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.model.Region;
import com.jobhunter.repository.RegionRepository;
import com.jobhunter.service.RegionService;
import com.jobhunter.specification.modelSpecification.RegionSpecification;
import com.jobhunter.specification.modelSpecification.impl.RegionSpecificationImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionSpecification regionSpecification;

    public Optional<Region> getRegionById(Integer id) {
        return regionRepository.findById(id);
    }

    public Page<Region> getRegions(RegionSearchRequestParams requestParams, Pageable pageable) {
        return regionRepository.findAll(regionSpecification.findByCriteria(requestParams), pageable);
    }

}
