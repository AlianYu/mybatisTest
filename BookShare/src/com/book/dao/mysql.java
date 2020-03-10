package com.book.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.book.exception.DBException;

public class mysql {
    //配置参数
    private static String driverName = null;
    private static String url = null;
    private static String userName = null;
    private static String password = null;
    
    //注册驱动程序，只需要注册一次。静态代码块
    static {
        try {
            
            /*读取db.properties配置文件*/
            //1)创建Properties对象
            Properties prop = new Properties();
            //2)构建配置文件的输入流
            InputStream input = mysql.class.getResourceAsStream("/db.properties"); 
            
            //3)加载Properties对象
            prop.load(input);
            
            //4)读取配置数据
            driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            
            //关闭输入流
            input.close();
            
            //5)加载驱动
            Class.forName(driverName);
            
        } catch (ClassNotFoundException e) {
            System.out.println("加载mysql-JDBC驱动错误");
        }catch(IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    //获取连接对象
    public static Connection getConn() {
        Connection conn=null;
        try {
            
            System.out.println("连接数据库中...");
            conn = DriverManager.getConnection(url,userName,password);
            System.out.println("已获取连接");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new DBException();
            
        }
        return conn;
    }
    //释放资源的方法
        public static void close(Connection conn,Statement stmt,ResultSet rs) {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    
    public static void main(String[] args) {
        
    
         // 注册 JDBC 驱动
        try {
            Class.forName(driverName);
              // 打开链接
            System.out.println("连接数据库...");
            Connection conn = DriverManager.getConnection(url,userName,password);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
           Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from t";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
              
                String name = rs.getString("username");
                String url = rs.getString("passwd");
                // 输出数据
                
                System.out.print("姓名" + name);
                System.out.print("密码 " + url);
                System.out.print("\n");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
      

    }
}
