package com.offcn;

import com.offcn.mapper.UserMapper;
import com.offcn.pojo.MUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =HelloApplication.class )
public class Apptest {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void getUserList(){
        List<MUser> userList = userMapper.getUserList();
        for(MUser user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void test02(){
        redisTemplate.opsForValue().set("hello","0708java");
        String hello =(String) redisTemplate.opsForValue().get("hello");
        System.out.println(hello);
        MUser user= new MUser();
        user.setUid(1);
        user.setUname("张三");
        user.setPwd("123");
        redisTemplate.opsForValue().set("user",user);
        MUser user1 = (MUser)redisTemplate.opsForValue().get("user");
        System.out.println(user1);

    }
}
