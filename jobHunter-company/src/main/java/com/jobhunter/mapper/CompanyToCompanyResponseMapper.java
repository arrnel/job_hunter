package com.jobhunter.mapper;

import com.jobhunter.dto.CompanyResponse;
import com.jobhunter.model.Company;

public interface CompanyToCompanyResponseMapper extends Mapper<CompanyResponse, Company> {

    @Override
    CompanyResponse map(Company source);

}
