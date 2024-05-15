package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.requestParams.CountriesFilter;
import com.jobhunter.model.Country;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface CountrySpecification extends EntitySpecification<Specification<Country>, CountriesFilter> {
    Specification<Country> findByCriteria(CountriesFilter requestParams);


}
