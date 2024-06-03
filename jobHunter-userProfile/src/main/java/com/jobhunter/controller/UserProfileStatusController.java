package com.jobhunter.controller;

import com.jobhunter.dto.userProfile.UserProfileStatusResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;

public interface UserProfileStatusController {

   @PostMapping
   @ResponseStatus(CREATED)
   Set<UserProfileStatusResponse> getAll();

}
