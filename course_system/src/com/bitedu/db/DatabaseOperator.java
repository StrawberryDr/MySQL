package com.bitedu.db;

import com.bitedu.data.Student;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;

import com.bitedu.data.Take;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperator {
    private static String URL = "jdbc:mysql://localhost/course_system";
    private static String USER = "root";
    private static String PASSWORD = "19990529";
    static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    //插入学生表
    public static void insertStudent(Student stu){
        //获取数据源+获取链接
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = getDataSource().getConnection();
            String sql = "insert into student(sn,name,classid) values(?,?,?)"; //  ?占位符  要对应
            pstmt = connection.prepareStatement(sql); //打印不为null  但是有异常

            //connection.prepareStatement(sql);   //打印为null
            System.out.println(pstmt);
            System.out.println(stu);

            pstmt.setInt(1,stu.getSn());
            pstmt.setString(2,stu.getName());
            pstmt.setInt(3,stu.getClassid());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //查询学生表
    public static Student selectStudent(int sn){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = new Student();
        try {
            connection = getDataSource().getConnection();
            String sql = "select * from student where sn = ?";  //select sn,name.classid from student where sn = ?
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            pstmt.setInt(1,sn);

            rs = pstmt.executeQuery();

            while (rs.next()){
                student.setSn(rs.getInt("sn"));
                student.setName(rs.getString("name"));
                student.setClassid(rs.getInt("classid"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return student;
    }
    //查询学生总人数
    public static int selectStudentCount(){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = new Student();
        try {
            connection = getDataSource().getConnection();
            String sql = "select count(sn) as stu_number from student";  //查询时尽量用主键;  stu_number是别名
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println("count = " + rs.getInt("stu_number"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }
    //group by 子句查询
    public static Take selectScoreGroupBy(int score){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Take take = new Take();
        try {
            connection = getDataSource().getConnection();
            String sql = "select score,count(score) as count_score from student group by score having score>?";
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            pstmt.setInt(1,score);

            rs = pstmt.executeQuery();

            while (rs.next()){
                take.setScore(rs.getInt("score"));
                take.setCount(rs.getInt("count_score"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return take;
    }


    //插入班级表
    //查询班级表

    //插入课程表
    //查询课程表

    //插入教师表
    //查询教师表

    //插入 take
    //查询 take

    //插入 teach
    //查询 teach
}
