package com.jobhunter.controller;

import com.jobhunter.dto.CompanyRequest;
import com.jobhunter.dto.CompanyResponse;
import com.jobhunter.dto.StatusDTO;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface CompanyController {

    CompanyResponse createNewCompany(CompanyRequest requestBody);

    CompanyResponse getCompany(Long companyId);

    Set<CompanyResponse> getCompanies(
            String email
            , String name
            , String partialName
            , String partialContent
            , Pageable pageable
    );

    CompanyResponse updateCompany(Long companyId, CompanyRequest requestBody);

    StatusDTO deleteCompany(Long companyId);

}
