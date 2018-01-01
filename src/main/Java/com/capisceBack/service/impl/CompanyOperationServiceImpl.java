package com.capisceBack.service.impl;

import com.capisceBack.dao.CompanyDao;
import com.capisceBack.dao.CompanyOperationDao;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.model.OtherUser;
import com.capisceBack.service.CompanyOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("companyOperationService")
public class CompanyOperationServiceImpl implements CompanyOperationService{

    @Resource
    private CompanyOperationDao companyOperationDao;

    @Override
    public CompanyDescription getCompanyInfo(String company) {

        return this.companyOperationDao.getCompanyInfo(company);
    }

    @Override
    public void registerNewMember(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String realName = "'"+ (String) data.get("realName") +"'";
        this.companyOperationDao.fillUserOrganization(data);
        this.companyOperationDao.registerNewMember(company,userName,realName);
    }

    @Override
    public void addDeppartment(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String apartment = "'"+ (String) data.get("apartment") +"'";
        String departmentDescription = "'"+ (String) data.get("departmentDescription") +"'";
        HashMap infoMap = new HashMap();
        infoMap.put("comapny",company);
        infoMap.put("userName",userName);
        infoMap.put("departmentDescription",departmentDescription);
        infoMap.put("apartment",apartment);
        this.companyOperationDao.addDeppartment(infoMap);
    }

    @Override
    public void addTeam(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String team = "'"+ (String) data.get("team") +"'";
        String teamDescription = "'"+ (String) data.get("teamDescription") +"'";
        HashMap infoMap = new HashMap();
        infoMap.put("comapny",company);
        infoMap.put("userName",userName);
        infoMap.put("TeamDescription",teamDescription);
        infoMap.put("team",team);
        this.companyOperationDao.addTeam(infoMap);
    }

    @Override
    public List<OtherUser> searchPerson(Map<String, Object> data) {
        String company = (String) data.get("company");
        String realName = "'"+(String) data.get("realName")+"'";
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("realName",realName);
        return this.companyOperationDao.searchPerson(infoMap);
    }
}
