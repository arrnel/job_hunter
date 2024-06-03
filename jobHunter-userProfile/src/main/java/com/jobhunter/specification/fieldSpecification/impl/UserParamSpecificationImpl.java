package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.helper.NumbersHelper;
import com.jobhunter.specification.fieldSpecification.UserIdParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserIdParamSpecificationImpl implements UserIdParamSpecification {

    @Override
    public List<Predicate> specify(
            Long user
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (NumbersHelper.isNotNullOrZero(user))
            predicates.add(criteriaBuilder.equal(root.get("user"), user));
        return predicates;
    }

}
