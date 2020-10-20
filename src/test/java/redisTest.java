import org.learn.redis.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.redis.entity.Student;
import org.learn.redis.service.StudentService;
import org.learn.redis.utils.RedisFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class)
public class redisTest {
    @Resource
    private StudentService service;


//    Redis test
    @Test
    public void testSetVal() {
        RedisFactory.setVal("key","sno1");
        String result = RedisFactory.getVal("key");
        System.out.println(result);
    }

    @Test
    public void testDelVal() {
        RedisFactory.delVal("key");
        String result = RedisFactory.getVal("key");
        System.out.println(result);
    }

    @Test
    public void testTryGetVal() {
        Student result = service.findBySno(1);
        System.out.println(result);

    }

}
