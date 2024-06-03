package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.requestParam.ExperienceFilter;
import com.jobhunter.model.ExperienceEntity;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface ExperienceSpecification extends EntitySpecification<Specification<ExperienceEntity>, ExperienceFilter> {

    Specification<ExperienceEntity> findByCriteria(ExperienceFilter requestParams);

}
