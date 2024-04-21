package com.jobhunter.service.impl;

import com.jobhunter.dto.queryParamsDTO.CountrySearchRequestParams;
import com.jobhunter.model.Country;
import com.jobhunter.repository.CountryRepository;
import com.jobhunter.service.CountryService;
import com.jobhunter.specification.modelSpecification.CountrySpecification;
import com.jobhunter.specification.modelSpecification.RegionSpecification;
import com.jobhunter.specification.modelSpecification.impl.CountrySpecificationImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountrySpecification countrySpecification;

    @Override
    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public Page<Country> getCountries(CountrySearchRequestParams requestParams, Pageable pageable) {
        return countryRepository.findAll(countrySpecification.findByCriteria(requestParams), pageable);
    }

    @Override
    public Page<Country> getAllCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }
}
