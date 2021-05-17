package com.example.demo.project02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/6 14:48
 * @Version 1.0
 **/



@Controller

public class TeacherController {

    @Value("${5gGlodenLottoryControl}")
    private boolean fiveG_GlodenLottoryControl;

    @RequestMapping("/t1")
    @ResponseBody
    public Map<String, String> t1(){
        List<Map<String, String>> roleName = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        Map<String, String> map4 = new HashMap<>();
        map1.put("id","D3A6EB08288C4359A11D4A51DC85F382");
        map1.put("name","王思邈");
        map2.put("id","3A3F995319404C7CBA4257300ACBBDBB");
        map2.put("name","丹宇洋");
        map3.put("id","CE6DD0B35E23492AB71D48EBADB3FE3D");
        map3.put("name","汪荣");
        map4.put("id","CE6DD0B35E23492AB71D48EBADB3FE3D");
        map4.put("name","张晓妍");

        roleName.add(map1);roleName.add(map2);roleName.add(map3);roleName.add(map4);

        System.out.println(roleName);
        System.out.println("-----------------------------------------------------------------------------------------");


        Map<String,String> result = new HashMap<>();
        for (Map<String, String> map : roleName){
            String id = map.get("id");
            String name = map.get("name");
            if (result.containsKey(id)){
                String tempName = result.get(id);
                name += ","+tempName;
            }
            result.put(id,name);
        }

        return result;
    }

    @RequestMapping("/t2")
    @ResponseBody
    public boolean t2(){
        if (fiveG_GlodenLottoryControl){
            System.out.println("我是true，开启本逻辑");
        }else {
            System.out.println("我是false，关闭本逻辑");
        }
        return fiveG_GlodenLottoryControl;
    }
}
