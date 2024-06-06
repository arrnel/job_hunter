package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.model.Region;
import org.springframework.data.domain.Page;

public interface PageRegionToPageResponseMapper extends Mapper<PageResponse, Page<Region>> {
    PageResponse map(Page<Region> regions);
}
