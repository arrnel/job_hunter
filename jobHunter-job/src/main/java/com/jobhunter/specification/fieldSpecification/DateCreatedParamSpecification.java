package com.jobhunter.specification.fieldSpecification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public interface DateCreatedParamSpecification {

    List<Predicate> specify(
            LocalDate beforeDate
            , LocalDate afterDate
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
