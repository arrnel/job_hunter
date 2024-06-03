package com.jobhunter.specification.modelSpecification.impl;

import com.jobhunter.dto.requestParam.ExperienceFilter;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.specification.fieldSpecification.IdsParamSpecification;
import com.jobhunter.specification.fieldSpecification.UserParamSpecification;
import com.jobhunter.specification.fieldSpecification.UserProfileParamSpecification;
import com.jobhunter.specification.modelSpecification.ExperienceSpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExperienceSpecificationImpl implements ExperienceSpecification {

    private final IdsParamSpecification idsParamSpecification;
    private final UserProfileParamSpecification userProfileParamSpecification;
    private final UserParamSpecification userIdParamSpecification;

    @Override
    public Specification<ExperienceEntity> findByCriteria(ExperienceFilter requestParams) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            predicates = idsParamSpecification.specify(
                    requestParams.getIds()
                    , root
                    , criteriaBuilder
                    , predicates
            );

            predicates = userProfileParamSpecification.specify(
                    requestParams.getUserProfile()
                    , root
                    , criteriaBuilder
                    , predicates);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };

    }

}
