package com.jobhunter.repository;

import com.jobhunter.model.Job;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

    Boolean existsByCompanyIdAndTitle(Long companyId, String title);

    Boolean existsByCompanyIdAndTitleAndIdNot(Long companyId, String title, Long id);

    @NonNull
    Page<Job> findAll(@NonNull Pageable pageable);

}
