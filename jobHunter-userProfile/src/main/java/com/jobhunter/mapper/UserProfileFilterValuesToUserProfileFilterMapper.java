package com.jobhunter.mapper;

import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;

public interface UserProfileFilterValuesToUserProfileFilterMapper extends Mapper<UserProfileFilter, UserProfileFilterValues>{

    @Override
    UserProfileFilter map(UserProfileFilterValues source);

}
