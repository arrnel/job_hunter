package com.jobhunter.controller.impl;

import com.jobhunter.controller.RegionController;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.RegionResponse;
import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.exception.LocationNotFoundException;
import com.jobhunter.mapper.PageRegionToPageResponseMapper;
import com.jobhunter.mapper.RegionToRegionResponseMapper;
import com.jobhunter.service.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static com.jobHunter.enums.ECode.CITY_NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/region")
@RequiredArgsConstructor
public class RegionControllerImpl implements RegionController {

    private final RegionService regionService;
    private final RegionToRegionResponseMapper regionToResponseMapper;
    private final PageRegionToPageResponseMapper pageRegionToPageResponseMapper;

    @Override
    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public RegionResponse getRegionById(@PathVariable Integer id) {
        log.info("Get region with id = [{}]", id);
        return regionToResponseMapper.map(regionService.getRegionById(id)
                .orElseThrow(() -> new LocationNotFoundException(CITY_NOT_FOUND, "Region with id = [" + id + "] not found")));
    }

    @Override
    @ResponseStatus(OK)
    @GetMapping
    public PageResponse getRegions(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "partial_name") String partialName,
            @RequestParam(required = false, name = "country_id") Integer countryId,
            Pageable pageable
    ) {

        log.info("Get region with params: name = [{}], partial_name = [{}], country_id = [{}], page = [{}], size = [{}], sort = [{}]"
                , name, partialName, countryId, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        return pageRegionToPageResponseMapper.map(
                regionService.getRegions(
                        RegionSearchRequestParams.builder()
                                .name(name)
                                .partialName(partialName)
                                .countryId(countryId)
                                .build()
                        , pageable));
    }

}
