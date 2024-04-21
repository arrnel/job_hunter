package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.exception.IllegalRequestParamValueException;
import com.jobhunter.specification.fieldSpecification.NameParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.StringHelper.isStringNullOrEmpty;
import static com.jobHunter.enums.ECode.INVALID_SEARCH_BY_NAME_AND_PARTIAL_NAME;

@Component
public class NameParamSpecificationImpl implements NameParamSpecification {

    @Override
    public List<Predicate> specify(String name, String partialName, Root<?> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {

        if (!isStringNullOrEmpty(name) && !isStringNullOrEmpty(partialName)) {
            throw new IllegalRequestParamValueException(INVALID_SEARCH_BY_NAME_AND_PARTIAL_NAME);
        } else if (!isStringNullOrEmpty(name)) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        } else if (!isStringNullOrEmpty(partialName)) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + partialName + "%"));
        }

        return predicates;

    }


}
