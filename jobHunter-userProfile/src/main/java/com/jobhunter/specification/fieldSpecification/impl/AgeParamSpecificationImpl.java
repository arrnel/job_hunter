package com.jobhunter.specification.fieldSpecification.impl;

import com.jobhunter.specification.fieldSpecification.AgeParamSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static com.jobhunter.helper.NumbersHelper.isNotNullOrZero;


@Component
public class AgeParamSpecificationImpl implements AgeParamSpecification {

    @Override
    public List<Predicate> specify(
            Integer ageMin
            , Integer ageMax
            , Root<?> root
            , CriteriaBuilder criteriaBuilder
            , List<Predicate> predicates
    ) {
        LocalDate now = LocalDate.now();

        if (isNotNullOrZero(ageMin) && isNotNullOrZero(ageMax)) {
            predicates.add(criteriaBuilder.between(root.get("birth_date"), now.minusYears(ageMax), now.minusYears(ageMin)));
        } else {
            if (isNotNullOrZero(ageMin))
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("birth_date"), LocalDate.now().minusYears(ageMin)));
            if (isNotNullOrZero(ageMax))
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("birth_date"), LocalDate.now().minusYears(ageMax)));
        }
        return predicates;
    }

}
