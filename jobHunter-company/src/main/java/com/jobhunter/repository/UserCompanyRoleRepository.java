package com.jobhunter.repository;

import com.jobhunter.model.UserCompanyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCompanyRoleRepository extends JpaRepository<UserCompanyRole, Long> {
}
