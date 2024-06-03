package com.jobhunter.repository;

import com.jobhunter.model.UserProfile;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>, JpaSpecificationExecutor<UserProfile> {

    @NonNull
    Optional<UserProfile> findById(@NonNull Long id);

    @NonNull
    Page<UserProfile> findAll(@NonNull Specification<UserProfile> spec, @NonNull Pageable pageable);

}

//public interface UserProfileRepository extends JpaRepository<UserProfile, Long>, JpaSpecificationExecutor<UserProfile> {
// @Override
//    @NonNull
//    Set<UserProfile> findAll(@NonNull Specification<UserProfileSpecification> specification);
// }
