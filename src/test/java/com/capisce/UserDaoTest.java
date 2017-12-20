package com.capisce;

import com.capisceBack.dao.UserDao;
import com.capisceBack.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        String userName = "admin";
        String password = "admin";
        User user = dao.userLogin(userName,password);
        System.out.println(user.getUserName());
    }
}
