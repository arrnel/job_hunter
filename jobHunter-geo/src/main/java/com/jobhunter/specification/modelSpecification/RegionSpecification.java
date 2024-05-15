package com.jobhunter.specification.modelSpecification;

import com.jobhunter.dto.requestParams.RegionsFilter;
import com.jobhunter.model.Region;
import com.jobhunter.specification.EntitySpecification;
import org.springframework.data.jpa.domain.Specification;

public interface RegionSpecification extends EntitySpecification<Specification<Region>, RegionsFilter> {
    Specification<Region> findByCriteria(RegionsFilter requestParams);
}
