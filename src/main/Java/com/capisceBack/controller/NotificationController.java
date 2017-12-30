package com.capisceBack.controller;

import com.capisceBack.model.Notification;
import com.capisceBack.service.NotificationService;
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
@RequestMapping("/notification")
public class NotificationController {
    @Resource
    private NotificationService notificationService;
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> sendNotification(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.notificationService.sendNotification(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getNotification(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        List<Notification> notification = this.notificationService.getNotification(data);
        try {
            result = Response.RESPONSE_RESULT_SUCCESS;
            HashMap notificationMap = new HashMap();
            notificationMap.put("notification", notification);
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(notificationMap);
        }catch (Exception e){
            responseContent.setResponseMsg(result);
            responseContent.setResponseData(e.getMessage());
        }
        return responseContent.generateResponse();
    }

    @RequestMapping(value = "/userLocalAction", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userLocalAction(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.notificationService.userLocalAction(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }

    @RequestMapping(value = "/userGlobalAction", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userGlobalAction(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.notificationService.userGlobalAction(data);
            result = Response.RESPONSE_RESULT_SUCCESS;
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(result);
        }catch (Exception e){
            responseContent.setResponseResult(result);
            responseContent.setResponseMsg(e.getMessage());
        }
        return responseContent.generateResponse();
    }
    @RequestMapping(value = "/senderIgnore", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> senderIgnore(@RequestBody Map<String, Object> data) throws IOException {
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        try {
            this.notificationService.senderIgnore(data);
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
