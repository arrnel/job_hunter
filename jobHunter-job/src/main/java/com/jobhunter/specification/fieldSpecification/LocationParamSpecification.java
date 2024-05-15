package com.jobhunter.specification.fieldSpecification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface LocationParamSpecification {

    List<Predicate> specify(
            Integer cityId
            , Integer regionId
            , Integer countryId
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
