package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.mapper.UserMapper;
import com.offcn.pojo.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Resource
    private UserMapper userMapper;


    @RequestMapping("/list")
    public List<User> lookList(){

        return userDao.findAll();
    }
    @RequestMapping("/user/list3")
    public List<MUser> getUserList3(){
        List<MUser> userList = userMapper.getUserList();
        return userList;
    }

}
