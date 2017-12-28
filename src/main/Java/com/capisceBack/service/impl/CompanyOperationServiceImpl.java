package com.capisceBack.service.impl;

import com.capisceBack.dao.CompanyDao;
import com.capisceBack.dao.CompanyOperationDao;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.service.CompanyOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("companyOperationService")
public class CompanyOperationServiceImpl implements CompanyOperationService{

    @Resource
    private CompanyOperationDao companyOperationDao;

    @Override
    public CompanyDescription getCompanyInfo(String company) {

        return this.companyOperationDao.getCompanyInfo(company);
    }

}
