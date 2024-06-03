package com.jobhunter.mapper;

import com.jobhunter.dto.CompanyRequest;
import com.jobhunter.model.Company;

public interface CompanyRequestToCompanyMapper extends Mapper<Company, CompanyRequest> {
    @Override
    Company map(CompanyRequest source);
}
