package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;

public class MybatisTest {
    public static void main(String[] args) {
      //构建配置文件的输入流
        InputStream input;
        try {
            input = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(input);
            SqlSession sqlSession = sqlSessionFactory.openSession();

           /* List<User> users = sqlSession.selectList("com.dao.UserDao.findAll");
            for(User user : users) {
                System.out.println(user);
            }*/
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            //查找所有用户
            List<User> users = mapper.findAll();
            for(User user : users) {
                System.out.println(user);
            }
            //查找单个用户
            User user = mapper.findById(1);
            System.out.println(user);
            sqlSession.close();

        } catch (IOException e) {

            e.printStackTrace();
        }



    }

}
