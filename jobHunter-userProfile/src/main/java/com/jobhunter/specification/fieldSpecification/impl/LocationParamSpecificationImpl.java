package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.LocationParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.NumbersHelper.isNotNullOrZero;

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

        if (isNotNullOrZero(cityId))
            predicates.add(criteriaBuilder.equal(root.get("city_id"), cityId));
        if (isNotNullOrZero(regionId))
            predicates.add(criteriaBuilder.equal(root.get("region_id"), regionId));
        if (isNotNullOrZero(countryId))
            predicates.add(criteriaBuilder.equal(root.get("country_id"), countryId));

        return predicates;

    }
}
