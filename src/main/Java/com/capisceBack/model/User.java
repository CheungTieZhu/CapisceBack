package com.capisceBack.model;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
public class User {
    private String userName;
    private String password;
    private String phone;
    private Date loginTime;
    private Date logOutTime;
    private Bool isLogin;
    private String deviceToken;
    private String userToken;

    public String getUserName(){
        return userName;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
