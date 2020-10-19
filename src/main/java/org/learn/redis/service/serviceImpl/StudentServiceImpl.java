package org.learn.redis.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.learn.redis.dao.StudentMapper;
import org.learn.redis.entity.Student;
import org.learn.redis.service.StudentService;
import org.learn.redis.utils.RedisFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper sMapper;
    @Override
    public Student findBySno(int sno) {
        String studentInfo = RedisFactory.getVal(String.valueOf(sno));
        if (studentInfo != null && studentInfo.length()!= 0) {
            System.out.println("在Redis找到");
            return JSONObject.parseObject(studentInfo, Student.class) ;
        } else {
            System.out.println("未能在Redis中找到，搜寻数据库");
            Student stu = sMapper.findBySno(sno);
            RedisFactory.setVal(String.valueOf(sno), JSONObject.toJSONString(stu), 30);
            return stu;
        }
    }
}
