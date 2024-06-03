package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.helper.CollectionHelper;
import com.jobhunter.specification.fieldSpecification.IdsParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class IdsParamSpecificationImpl implements IdsParamSpecification {

    @Override
    public List<Predicate> specify(
            Set<Long> ids
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {

        if (CollectionHelper.isNotNullOrEmpty(ids)){
            CriteriaBuilder.In<Long> inClause = criteriaBuilder.in(root.get("id"));
            ids.forEach(inClause::value);
            predicates.add(inClause);
        }

        return predicates;

    }

}
