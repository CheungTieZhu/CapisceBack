package com.capisceBack.dao;
import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CompanyDao {
    List<Company> getCompanyInfo(@Param("userName")String userName, @Param("userToken")String userToken);
    CompanyDescription getCompanyDescription(@Param("company")String company);
    void setCompanyDescription(@Param("company")String company,@Param("business")String business,@Param("description")String description,@Param("companyIcon")String companyIcon);
    void createCompanyTable(@Param("company")String company);
    void createFunderData(@Param("company")String company,@Param("userName")String userName);
    void fillTheUserData(@Param("company")String company,@Param("userName")String userName);
}
