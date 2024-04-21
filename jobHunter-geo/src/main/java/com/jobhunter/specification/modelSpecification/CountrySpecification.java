package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.queryParamsDTO.CountrySearchRequestParams;
import com.jobhunter.model.Country;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface CountrySpecification extends EntitySpecification<Specification<Country>, CountrySearchRequestParams> {
    Specification<Country> findByCriteria(CountrySearchRequestParams requestParams);


}
