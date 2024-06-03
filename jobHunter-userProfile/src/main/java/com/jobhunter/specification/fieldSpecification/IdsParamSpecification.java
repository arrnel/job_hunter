package com.jobhunter.specification.fieldSpecification;

import com.jobhunter.model.UserProfile;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Set;

public interface IdsParamSpecification {

    List<Predicate> specify(
            Set<Long> ids
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    );

}
