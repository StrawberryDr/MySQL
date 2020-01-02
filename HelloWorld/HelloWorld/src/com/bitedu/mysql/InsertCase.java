package com.bitedu.mysql;

import java.sql.*;

public class InsertCase {
    public static void createTable(){
        Statement stmt = null;
        Connection connection = null;
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            connection = DriverManager.getConnection
                    (
                            "jdbc:mysql://localhost/newsql",
                            "root",
                            "19990529"
                    );
            //创建语句对象
            stmt = connection.createStatement();
            //执行
            String sql = "create table jdbctable(col1 int,col2 varchar(20))";
            stmt.execute(sql);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭
        finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void insertIntoTable(){
        Statement stmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            connection = DriverManager.getConnection
                    (
                            "jdbc:mysql://localhost/newsql",
                            "root",
                            "19990529"
                    );
            //创建语句对象
            stmt = connection.createStatement();
            //执行
            String sql = "select * from jdbctable";
            rs = stmt.executeQuery(sql);  //executeQuery  查询结果集
            while (rs.next()){
                Integer col1 = rs.getInt("col1");
                String col2 = rs.getString("col2");
                System.out.println("col1 = "+col1 + " col2 = "+col2);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭
        finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //createTable();
        insertIntoTable();
    }
}
