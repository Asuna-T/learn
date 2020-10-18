package com.shtel.jdbc;

import com.shtel.jdbc.entity.Student;
import com.shtel.jdbc.service.StudentServImpl;
import com.shtel.jdbc.service.StudentService;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        StudentService studentService= new StudentServImpl();
        studentService.search(1);
        studentService.alter(new Student(110,"",16) );
        studentService.delete(111);
        List<Student> all=studentService.findAll();
        for(Student student : all){
            System.out.println(student);
        }
    }
}
