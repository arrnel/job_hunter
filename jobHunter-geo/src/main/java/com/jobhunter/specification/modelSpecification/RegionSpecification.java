package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.queryParamsDTO.RegionSearchRequestParams;
import com.jobhunter.model.Region;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface RegionSpecification extends EntitySpecification<Specification<Region>, RegionSearchRequestParams> {
    Specification<Region> findByCriteria(RegionSearchRequestParams requestParams);
}
