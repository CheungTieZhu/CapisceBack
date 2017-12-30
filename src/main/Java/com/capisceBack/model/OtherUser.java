package com.capisceBack.model;

public class OtherUser {
    private String userName;
    private String registerStatus;
    private String headImageUrl;

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
}
