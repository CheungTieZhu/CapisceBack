package com.capisceBack.controller;
import com.capisceBack.model.Company;
import com.capisceBack.model.OtherUser;
import com.capisceBack.service.UserService;
import com.capisceBack.model.User;
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
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userLogin(@RequestBody Map<String, Object> data) throws IOException {
        //初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        String userName = (String) data.get("userName");
        String password = (String) data.get("password");
        User user = this.userService.userLogin(userName,password);
        if (user==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(null);
        }else{
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(user);
            this.userService.updateLoginTime(userName);
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userRegister(@RequestBody Map<String, Object> data) throws IOException {

        //初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        String userName = (String) data.get("userName");
        String password = (String) data.get("password");
        String phone = (String) data.get("phone");
        String deviceToken = (String) data.get("deviceToken");
        String registerStatus = (String) data.get("registerStatus");
        try {
            this.userService.userRegister(userName, password, phone, deviceToken,registerStatus);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> userGetInfo(@Param("userName") String userName,
                                  @Param("userToken") String userToken) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        User user = this.userService.getUserInfo(userName,userToken);
        if (user==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(null);
        }else{
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(user);
        }
        return responseContent.generateResponse();
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> userLogOut(@Param("userName") String userName) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.userService.userLogOut(userName);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/getOther", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getOtherUserInfo(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        String realName = (String) data.get("realName");
        List<OtherUser> otherUserInfo = this.userService.getOtherUserInfo(realName);
        if (otherUserInfo.size()==0){
            OtherUser nullShow = new OtherUser();
            nullShow.setUsername("未找到用户");
            nullShow.setRegisterStatus("    ");
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