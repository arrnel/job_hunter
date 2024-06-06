package com.jobhunter.controller.impl;

import com.jobhunter.controller.UserProfileStatusController;
import com.jobhunter.dto.userProfile.UserProfileStatusResponse;
import com.jobhunter.mapper.UserProfileStatusEntityToUserProfileStatusResponseMapper;
import com.jobhunter.service.UserProfileStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/profile/status")
@RequiredArgsConstructor
public class UserProfileStatusControllerImpl implements UserProfileStatusController {

    private final UserProfileStatusService userProfileStatusService;
    private final UserProfileStatusEntityToUserProfileStatusResponseMapper userProfileStatusResponseMapper;

    @Override
    @GetMapping
    @ResponseStatus(OK)
    public Set<UserProfileStatusResponse> getAll() {
        log.info("Get all user profile statuses");
        return userProfileStatusService.getAll()
                .stream().map(userProfileStatusResponseMapper::map).collect(Collectors.toSet());

    }

}
