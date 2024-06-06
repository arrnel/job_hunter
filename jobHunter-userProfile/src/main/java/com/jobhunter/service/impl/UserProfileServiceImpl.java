package com.jobhunter.service.impl;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParam.UserProfileFilter;
import com.jobhunter.exception.ExperienceNotFoundException;
import com.jobhunter.exception.UserProfileNotFoundException;
import com.jobhunter.mapper.UserProfileUpdater;
import com.jobhunter.model.UserProfile;
import com.jobhunter.repository.UserProfileRepository;
import com.jobhunter.service.UserProfileService;
import com.jobhunter.specification.modelSpecification.UserProfileSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;
    private final UserProfileSpecification userProfileSpecification;
    private final UserProfileUpdater userProfileUpdater;

    @Override
    public UserProfile create(UserProfile newUserProfile) {
        return repository.save(newUserProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserProfile> getById(Long id) {
        Optional<UserProfile> userProfile = repository.findById(id);
        userProfile.ifPresent(x -> log.info("User profile = [{}]", x));
        return userProfile;
//        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserProfile> getAll(UserProfileFilter filter, final Pageable pageable) {
        return repository.findAll(userProfileSpecification.findByCriteria(filter), pageable);
    }

    @Override
    public UserProfile update(Long id, UserProfile newUserProfile) {
        return repository.save(
                userProfileUpdater.update(
                        repository.findById(id)
                                .orElseThrow(() -> new ExperienceNotFoundException("Experience with id = [%d] not found".formatted(id), BAD_REQUEST))
                        , newUserProfile));
    }

    @Override
    public StatusDTO delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new UserProfileNotFoundException("User profile with id = [%d] not found".formatted(id))));
        return new StatusDTO(true);
    }

}
