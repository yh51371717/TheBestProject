package com.example.demo.project01.Util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * @ClassName test1
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/14 14:43
 * @Version 1.0
 **/
public class test1 {
    public static void main(String[] args) throws Exception {
        InetAddress ia = InetAddress.getLocalHost();

        String ip = InetAddress.getLocalHost().getHostAddress(); //获取本地IP
        System.out.println(ia.getHostAddress());
        System.out.println("MAC ......... "+GetMacAddress.getMACAddress(ia));

    }



}
