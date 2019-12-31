package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//1、设计一个考勤系统，包含员工表，考勤记录表

public class attendance {
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
            stmt.execute("create database attendance");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
