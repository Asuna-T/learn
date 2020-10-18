package com.shtel.jdbc.service;

import com.shtel.jdbc.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();//查询所有
    void search(int sno);//指定查询
    void alter(Student student);//修
    void delete(int sno);//删
}
