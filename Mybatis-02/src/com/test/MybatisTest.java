package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.User;

public class MybatisTest {
    public static void main(String[] args) {
      //构建配置文件的输入流
        InputStream input;
        try {
            input = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(input);
            SqlSession session = sqlSessionFactory.openSession();

            List<User> users = session.selectList("com.dao.UserDao.findAll");
            for(User user : users) {
                System.out.println(user);
            }

            session.close();

        } catch (IOException e) {

            e.printStackTrace();
        }



    }

}
