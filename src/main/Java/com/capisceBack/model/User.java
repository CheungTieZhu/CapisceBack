package com.capisceBack.model;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
public class User {
    private int id;
    private String realName;
    private String userName;
    private String phone;
    private Date loginTime;
    private Date logOutTime;
    private Bool isLogin;
    private String deviceToken;
    private String userToken;

    public  int getId(){
        return  id;
    }
    public void setId(){
        this.id = id;
    }
    public String getRealName(){
        return realName;
    }
    public void setLogOutTime(){
        this.realName = realName;
    }
    public String getUserName(){
        return userName;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getLoginTime(){
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public Date getLogOutTime(){
        return logOutTime;
    }
    public void setLoginOutTime(Date logOutTime) {
        this.logOutTime = logOutTime;
    }
    public Bool getIsLogin(){
        return isLogin;
    }
    public void setIsLogin(Bool isLogin) {
        this.isLogin = isLogin;
    }
    public String getDeviceToken(){
        return deviceToken;
    }
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
    public String getUserToken(){
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
