package com.example.demo.project01.controller;

import com.example.demo.project01.dao.UserDao;
import com.example.demo.project01.pojo.Resulet;
import com.example.demo.project01.pojo.User;
import com.example.demo.project01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;


/**
 * @ClassName UserController
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/6 14:48
 * @Version 1.0
 **/

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/loginIn")
    public String welcome(String name,String password){

        Resulet resulet =  userService.login(name,password);
        if (resulet.getStatus()==200){
            String token = UUID.randomUUID()+"";
            redisTemplate.opsForValue().set(token,resulet.getObject(),Duration.ofMinutes(30L));
            return "loginSuccess";
        }
        return "errorPage";
    }


    @RequestMapping("/register")
    public String register(String name, String password, Model model){

        Resulet resulet=new Resulet();

        User user=userDao.selectUserByName(name);
        if (user==null){
            int a = userDao.register(name,password);
            if (a>0){
                resulet.setMsg("注册成功");
            }
        }else {
            resulet.setMsg("用户名已存在,请重新输入");
        }
        model.addAttribute(resulet);
        return "regSuccess";

    }


    @RequestMapping("/getAllUsers")
    @ResponseBody
    public String getAllUsers(){

        return userService.getAllUsers().toString();

    }


    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(int id){

        Resulet resulet=userService.deleteById(id);
        return resulet.getMsg();

    }

    @RequestMapping("/deleteByName")
    @ResponseBody
    public String deleteByName(String name ){

        Resulet resulet=userService.deleteByName(name);
        return resulet.getMsg();

    }


    @RequestMapping("/redisTemplate")
    @ResponseBody
    public String redisTemplate(){
        redisTemplate.opsForValue().set("yuanhao","24", Duration.ofMinutes(30L));
        return "存储成功";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Boolean logout(HttpServletRequest request){

        String token = request.getHeader("token");
        Boolean delete  = redisTemplate.delete(token);

        return delete;
    }

    @RequestMapping("/tableSystem")

    public String tableSystem(){
        return "shangewanggeSystem";
    }

    @RequestMapping("/time")
    @ResponseBody
    public String time(){

        return userService.addTime(new Date()).getMsg();
    }

}
