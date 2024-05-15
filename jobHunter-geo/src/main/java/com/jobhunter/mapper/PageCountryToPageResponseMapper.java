package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.model.Country;
import org.springframework.data.domain.Page;

public interface PageCountryToPageResponseMapper extends Mapper<PageResponse, Page<Country>>{
    PageResponse map(Page<Country> countries);
}
