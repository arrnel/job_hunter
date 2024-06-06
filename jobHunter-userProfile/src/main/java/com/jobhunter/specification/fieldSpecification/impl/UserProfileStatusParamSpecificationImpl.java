package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.model.UserProfileStatusEntity;
import com.jobhunter.specification.fieldSpecification.UserProfileStatusParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserProfileStatusParamSpecificationImpl implements UserProfileStatusParamSpecification {

    @Override
    public List<Predicate> specify(
            UserProfileStatusEntity status
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (status != null)
            predicates.add(criteriaBuilder.equal(root.get("status"), status));
        return predicates;
    }

}
