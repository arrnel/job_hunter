package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.requestParams.CitiesFilter;
import com.jobhunter.model.City;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface CitySpecification extends EntitySpecification<Specification<City>, CitiesFilter> {
    Specification<City> findByCriteria(CitiesFilter requestParams);
}
