package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.CompanyParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyParamSpecificationImpl implements CompanyParamSpecification {

    @Override
    public List<Predicate> specify(
            Long companyId
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (companyId != null && companyId > 0)
            predicates.add(criteriaBuilder.equal(root.get("company_id"), companyId));
        return predicates;
    }
}
