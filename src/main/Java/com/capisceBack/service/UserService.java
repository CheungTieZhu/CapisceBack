package com.capisceBack.service;
import com.capisceBack.model.User;

public interface UserService {
    public User userLogin(String userName,String password);
    public void updateLoginTime(String userName);
    public void userRegister(String userName,String password,String phone,String deviceToken);
    public User getUserInfo(String userName,String userToken);
    public void userLogOut(String userName);
}
