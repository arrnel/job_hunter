package com.jobhunter.specification.modelSpecification.impl;

import com.jobhunter.dto.requestParams.CountriesFilter;
import com.jobhunter.model.Country;
import com.jobhunter.specification.fieldSpecification.impl.NameParamSpecificationImpl;
import com.jobhunter.specification.modelSpecification.CountrySpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CountrySpecificationImpl implements CountrySpecification {

    private final NameParamSpecificationImpl nameSpecification;

    @Override
    public Specification<Country> findByCriteria(CountriesFilter requestParams) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates = nameSpecification.specify(
                    requestParams.getName()
                    , requestParams.getPartialName()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
