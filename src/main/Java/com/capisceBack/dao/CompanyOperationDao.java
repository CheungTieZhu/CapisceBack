package com.capisceBack.dao;

import com.capisceBack.model.CompanyDescription;
import com.capisceBack.model.OtherUser;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompanyOperationDao {
    CompanyDescription getCompanyInfo(@Param("company")String company);
    void registerNewMember(@Param("company")String company,@Param("userName")String userName,@Param("realName")String realName,@Param("headImageUrl")String headImageUrl);
    void addDepartment(@Param("infoMap")HashMap infoMap);
    void addTeam(@Param("infoMap")HashMap infoMap);
    List<OtherUser> searchPerson(@Param("infoMap") HashMap infoMap);
    void fillUserOrganization(@Param("data")Map<String, Object> data);
    int getEmployeeNumber(@Param("company")String company);
    List<String> getDepartment(@Param("department") String department);
    void fillDepartmentDescription(@Param("infoMap")HashMap infoMap);
    void fillTeamDescription(@Param("infoMap")HashMap infoMap);
    int getUserLevel(@Param("infoMap")HashMap infoMap);
    void addDepartmentOtherDuty(@Param("infoMap")HashMap infoMap);
    void addTeamOtherDuty(@Param("infoMap")HashMap infoMap);
}
