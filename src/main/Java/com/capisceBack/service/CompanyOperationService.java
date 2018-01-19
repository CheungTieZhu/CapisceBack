package com.capisceBack.service;

import com.capisceBack.model.CompanyDescription;
import com.capisceBack.model.OtherUser;

import java.util.List;
import java.util.Map;

public interface CompanyOperationService {
    public CompanyDescription getCompanyInfo(String company);
    public void registerNewMember(Map<String, Object> data);
    public void addDepartment(Map<String, Object> data);
    public void addTeam(Map<String, Object> data);
    public List<OtherUser> searchPerson(Map<String, Object> data);
    public int getEmployeeNumber(String company);
    public List<String> getDepartment(Map<String, Object> data);
    public int getUserLevel(Map<String, Object> data);
    public void addDepartmentOtherDuty(Map<String, Object> data);
    public void addTeamOtherDuty(Map<String, Object> data);
}
