package com.jobhunter.service.impl;

import com.jobhunter.enums.UserProfileStatus;
import com.jobhunter.model.UserProfileStatusEntity;
import com.jobhunter.repository.UserProfileStatusRepository;
import com.jobhunter.service.UserProfileStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileStatusServiceImpl implements UserProfileStatusService {

    private final UserProfileStatusRepository repository;

    @Transactional(readOnly = true)
    public Optional<UserProfileStatusEntity> getByName(UserProfileStatus name) {
        return repository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Optional<UserProfileStatusEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public Set<UserProfileStatusEntity> getAll() {
        return new HashSet<>(repository.findAll());
    }

}
