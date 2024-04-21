package com.jobhunter.service;

import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.model.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RegionService {

    Optional<Region> getRegionById(Integer id);
    Page<Region> getRegions(RegionSearchRequestParams queryParams, Pageable pageable);

}
