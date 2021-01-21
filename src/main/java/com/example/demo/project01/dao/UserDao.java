package com.example.demo.project01.dao;


import com.example.demo.project01.pojo.Resulet;
import com.example.demo.project01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface UserDao { //

    List<User> getAllUsers();

    User login(@Param("name")String name, @Param("password")String password);

    int register(@Param("name")String name,@Param("password")String password);

    User selectUserByName(@Param("name")String name);

    int deleteById(@Param("id")int id);

    int deleteByName(@Param("name")String name);

    int addTime(@Param("date") Date date);
}
