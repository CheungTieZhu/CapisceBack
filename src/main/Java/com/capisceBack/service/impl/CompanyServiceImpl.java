package com.capisceBack.service.impl;

import com.capisceBack.dao.CompanyDao;
import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.service.CompanyService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
    @Resource
    private CompanyDao companyDao;

    public List<Company> getCompanyInfo(String userName, String userToken){
        return this.companyDao.getCompanyInfo(userName,userToken);
    }

    @Override
    public CompanyDescription getCompanyDescription(String company) {
        return this.companyDao.getCompanyDescription(company);
    }

    @Override
    public void createCompany(String company, String business, String description, String companyIcon,String userName) {
        this.companyDao.setCompanyDescription(company,business,description,companyIcon);
        this.companyDao.createCompanyTable(company);
        String userNameAfterHandle = "'"+userName+"'";
        this.companyDao.createFunderData(company,userNameAfterHandle);
        this.companyDao.fillTheUserData(company,userName);
    }
}
