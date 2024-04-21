package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.RegionParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegionParamSpecificationImpl implements RegionParamSpecification {

    @Override
    public List<Predicate> specify(Integer regionId, Root<?> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {

        if (regionId != null && regionId != 0)
            predicates.add(criteriaBuilder.equal(root.get("region").get("id"), regionId));

        return predicates;

    }


}
