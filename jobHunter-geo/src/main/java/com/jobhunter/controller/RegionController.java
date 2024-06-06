package com.jobhunter.controller;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.RegionResponse;
import org.springframework.data.domain.Pageable;

public interface RegionController {

    RegionResponse getRegionById(Integer id);

    PageResponse getRegions(String name, String partialName, Integer countryId, Pageable pageable);

}
