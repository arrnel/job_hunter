package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.model.UserProfile;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface UserProfileSpecification extends EntitySpecification<Specification<UserProfile>, UserProfileFilter> {

    Specification<UserProfile> findByCriteria(UserProfileFilter requestParams);

}
