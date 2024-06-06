package com.jobhunter.specification;

import com.jobhunter.dto.requestParams.JobsFilter;
import com.jobhunter.model.Job;
import org.springframework.data.jpa.domain.Specification;

public interface JobSpecification extends EntitySpecification<Specification<Job>, JobsFilter> {
}
