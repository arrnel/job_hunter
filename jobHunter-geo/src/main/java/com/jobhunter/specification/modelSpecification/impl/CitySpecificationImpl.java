package com.jobhunter.specification.modelSpecification.impl;

import com.jobhunter.dto.requestParams.CitiesFilter;
import com.jobhunter.model.City;
import com.jobhunter.specification.fieldSpecification.RegionParamSpecification;
import com.jobhunter.specification.fieldSpecification.impl.CountryParamSpecificationImpl;
import com.jobhunter.specification.fieldSpecification.impl.NameParamSpecificationImpl;
import com.jobhunter.specification.modelSpecification.CitySpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CitySpecificationImpl implements CitySpecification {

    private final NameParamSpecificationImpl nameSpecification;
    private final RegionParamSpecification regionSpecification;
    private final CountryParamSpecificationImpl countrySpecification;

    @Override
    public Specification<City> findByCriteria(CitiesFilter requestParams) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates = nameSpecification.specify(
                    requestParams.getName()
                    , requestParams.getPartialName()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = regionSpecification.specify(
                    requestParams.getRegionId()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = countrySpecification.specify(
                    requestParams.getCountryId()
                    , root
                    , criteriaBuilder
                    , predicates);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
