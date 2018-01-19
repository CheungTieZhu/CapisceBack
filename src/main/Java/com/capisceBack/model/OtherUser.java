package com.capisceBack.model;

public class OtherUser {
    private String userName;
    private String registerStatus;
    private String headImageUrl;
    private String realName;

    public String getUserName(){
        return userName;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getRegisterStatus(){
        return registerStatus;
    }
    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }
    public String getHeadImageUrl(){
        return headImageUrl;
    }
    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }
    public String getRealName(){
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
}
