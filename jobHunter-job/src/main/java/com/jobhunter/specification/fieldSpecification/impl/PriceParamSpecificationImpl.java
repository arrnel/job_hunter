package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.PriceParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PriceParamSpecificationImpl implements PriceParamSpecification {

    @Override
    public List<Predicate> specify(
            BigDecimal minPrice
            , BigDecimal maxPrice
            , String currency
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {

        if (minPrice != null && minPrice.compareTo(BigDecimal.valueOf(0)) > 0)
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("min_price_in_default_currency"), minPrice));
        if (maxPrice != null && maxPrice.compareTo(BigDecimal.valueOf(0)) > 0)
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("max_price_in_default_currency"), maxPrice));

        return predicates;

    }

}
