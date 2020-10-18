package org.learn.redis.dao;

import org.learn.redis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper {
    Student findBySno(@Param("sno") int sno);
}
