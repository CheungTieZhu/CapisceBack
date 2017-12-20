package com.capisceBack.controller;
import com.capisceBack.service.UserService;
import com.capisceBack.model.User;
import com.capisceBack.util.Response;
import com.capisceBack.util.ResponseFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> userLogin(@RequestParam("userName") String userName,
                                  @RequestParam("password") String password) throws IOException {
        //初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        String errorMsg = null;
        String result = Response.RESPONSE_RESULT_ERROR;
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
    Map<String, Object> userRegister(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("deviceToken") String deviceToken) throws IOException {

        //初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.userService.userRegister(userName, password, phone, deviceToken);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
}