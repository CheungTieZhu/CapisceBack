package com.capisceBack.dao;

import com.capisceBack.model.CompanyDescription;
import org.apache.ibatis.annotations.Param;

public interface CompanyOperationDao {
    CompanyDescription getCompanyInfo(@Param("company")String company);
}
