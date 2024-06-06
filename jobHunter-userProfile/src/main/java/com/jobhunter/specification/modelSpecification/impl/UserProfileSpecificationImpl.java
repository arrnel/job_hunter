package com.jobhunter.specification.modelSpecification.impl;

import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.model.UserProfile;
import com.jobhunter.specification.fieldSpecification.*;
import com.jobhunter.specification.modelSpecification.UserProfileSpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileSpecificationImpl implements UserProfileSpecification {

    private final NameParamSpecification nameParamSpecification;
    private final UserProfileParamSpecification userProfileParamSpecification;
    private final UserProfileStatusParamSpecification userProfileStatusParamSpecification;
    private final UserParamSpecification userParamSpecification;
    private final EmailParamSpecification emailParamSpecification;
    private final AgeParamSpecification ageParamSpecification;
    private final LocationParamSpecification locationParamSpecification;
    private final DatesRangeParamSpecification datesRangeParamSpecification;

    @Override
    public Specification<UserProfile> findByCriteria(UserProfileFilter source) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates = nameParamSpecification.specify(
                    source.getPartialTitle()
                    , source.getPartialDescription()
                    , source.getPartialContent()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = userParamSpecification.specify(
                    source.getUser()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = emailParamSpecification.specify(
                    source.getEmail()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = ageParamSpecification.specify(
                    source.getAgeMin()
                    , source.getAgeMax()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = locationParamSpecification.specify(
                    source.getCity()
                    , source.getRegion()
                    , source.getCountry()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = datesRangeParamSpecification.specify(
                    source.getFrom()
                    , source.getTo()
                    , root
                    , criteriaBuilder
                    , predicates);

            predicates = userProfileStatusParamSpecification.specify(
                    source.getStatus()
                    , root
                    , criteriaBuilder
                    , predicates);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
