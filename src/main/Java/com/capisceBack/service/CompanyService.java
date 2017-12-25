package com.capisceBack.service;
import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;

public interface CompanyService {
    public Company getCompanyInfo(String userName, String userToken);
    public CompanyDescription getCompanyDescription(String company);
    public void createCompany(String company,String business,String description,String companyIcon,String userName);
}
