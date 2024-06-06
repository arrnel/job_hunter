package com.jobhunter.specification.fieldSpecification;

import com.jobhunter.model.UserProfileStatusEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface UserProfileStatusParamSpecification {

    List<Predicate> specify(
            UserProfileStatusEntity status
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
