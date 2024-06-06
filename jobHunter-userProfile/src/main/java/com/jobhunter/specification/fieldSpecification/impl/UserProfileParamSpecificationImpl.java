package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.UserProfileParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.NumbersHelper.isNotNullOrZero;

@Component
public class UserProfileParamSpecificationImpl implements UserProfileParamSpecification {

    @Override
    public List<Predicate> specify(
            Long userProfile
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (isNotNullOrZero(userProfile))
            predicates.add(criteriaBuilder.equal(root.get("user_profile_id"), userProfile));
        return predicates;
    }

}
