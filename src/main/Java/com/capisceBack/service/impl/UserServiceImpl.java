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

    public void updateLoginTime() {
        Date loginTime = new Date();
        this.userDao.updateLoginTime(loginTime);
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
}
