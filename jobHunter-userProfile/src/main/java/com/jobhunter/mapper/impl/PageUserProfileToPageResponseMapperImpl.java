package com.jobhunter.mapper.impl;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.mapper.PageUserProfileToPageUserProfileResponseMapper;
import com.jobhunter.mapper.UserProfileToUserProfileResponseMapper;
import com.jobhunter.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageUserProfileToPageUserProfileResponseMapperImpl implements PageUserProfileToPageUserProfileResponseMapper {

    private final UserProfileToUserProfileResponseMapper userProfileResponseMapper;

    @Override
    public PageResponse map(Page<UserProfile> source) {

        if (source.getTotalElements() == 0) return PageResponse.builder().build();

        return PageResponse.builder()
                .data(source.getContent().stream().map(userProfileResponseMapper::map).toList())
                .currentPage(source.getPageable().getPageNumber())
                .itemsPerPage(source.getSize())
                .totalItems(source.getTotalElements())
                .totalPages(source.getTotalPages())
                .build();

    }

}
