package org.learn.redis.service;

import org.learn.redis.entity.Student;

public interface StudentService {
    Student findBySno(int sno);
}
