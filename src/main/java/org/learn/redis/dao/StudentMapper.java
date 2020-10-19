package org.learn.redis.dao;

import org.learn.redis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentMapper {
    Student findBySno(@Param("sno") int sno);
}
