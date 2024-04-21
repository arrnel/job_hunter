package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.CountryParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryParamSpecificationImpl implements CountryParamSpecification {

    @Override
    public List<Predicate> specify(Integer countryId, Root<?> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {

        if (countryId != null && countryId != 0)
            predicates.add(criteriaBuilder.equal(root.get("country").get("id"), countryId));

        return predicates;

    }


}
