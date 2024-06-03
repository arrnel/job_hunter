package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.helper.StringHelper;
import com.jobhunter.specification.fieldSpecification.NameParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.StringHelper.isNotNullOrBlank;

@Component
public class NameParamSpecificationImpl implements NameParamSpecification {

    @Override
    public List<Predicate> specify(
            String partialTitle
            , String partialDescription
            , String partialContent
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {

        if (isNotNullOrBlank(partialTitle))
            predicates.add(criteriaBuilder.like(root.get("name"), partialTitle));
        if (isNotNullOrBlank(partialDescription))
            predicates.add(criteriaBuilder.like(root.get("name"), partialDescription));
        if (isNotNullOrBlank(partialContent))
            predicates.add(criteriaBuilder
                    .or(
                            criteriaBuilder.like(root.get("name"), partialContent),
                            criteriaBuilder.like(root.get("description"), partialContent)
                    )
            );

        return predicates;

    }
}
