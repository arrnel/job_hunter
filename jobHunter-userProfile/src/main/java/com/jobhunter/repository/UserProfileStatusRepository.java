package com.jobhunter.repository;

import com.jobhunter.enums.UserProfileStatus;
import com.jobhunter.model.UserProfileStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileStatusRepository extends JpaRepository<UserProfileStatusEntity, Integer> {

    Optional<UserProfileStatusEntity> findByName(UserProfileStatus name);

    List<UserProfileStatusEntity> findAll();

}
