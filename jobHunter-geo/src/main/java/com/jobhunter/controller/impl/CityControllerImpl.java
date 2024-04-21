package com.jobhunter.controller.impl;

import com.jobhunter.controller.CityController;
import com.jobhunter.dto.CityResponse;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.queryParamsDTO.CitySearchRequestParams;
import com.jobhunter.exception.LocationNotFoundException;
import com.jobhunter.mapper.CityToCityResponseMapper;
import com.jobhunter.mapper.PageCityToPageResponseMapper;
import com.jobhunter.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static com.jobHunter.enums.ECode.CITY_NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityControllerImpl implements CityController {

    private final CityService cityService;
    private final CityToCityResponseMapper cityToResponseMapper;
    private final PageCityToPageResponseMapper pageCityToPageResponseMapper;

    @Override
    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public CityResponse getCityById(@PathVariable Integer id) {
        log.info("Get city with id = [{}]", id);
        return cityToResponseMapper
                .map(cityService.getCityById(id)
                        .orElseThrow(() -> new LocationNotFoundException(CITY_NOT_FOUND, "City with id = [" + id + "] not found")));
    }

    @Override
    @ResponseStatus(OK)
    @GetMapping
    public PageResponse getCities(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "partial_name") String partialName,
            @RequestParam(required = false, name = "region_id") Integer regionId,
            @RequestParam(required = false, name = "country_id") Integer countryId,
            Pageable pageable
    ) {

        log.info("Get cities with params: name = [{}], partial_name = [{}], region_id = [{}], country_id = [{}], page = [{}], size = [{}], sort = [{}]"
                , name, partialName, regionId, countryId, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        return pageCityToPageResponseMapper.map(
                cityService.getCities(
                        CitySearchRequestParams.builder()
                                .name(name)
                                .partialName(partialName)
                                .regionId(regionId)
                                .countryId(countryId)
                                .build()
                        , pageable));
    }

}
