package com.capisceBack.dao;
import com.capisceBack.model.OtherUser;
import com.capisceBack.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    User userLogin(@Param("userName")String userName,@Param("password")String password);
    void updateLoginTime(@Param("userMap")HashMap userMap);
    void userRegister(@Param("userMap")HashMap userMap);
    void userLogOut(@Param("userMap")HashMap userMap);
    User getUserInfo(@Param("userName")String userName,@Param("userToken")String userToken);
    List<OtherUser> getOtherUserInfo(@Param("realName")String realName);
}
