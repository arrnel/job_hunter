package com.jobhunter.mapper.impl;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.mapper.PageRegionToPageResponseMapper;
import com.jobhunter.mapper.RegionToRegionResponseMapper;
import com.jobhunter.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageRegionToPageResponseMapperImpl implements PageRegionToPageResponseMapper {

    private final RegionToRegionResponseMapper regionToRegionResponseMapper;

    @Override
    public PageResponse map(Page<Region> regions) {
        return PageResponse.builder()
                .currentPage(regions.getPageable().getPageNumber())
                .perPage(regions.getSize())
                .total((int) regions.getTotalElements())
                .totalPages(regions.getTotalPages())
                .data(regions.getContent().stream().map(regionToRegionResponseMapper::map).toList())
                .build();
    }

}
