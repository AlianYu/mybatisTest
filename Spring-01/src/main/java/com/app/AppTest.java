package com.app;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.action.UserAction;

public class AppTest {

    @Test
    public void test1() {
        UserAction ua = new UserAction();
        ua.save();
    }

    @Test
    public void test2() {
    //1)希望从 spring的IOC容器中去取 UserAction对象,先 创建容器(手动创建)

        ApplicationContext ac = new
                ClassPathXmlApplicationContext("spring.xml");

        //2)从ioc容器中获取 对象
        UserAction action = (UserAction) ac.getBean("userAction");

        action.save();

    }

}
