package com.jobhunter.mapper.impl;

import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.dto.requestParam.UserProfileFilterValues;
import com.jobhunter.enums.UserProfileStatus;
import com.jobhunter.exception.UserProfileStatusNotFoundException;
import com.jobhunter.mapper.UserProfileFilterValuesToUserProfileFilterMapper;
import com.jobhunter.service.UserProfileStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.jobhunter.helper.StringHelper.isNotNullOrBlank;

@Component
@RequiredArgsConstructor
public class UserProfileFilterValuesToUserProfileFilterMapperImpl implements UserProfileFilterValuesToUserProfileFilterMapper {

    private final UserProfileStatusService userProfileStatusService;

    @Override
    public UserProfileFilter map(UserProfileFilterValues source) {

        // @formatter:off
        return UserProfileFilter.builder()
                .partialTitle(source.getPartialTitle())
                .partialDescription(source.getPartialDescription())
                .partialContent(source.getPartialContent())
//                .status(
//                        isNullOrZero(statusId) && isNullOrBlank(statusName)
//                                ? null
//                                : isNotNullOrZero(statusId)
//                                    ? userProfileStatusService.getById(statusId)
//                                        .orElseThrow(() -> new InvalidRequestParamException(
//                                            "User profile status with id = [" + statusId + "] not found"))
//                                    : isNotNullOrBlank(source.getStatusName())?userProfileStatusService.getByName(getEnumByNameIgnoreCase(UserProfileStatus.class, statusName))
//                                        .orElseThrow(() -> new InvalidRequestParamException(
//                                            "User profile status with name = [" + statusName + "] not found"))
//                )
                .status(userProfileStatusService.getByName(UserProfileStatus.PUBLIC)
                        .orElseThrow(() -> new UserProfileStatusNotFoundException("Status [%s] is not found".formatted(UserProfileStatus.PUBLIC))))
                .user(source.getUser())
                .email(source.getEmail())
                .ageMin(source.getAgeMin())
                .ageMax(source.getAgeMax())
                .city(source.getCity())
                .region(source.getRegion())
                .country(source.getCountry())
                .from(isNotNullOrBlank(source.getFrom())
                        ? LocalDate.parse(source.getFrom())
                        : null
                )
                .from(isNotNullOrBlank(source.getTo())
                        ? LocalDate.parse(source.getTo())
                        : null
                )
                .build();
        // @formatter:on

    }
}
