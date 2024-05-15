package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.enums.ECode;
import com.jobhunter.exception.InvalidRequestParamException;
import com.jobhunter.specification.fieldSpecification.NameParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.jobhunter.helper.StringHelper.isEmptyOrBlank;

@Component
public class NameParamSpecificationImpl implements NameParamSpecification {

    @Override
    public List<Predicate> specify(String name, String partialName, Root<?> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {

        if (!isEmptyOrBlank(name) && !isEmptyOrBlank(partialName)) {
            throw new InvalidRequestParamException(ECode.INVALID_REQUEST_PARAM, "Unable to search with contains partial name and equals name");
        } else if (!isEmptyOrBlank(name)) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        } else if (!isEmptyOrBlank(partialName)) {
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + partialName + "%"));
        }

        return predicates;

    }


}
