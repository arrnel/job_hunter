package com.jobhunter.controller.impl;

import com.jobhunter.controller.CountryController;
import com.jobhunter.dto.CountryResponse;
import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.queryParamsDTO.CountrySearchRequestParams;
import com.jobhunter.enums.ECode;
import com.jobhunter.exception.LocationNotFoundException;
import com.jobhunter.mapper.CountryToCountryResponseMapper;
import com.jobhunter.mapper.PageCountryToPageResponseMapper;
import com.jobhunter.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryControllerImpl implements CountryController {

    private final CountryService countryService;

    private final CountryToCountryResponseMapper countryToResponseMapper;
    private final PageCountryToPageResponseMapper pageCountryToPageResponseMapper;

    @Override
    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public CountryResponse getCountryById(@PathVariable Integer id) {
        return countryToResponseMapper
                .map(countryService.getCountryById(id)
                        .orElseThrow(() -> new LocationNotFoundException(ECode.COUNTRY_NOT_FOUND, "Country with id = [" + id + "] not found")));
    }

    @Override
    @ResponseStatus(OK)
    @GetMapping
    public PageResponse getCountries(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "partial_name") String partialName,
            Pageable pageable
    ) {
        log.info(String.format("""
                        Get countries with params:
                        name = [%1$s],
                        partial_name = [%2$s],
                        page_number = [%3$s],
                        page_size = [%4$s],
                        sort = [%5$s]
                        """
                , name, partialName, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()));
        return pageCountryToPageResponseMapper.map(
                countryService.getCountries(
                    CountrySearchRequestParams.builder()
                            .name(name)
                            .partialName(partialName)
                            .build()
                    , pageable));
    }

    @Override
    @ResponseStatus(OK)
    @GetMapping("/all")
    public PageResponse getAllCountries(Pageable pageable) {
        log.info(String.format("""
                        Get all countries with params:
                        page_number = [%1$s],
                        page_size = [%2$s],
                        sort = [%3$s]
                        """
                , pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()));
        return pageCountryToPageResponseMapper.map(countryService.getAllCountries(pageable));
    }
}
