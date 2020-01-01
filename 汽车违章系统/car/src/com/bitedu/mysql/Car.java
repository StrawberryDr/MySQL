package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//设计一个车辆违章系统，包含用户表，车辆表，违章信息表。违章信息表中包含用户和车辆的违章信息

public class Car {
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
            stmt.execute("create database Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}