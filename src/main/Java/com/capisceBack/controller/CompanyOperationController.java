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

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getCompanyInfo(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        String company = (String) data.get("company");
        CompanyDescription companyDescription = this.companyOperationService.getCompanyInfo(company);
        if (companyDescription==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(null);
        }else {
                int employeeNumber = this.companyOperationService.getEmployeeNumber(company);
                companyDescription.setEmployeeNumber(employeeNumber);
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
    @RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addDeppartment(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        int request = (int) data.get("request");
        int level = this.companyOperationService.getUserLevel(data);
        try {
            if (request == 0) {
                if (level < 2) {
                    this.companyOperationService.addDepartment(data);
                }else{
                    this.companyOperationService.addDepartmentOtherDuty(data);
                }
            }else{
                if (level < 1) {
                    this.companyOperationService.addTeam(data);
                }else{
                    this.companyOperationService.addTeamOtherDuty(data);
                }

            }
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

    @RequestMapping(value = "/getDepartment", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getDepartment(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;

        try {
            result = Response.RESPONSE_RESULT_SUCCESS;
            List<String> department = this.companyOperationService.getDepartment(data);
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(department);
        }catch (Exception e){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(e.getMessage());
        }
        return responseContent.generateResponse();
    }

}
