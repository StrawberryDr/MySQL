package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//设计一个学校宿舍管理系统，要求包含宿舍信息，学生信息，每日的宿舍查房记录

public class dormitory {
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
            stmt.execute("create database dormitory");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
