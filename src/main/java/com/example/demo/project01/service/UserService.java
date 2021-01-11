package com.example.demo.project01.service;


import com.example.demo.project01.pojo.Resulet;
import com.example.demo.project01.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

     List<User> getAllUsers();

     Resulet login(@Param("name")String name,@Param("password")String password);

     Resulet register(@Param("name")String name,@Param("password")String password);

     Resulet deleteById(@Param("id")int id);

     Resulet deleteByName(@Param("id")String name);

}
