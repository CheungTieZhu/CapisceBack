package com.capisceBack.service.impl;
import com.capisceBack.dao.UserDao;
import com.capisceBack.model.OtherUser;
import com.capisceBack.model.User;
import com.capisceBack.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
 class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    public User userLogin(String userName,String password){
        return this.userDao.userLogin(userName,password);
    }

    public void updateLoginTime(String userName) {
        Date loginTime = new Date();
        HashMap<String,Object> userMap = new  HashMap<String,Object>();
        userMap.put("userName",userName);
        userMap.put("loginTime",loginTime);
        this.userDao.updateLoginTime(userMap);
    }


    public void userRegister(String userName, String password, String phone, String deviceToken,String registerStatus) {
        Date loginTime = new Date();
        HashMap<String,Object> userMap = new  HashMap<String,Object>();
        userMap.put("userName",userName);
        userMap.put("password",password);
        userMap.put("phone",phone);
        userMap.put("deviceToken",deviceToken);
        userMap.put("loginTime",loginTime);
        userMap.put("registerStatus",registerStatus);
        this.userDao.userRegister(userMap);
    }

    public User getUserInfo(String userName,String userToken){
        return this.userDao.getUserInfo(userName,userToken);
    }

    public void userLogOut(String userName){
        Date loginTime = new Date();
        HashMap<String,Object> userMap = new  HashMap<String,Object>();
        String userToken  = loginTime.toString()+userName+"CapisceDuangDuang";
        userMap.put("loginTime",loginTime);
        userMap.put("userName",userName);
        userMap.put("userToken",userToken);
        this.userDao.userLogOut(userMap);
    }
    public List<OtherUser> getOtherUserInfo(Map<String, Object> data){
        data.put("realName","%"+(String)data.get("realName")+"%");
        return this.userDao.getOtherUserInfo(data);
    }

    @Override
    public void userHeadImgEdit(String userName, String headImgUrl) {
        this.userDao.userHeadImgEdit(userName,headImgUrl);
        this.userDao.notificationUserHeadImgEdit(userName,headImgUrl);
    }

    @Override
    public void synchronizedCompanyTable(String company,String userName, String headImgUrl) {
        userName = "'"+userName+"'";
        headImgUrl = "'"+headImgUrl+"'";
        this.userDao.synchronizedCompanyTable(company,userName,headImgUrl);
    }

    @Override
    public List<String> getUserCompany(String userName) {
        return this.userDao.getUserCompany(userName);
    }

    @Override
    public void editUserRealName(String userName, String realName) {
        this.userDao.editUserRealName(userName,realName);
        this.userDao.editOrginalTable(userName,realName);
    }

    @Override
    public void synchronizedCompanyTableRealName(String company, String userName, String realName) {
        userName = "'"+userName+"'";
        realName = "'"+realName+"'";
        this.userDao.synchronizedCompanyTableRealName(company,userName,realName);
    }
}
