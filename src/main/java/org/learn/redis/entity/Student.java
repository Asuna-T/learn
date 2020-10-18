package org.learn.redis.entity;

public class Student {
    private int sno;
    private String name;
    private int age;

    //构造函数
    public Student() {

    }

    public Student(int sno, String name, int age) {
        this.sno = sno;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{"   +
                "sno="      + sno   +
                ", name='"  + name  +
                "', age="   + age   +
                '}';
    }
}
