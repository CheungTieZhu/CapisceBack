package com.capisceBack.controller;

import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.service.CompanyOperationService;
import com.capisceBack.util.Response;
import com.capisceBack.util.ResponseFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/companyOperation")
public class CompanyOperationController {
    @Resource
    private CompanyOperationService companyOperationService;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getCompanyInfo(@Param("company") String company) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        CompanyDescription companyDescription = this.companyOperationService.getCompanyInfo(company);
        if (companyDescription==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(null);
        }else {
                result = Response.RESPONSE_RESULT_SUCCESS;
                responseContent.setResponseMsg(result);
                responseContent.setResponseData(companyDescription);
            }

        return responseContent.generateResponse();
    }

}
