package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.RegionResponse;
import com.jobhunter.model.Country;
import com.jobhunter.model.Region;
import org.springframework.data.domain.Page;

public interface PageCountryToPageResponseMapper extends Mapper<PageResponse, Page<Country>>{
    PageResponse map(Page<Country> countries);
}
