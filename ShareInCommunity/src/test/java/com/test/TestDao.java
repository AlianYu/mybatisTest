package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.entity.User;

public class TestDao {
    @Test
    public void FindAll(){
        /**
         * 测试dao
         * 用mysql
         * 要注意spring-mybatis.xml中datasource的数据源的
         * ${jdbc.driver}要和db.properties的等号左边一样
         */
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("config/spring-mybatis.xml");
        UserDao mapper = (UserDao) ac.getBean("userDao");
        List<User> list = mapper.findAll();
        for(User datauser : list) {
            System.out.println(datauser);
        }
    }
}