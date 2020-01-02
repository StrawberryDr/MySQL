package com.bitedu.mysql;

import java.sql.*;
import java.util.Scanner;

public class helloworld1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/",
                            "root",
                            "19990529");
            Statement stmt = connection.createStatement();
            //操作数据库
            stmt.execute("drop database my_jdbc_db");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
