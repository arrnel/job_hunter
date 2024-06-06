package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.model.Job;
import org.springframework.data.domain.Page;

public interface PageJobToPageJobResponseMapper extends Mapper<PageResponse, Page<Job>> {

    PageResponse map(Page<Job> source);

}
