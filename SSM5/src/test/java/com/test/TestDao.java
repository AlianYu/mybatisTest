package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.entity.User;

public class TestDao {
    @Test
    public void FindByUsername(){
        /**
         * 测试dao
         * 遇到的问题：Oracle数据库insert数据后要commit
         */

        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("config/spring-mybatis.xml");
        UserDao mapper = (UserDao) ac.getBean("userDao");
        System.out.println(mapper);
        User user = mapper.FindByUsername("tom");
        System.out.println(user);
        List<User> list = mapper.findAll();

        for(User datauser : list) {
            System.out.println(datauser);
        }

    }
}
