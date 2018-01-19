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
        String headImageUrl =  "'"+ (String) data.get("headImageUrl") +"'";
        this.companyOperationDao.registerNewMember(company,userName,realName,headImageUrl);
        this.companyOperationDao.fillUserOrganization(data);
    }

    @Override
    public void addDepartment(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String apartment = "'"+ (String) data.get("organizationName") +"'";
        String departmentDescription = "'"+ (String) data.get("note") +"'";
        String departmentTableName = (String) data.get("company")+"_"+"department"+"_"+"description";
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("userName",userName);
        infoMap.put("departmentDescription",departmentDescription);
        infoMap.put("apartment",apartment);
        infoMap.put("departmentTableName",departmentTableName);
        this.companyOperationDao.addDepartment(infoMap);
        this.companyOperationDao.fillDepartmentDescription(infoMap);
    }

    @Override
    public void addTeam(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String team = "'"+ (String) data.get("organizationName") +"'";
        String teamDescription = "'"+ (String) data.get("note") +"'";
        String department = "'"+ (String) data.get("department") +"'";
        String teamTableName = (String) data.get("company")+"_"+"team"+"_"+"description";
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("userName",userName);
        infoMap.put("teamDescription",teamDescription);
        infoMap.put("department",department);
        infoMap.put("team",team);
        infoMap.put("teamTableName",teamTableName);
        this.companyOperationDao.addTeam(infoMap);
        this.companyOperationDao.fillTeamDescription(infoMap);
    }

    @Override
    public List<OtherUser> searchPerson(Map<String, Object> data) {
        String company = (String) data.get("company");
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("realName","'%"+(String) data.get("realName")+"%'");
        return this.companyOperationDao.searchPerson(infoMap);
    }

    @Override
    public int getEmployeeNumber(String company) {
        return this.companyOperationDao.getEmployeeNumber(company);
    }

    @Override
    public List<String> getDepartment(Map<String, Object> data) {
        String department = (String) data.get("company")+"_"+"department"+"_"+"description";
        return this.companyOperationDao.getDepartment(department);
    }

    @Override
    public int getUserLevel(Map<String, Object> data) {
        HashMap infoMap = new HashMap();
        infoMap.put("company",(String) data.get("company"));
        infoMap.put("userName","'"+(String) data.get("userName")+"'");
        return this.companyOperationDao.getUserLevel(infoMap);
    }

    @Override
    public void addDepartmentOtherDuty(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String apartment = "'"+ (String) data.get("organizationName") +"'";
        String departmentDescription = "'"+ (String) data.get("note") +"'";
        String departmentTableName = (String) data.get("company")+"_"+"department"+"_"+"description";
        String otherDutyTable = (String) data.get("company")+"_"+"otherDuty";
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("userName",userName);
        infoMap.put("departmentDescription",departmentDescription);
        infoMap.put("apartment",apartment);
        infoMap.put("departmentTableName",departmentTableName);
        infoMap.put("otherDutyTable",otherDutyTable);
        this.companyOperationDao.addDepartmentOtherDuty(infoMap);
        this.companyOperationDao.fillDepartmentDescription(infoMap);
    }

    @Override
    public void addTeamOtherDuty(Map<String, Object> data) {
        String company = (String) data.get("company");
        String userName =  "'"+ (String) data.get("userName") +"'";
        String team = "'"+ (String) data.get("organizationName") +"'";
        String teamDescription = "'"+ (String) data.get("note") +"'";
        String department = "'"+ (String) data.get("department") +"'";
        String otherDutyTable = (String) data.get("company")+"_"+"otherDuty";
        String teamTableName = (String) data.get("company")+"_"+"team"+"_"+"description";
        HashMap infoMap = new HashMap();
        infoMap.put("company",company);
        infoMap.put("userName",userName);
        infoMap.put("teamDescription",teamDescription);
        infoMap.put("department",department);
        infoMap.put("team",team);
        infoMap.put("teamTableName",teamTableName);
        infoMap.put("otherDutyTable",otherDutyTable);
        this.companyOperationDao.addTeamOtherDuty(infoMap);
        this.companyOperationDao.fillTeamDescription(infoMap);
    }
}
