package com.capisceBack.model;

import java.util.Date;

public class Notification {

    private String company;
    private Date requestTime;
    private int request;
    private int accept;
    private String userName;
    private String senderUserName;
    private String userHeadImage;
    private String companyIcon;
    private String realName;
    private int id;
    private int senderAccept;

    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public Date getRequestTime(){
        return requestTime;
    }
    public void setRequestTime(Date requestTime){
        this.requestTime = requestTime;
    }
    public int getRequest(){
        return request;
    }
    public void setRequest(int request){
        this.request = request;
    }
    public int getAccept(){
        return accept;
    }
    public void setAccept(int accept){
        this.accept = accept;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getSenderUserName(){
        return senderUserName;
    }
    public void setSenderUserName(String senderUserName){
        this.senderUserName = senderUserName;
    }
    public String getUserHeadImage(){
        return userHeadImage;
    }
    public void setUserHeadImage(String userHeadImage){
        this.userHeadImage = userHeadImage;
    }
    public String getCompanyIcon(){
        return companyIcon;
    }
    public void setCompanyIcon(String companyIcon){
        this.companyIcon = companyIcon;
    }
    public String getRealName(){
        return realName;
    }
    public void setRealName(String realName){
        this.realName = realName;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getSenderAccept(){
        return senderAccept;
    }
    public void setSenderAccept(int senderAccept){
        this.senderAccept = senderAccept;
    }
}
