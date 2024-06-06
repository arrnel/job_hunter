package com.jobhunter.service;

import com.jobhunter.dto.StatusDTO;
import com.jobhunter.dto.requestParam.CompanyFilter;
import com.jobhunter.model.Company;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface CompanyService {

    Company createNewCompany(Company company);

    Optional<Company> getCompany(Long companyId);

    Set<Company> getCompanies(CompanyFilter filter, Pageable pageable);

    Company updateCompany(Long companyId, Company newCompany);

    StatusDTO deleteCompany(Long companyId);

}
