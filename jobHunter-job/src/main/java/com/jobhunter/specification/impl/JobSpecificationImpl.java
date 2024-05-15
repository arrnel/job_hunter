package com.jobhunter.specification.impl;

import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.model.Job;
import com.jobhunter.specification.JobSpecification;
import com.jobhunter.specification.fieldSpecification.*;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JobSpecificationImpl implements JobSpecification {

    private final NameParamSpecification nameParamSpecification;
    private final CompanyParamSpecification companyParamSpecification;
    private final PriceParamSpecification priceParamSpecification;
    private final LocationParamSpecification locationParamSpecification;
    private final DateCreatedParamSpecification dateCreatedParamSpecification;

    @Override
    public Specification<Job> findByCriteria(JobsFilter source) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Info: title and description
            predicates = nameParamSpecification.specify(
                    source.getPartialTitle()
                    , source.getPartialDescription()
                    , source.getPartialContent()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = companyParamSpecification.specify(
                    source.getCompanyId()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = priceParamSpecification.specify(
                    source.getMinPriceInDefaultCurrency()
                    , source.getMaxPriceInDefaultCurrency()
                    , source.getCurrency()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = locationParamSpecification.specify(
                    source.getCityId()
                    , source.getRegionId()
                    , source.getCountryId()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = dateCreatedParamSpecification.specify(
                    source.getBeforeDate()
                    , source.getAfterDate()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
