package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.queryParamsDTO.CitySearchRequestParams;
import com.jobhunter.model.City;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface CitySpecification extends EntitySpecification<Specification<City>, CitySearchRequestParams> {
    Specification<City> findByCriteria(CitySearchRequestParams requestParams);
}
