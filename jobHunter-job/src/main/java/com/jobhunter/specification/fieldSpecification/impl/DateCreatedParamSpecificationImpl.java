package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.DateCreatedParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DateCreatedParamSpecificationImpl implements DateCreatedParamSpecification {

    @Override
    public List<Predicate> specify(
            LocalDate beforeDate
            , LocalDate afterDate
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {

        if (beforeDate != null && afterDate != null) {
            predicates.add(criteriaBuilder.between(root.get("date_created"), beforeDate, afterDate));
        } else if (beforeDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("date_created"), beforeDate));
        } else if (afterDate != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("date_created"), afterDate));
        }

        return predicates;

    }

}
