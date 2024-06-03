package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.LocationParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationParamSpecificationImpl implements LocationParamSpecification {

    @Override
    public List<Predicate> specify(
            Integer cityId
            , Integer regionId
            , Integer countryId
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {

        if (cityId != null && cityId > 0)
            predicates.add(criteriaBuilder.equal(root.get("city_id"), cityId));
        if (regionId != null && regionId > 0)
            predicates.add(criteriaBuilder.equal(root.get("region_id"), regionId));
        if (countryId != null && countryId > 0)
            predicates.add(criteriaBuilder.equal(root.get("country_id"), countryId));

        return predicates;

    }
}
