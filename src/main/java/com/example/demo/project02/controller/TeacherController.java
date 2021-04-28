package com.example.demo.project02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TeacherController
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/6 14:48
 * @Version 1.0
 **/



@Controller

public class TeacherController {

    @RequestMapping("/t1")
    @ResponseBody
    public String t1(){
        System.out.println("进入了t1方法11");
        return "进入了t1方法";
    }
}
