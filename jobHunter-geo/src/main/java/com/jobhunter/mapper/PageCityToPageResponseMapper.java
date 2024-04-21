package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.dto.RegionResponse;
import com.jobhunter.model.City;
import com.jobhunter.model.Region;
import org.springframework.data.domain.Page;

public interface PageCityToPageResponseMapper extends Mapper<PageResponse, Page<City>>{
    PageResponse map(Page<City> cities);
}
