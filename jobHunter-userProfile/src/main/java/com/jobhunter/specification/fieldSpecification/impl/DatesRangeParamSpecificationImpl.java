package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.DatesRangeParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatesRangeParamSpecificationImpl implements DatesRangeParamSpecification {

    @Override
    public List<Predicate> specify(
            LocalDate from
            , LocalDate to
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (from != null)
            predicates.add(criteriaBuilder.equal(root.get("from"), from));
        if (to != null)
            predicates.add(criteriaBuilder.equal(root.get("to"), from));
        return predicates;
    }

}
