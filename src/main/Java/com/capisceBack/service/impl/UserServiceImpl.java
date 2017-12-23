package com.capisceBack.service.impl;
import com.capisceBack.dao.UserDao;
import com.capisceBack.model.User;
import com.capisceBack.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Service("userService")
public class UserServiceImpl implements UserService{
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


    public void userRegister(String userName, String password, String phone, String deviceToken) {
        Date loginTime = new Date();
        HashMap<String,Object> userMap = new  HashMap<String,Object>();
        userMap.put("userName",userName);
        userMap.put("password",password);
        userMap.put("phone",phone);
        userMap.put("deviceToken",deviceToken);
        userMap.put("loginTime",loginTime);
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
}
