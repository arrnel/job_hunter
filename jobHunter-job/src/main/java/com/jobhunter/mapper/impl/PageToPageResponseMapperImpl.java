package com.jobhunter.mapper.impl;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.mapper.JobToJobResponseMapper;
import com.jobhunter.mapper.PageToPageResponseMapper;
import com.jobhunter.model.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageToPageResponseMapperImpl implements PageToPageResponseMapper {

    private final JobToJobResponseMapper jobMapper;

    @Override
    public PageResponse map(Page<Job> source) {

        if (source.getTotalElements() == 0) return PageResponse.builder().build();

        return PageResponse.builder()
                .data(source.getContent().stream().map(jobMapper::map).toList())
                .currentPage(source.getPageable().getPageNumber())
                .itemsPerPage(source.getSize())
                .totalItems(source.getTotalElements())
                .totalPages(source.getTotalPages())
                .build();

    }

}
