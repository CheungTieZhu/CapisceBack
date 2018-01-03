package com.capisceBack.service;
import com.capisceBack.model.OtherUser;
import com.capisceBack.model.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    public User userLogin(String userName,String password);
    public void updateLoginTime(String userName);
    public void userRegister(String userName,String password,String phone,String deviceToken,String registerStatus);
    public User getUserInfo(String userName,String userToken);
    public void userLogOut(String userName);
    public List<OtherUser> getOtherUserInfo(Map<String, Object> data);
    public void userHeadImgEdit(String userName,String headImgUrl);
    public void synchronizedCompanyTable(String company,String userName,String headImgUrl);
    public List<String> getUserCompany(String userName);
    public void editUserRealName(String userName,String realName);
    public void synchronizedCompanyTableRealName(String company,String userName,String realName);
}
