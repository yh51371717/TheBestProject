package com.example.demo.project01.service;


import com.example.demo.project01.dao.UserDao;

import com.example.demo.project01.pojo.Resulet;
import com.example.demo.project01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImp
 * @Deacription User的服务层
 * @Author 袁昊
 * @Date 2021/1/6 14:59
 * @Version 1.0
 **/

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(value = "users",key = "'getAllUsers'")
    public List<User> getAllUsers() {

        System.out.println("进入到service调用查询方法了");

        return userDao.getAllUsers();
    }


    @Override
    @CacheEvict(value = "users",allEntries = true)
    public Resulet deleteById(int id) {
        Resulet resulet=new Resulet();
        int a =userDao.deleteById(id);
        if (a>0){
            resulet.setMsg("删除成功");
        }else {
            resulet.setMsg("删除失败");
        }
        return resulet;
    }

    @Override
    public Resulet deleteByName(String name) {
        Resulet resulet=new Resulet();
        int a =userDao.deleteByName(name);
        if (a>0){
            resulet.setMsg("删除成功");
        }else {
            resulet.setMsg("删除失败");
        }
        return resulet;
    }

    @Override
    public Resulet login(String name, String password) {
        User user=userDao.login(name,password);
        Resulet resulet=new Resulet();
        if (user==null){
            resulet.setStatus(404);
            resulet.setMsg("用户名密码不存在！");
        }else {
            resulet.setStatus(200);
            resulet.setObject(user);
            resulet.setMsg("登陆成功");
        }
         return resulet;
    }

    @Override
    public Resulet register(String name, String password) {
        Resulet resulet=new Resulet();

        User user =userDao.selectUserByName(name);

        if (user==null){
           int a = userDao.register(name,password);
           if (a>0){
               resulet.setMsg("注册成功");
           }
        }else {
            resulet.setMsg("用户名已存在,请重新输入");
        }
        return resulet;
    }




}
