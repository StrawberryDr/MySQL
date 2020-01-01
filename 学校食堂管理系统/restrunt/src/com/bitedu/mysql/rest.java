package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//设计一个学校食堂管理系统，包含食堂表，食堂仓口表，仓口收费记录表

public class rest {
    public static void main(String[] args) {
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取一个连接
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/",  //URL统一资源定位器
                            "root",
                            "19990529");
            //获取操作数据库的对象
            Statement stmt = connection.createStatement();
            //操作数据库
            stmt.execute("create database restrunt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
