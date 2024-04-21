package com.jobhunter.specification.modelSpecification.impl;

import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.exception.IllegalRequestParamValueException;
import com.jobhunter.model.City;
import com.jobhunter.model.Region;
import com.jobhunter.specification.fieldSpecification.RegionParamSpecification;
import com.jobhunter.specification.fieldSpecification.impl.CountryParamSpecificationImpl;
import com.jobhunter.specification.fieldSpecification.impl.NameParamSpecificationImpl;
import com.jobhunter.specification.modelSpecification.RegionSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.jobhunter.helper.StringHelper.isStringNullOrEmpty;
import static com.jobHunter.enums.ECode.INVALID_SEARCH_BY_NAME_AND_PARTIAL_NAME;

@Component
@RequiredArgsConstructor
public class RegionSpecificationImpl implements RegionSpecification {

    private final NameParamSpecificationImpl nameSpecification;
    private final CountryParamSpecificationImpl countrySpecification;

    public Specification<Region> findByCriteria(RegionSearchRequestParams requestParams) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            nameSpecification.specify(
                    requestParams.getName()
                    , requestParams.getPartialName()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = countrySpecification.specify(
                    requestParams.getCountryId()
                    , root
                    , criteriaBuilder
                    , predicates);


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
