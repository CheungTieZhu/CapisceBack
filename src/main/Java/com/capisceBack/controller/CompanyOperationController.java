package com.capisceBack.controller;

import com.capisceBack.model.Company;
import com.capisceBack.model.CompanyDescription;
import com.capisceBack.model.OtherUser;
import com.capisceBack.service.CompanyOperationService;
import com.capisceBack.util.Response;
import com.capisceBack.util.ResponseFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(value = "/agree", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> registerNewMember(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.companyOperationService.registerNewMember(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/addDeppartment", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addDeppartment(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.companyOperationService.addDeppartment(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addTeam(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.companyOperationService.addTeam(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/searchPerson", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> searchPerson(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        List<OtherUser> otherUserInfo = this.companyOperationService.searchPerson(data);
        if (otherUserInfo.size()==0){
            OtherUser nullShow = new OtherUser();
            nullShow.setUsername("未找到用户");
            otherUserInfo.add(nullShow);
        }
        try {
            result = Response.RESPONSE_RESULT_SUCCESS;
            HashMap otherUserMap = new HashMap();
            otherUserMap.put("multipleUser", otherUserInfo);
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(otherUserMap);
        }catch (Exception e){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(e.getMessage());
        }
        return responseContent.generateResponse();
    }


}
