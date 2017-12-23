package com.capisceBack.controller;
import com.capisceBack.service.UserService;
import com.capisceBack.model.User;
import com.capisceBack.util.Response;
import com.capisceBack.util.ResponseFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.json.JsonArray;

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
        String errorMsg = null;
        String result = Response.RESPONSE_RESULT_ERROR;
        String userName = (String) data.get("userName");
        String password = (String) data.get("password");
        User user = this.userService.userLogin(userName,password);

        if (user==null){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(user);
        }else{
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(user);
            this.userService.updateLoginTime();
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
        try {
            this.userService.userRegister(userName, password, phone, deviceToken);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            result = Response.RESPONSE_RESULT_ERROR;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
}