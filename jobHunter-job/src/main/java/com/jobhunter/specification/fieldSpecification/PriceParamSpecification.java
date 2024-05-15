package com.jobhunter.specification.fieldSpecification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.List;

public interface PriceParamSpecification {

    List<Predicate> specify(
            BigDecimal minPrice
            , BigDecimal maxPrice
            , String currency
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
