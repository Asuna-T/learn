package com.shtel.jdbc.service;

import com.shtel.jdbc.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServImpl implements StudentService {
    private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private String username = "root";
    private String password = "PAAS";





    private static String sql3=" delete from student where student.sno=?";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        List<Student> userList = new ArrayList<Student>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        String sql = "select * from student";

        try {
            // 2 获得数据库链接
            conn = DriverManager.getConnection(url, username, password);
            // 3 获取sql语句
            pstmt = conn.prepareStatement(sql);
            // 4 执行
            rst = pstmt.executeQuery();
            while (rst.next()) {
                Student student = new Student();
                student.setSno(rst.getInt("sno"));
                student.setName(rst.getString("name"));
                student.setAge(rst.getInt("age"));

                userList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rst);
        }

        return userList;
    }

    public void search(int sno){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst=null;
        String sql= "select * from student where student.sno=?";
        try {
            conn = DriverManager.getConnection(url,username,password);
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,sno);
            rst = pstmt.executeQuery();
            while(rst.next()){
                System.out.println("学号是:"+rst.getString("sno"));
                System.out.println("姓名是："+rst.getString("name"));
                System.out.println("年龄是："+rst.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void alter(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update student set Age='" + student.getAge() + "' where sno='" + student.getSno() + "'";
        try {
            conn = DriverManager.getConnection(url,username,password);
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql=" delete from student where student.sno='"+sno+"'";
        try {
            conn = DriverManager.getConnection(url,username,password);
            pstmt= conn.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rst) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException e) {
                rst = null;
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                pstmt = null;
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                conn = null;
                e.printStackTrace();
            }
        }
    }
}
