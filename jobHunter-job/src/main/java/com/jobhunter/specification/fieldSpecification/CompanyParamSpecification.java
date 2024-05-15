package com.jobhunter.specification.fieldSpecification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface CompanyParamSpecification {

    List<Predicate> specify(
            Long companyId
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
