package com.capisceBack.controller;
import com.capisceBack.dao.CompanyDao;
import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.service.CompanyService;
import com.capisceBack.util.Response;
import com.capisceBack.util.ResponseFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getCompanyInfo(@Param("userName") String userName,
                                       @Param("userToken") String userToken) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        List<Company> company = this.companyService.getCompanyInfo(userName,userToken);

        if (company.size()==0){
            Company nullShow = new Company();
            nullShow.setApartment("UNKNOWN");
            nullShow.setCompany("UNKNOWN");
            nullShow.setLevel(0);
            nullShow.setTeam("UNKNOWN");
            nullShow.setCompanyIcon("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514518660457&di=54c4f4c1310637784b0a742a8b367e17&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1268385509%2C2707822519%26fm%3D214%26gp%3D0.jpg");
            company.add(nullShow);
        }
        try {
            result = Response.RESPONSE_RESULT_SUCCESS;
            HashMap companyMap = new HashMap();
            companyMap.put("company", company);
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(companyMap);
        }catch (Exception e){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(e.getMessage());
        }

        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/getCompanyDescription", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getCompanyDescription(@Param("company") String company) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        CompanyDescription companyDescription = this.companyService.getCompanyDescription(company);
        if (companyDescription==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(null);
        }else{
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(companyDescription);
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/createCompany", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> createCompany(@Param("company") String company,
                                      @Param("business") String business,
                                      @Param("description") String description,
                                      @Param("description") String companyIcon,
                                      @Param("userName") String userName) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.companyService.createCompany(company, business, description, companyIcon,userName);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
}
