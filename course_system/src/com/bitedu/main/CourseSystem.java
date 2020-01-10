package com.bitedu.main;

import com.bitedu.data.Student;
import com.bitedu.db.DatabaseOperator;

import javax.sql.DataSource;
import java.util.Scanner;

public class CourseSystem {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        Student stu = new Student();
//        stu.setSn(20190004);
//        stu.setName("香香");
//        stu.setClassid(1);
//
//        DatabaseOperator.insertStudent(stu);

//        Student stu_querey = DatabaseOperator.selectStudent(20190003);
//        System.out.println(stu_querey);

        DatabaseOperator.selectStudentCount();

        /*for(int i = 0;i < 100; i++){
            Student student = new Student();
            student.setSn(20191005+i);
            student.setName("亚瑟"+i);
            if(i % 2 == 0){
                student.setClassid(1);
            }
            else {
                student.setClassid(2);
            }
            DatabaseOperator.insertStudent(student);
        }*/  //循环插入

    }
}
