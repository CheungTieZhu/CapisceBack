package com.capisceBack.dao;
import com.capisceBack.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;

public interface UserDao {
    User userLogin(@Param("userName")String userName,@Param("password")String password);
    void updateLoginTime(@Param("userMap")HashMap userMap);
    void userRegister(@Param("userMap")HashMap userMap);
    void userLogOut(@Param("userMap")HashMap userMap);
    User getUserInfo(@Param("userName")String userName,@Param("userToken")String userToken);
}
