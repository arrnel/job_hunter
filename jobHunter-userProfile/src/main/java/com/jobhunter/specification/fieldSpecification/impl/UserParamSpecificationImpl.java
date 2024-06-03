package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.UserParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.NumbersHelper.isNotNullOrZero;

@Component
public class UserParamSpecificationImpl implements UserParamSpecification {

    @Override
    public List<Predicate> specify(
            Long user
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (isNotNullOrZero(user))
            predicates.add(criteriaBuilder.equal(root.get("userId"), user));
        return predicates;
    }

}
