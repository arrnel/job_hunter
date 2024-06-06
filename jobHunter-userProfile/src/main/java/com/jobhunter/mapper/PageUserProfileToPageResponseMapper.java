package com.jobhunter.mapper;

import com.jobhunter.dto.PageResponse;
import com.jobhunter.model.UserProfile;
import org.springframework.data.domain.Page;

public interface PageUserProfileToPageResponseMapper extends Mapper<PageResponse, Page<UserProfile>> {

    PageResponse map(Page<UserProfile> source);

}
