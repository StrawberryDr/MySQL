package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//1、设计一个考勤系统，包含员工表，考勤记录表

//2、设计一个学校宿舍管理系统，要求包含宿舍信息，学生信息，每日的宿舍查房记录。

//3、设计一个车辆违章系统，包含用户表，车辆表，违章信息表。违章信息表中包含用户和车辆的违章信息

//4、设计一个学校食堂管理系统，包含食堂表，食堂仓口表，仓口收费记录表

public class helloworld {
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
            stmt.execute("drop database newsql");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
