package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.EmailParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.StringHelper.isNotNullOrBlank;

@Component
public class EmailParamSpecificationImpl implements EmailParamSpecification {

    @Override
    public List<Predicate> specify(
            String email
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        if (isNotNullOrBlank(email))
            predicates.add(criteriaBuilder.equal(root.get("email"), email));
        return predicates;
    }

}
