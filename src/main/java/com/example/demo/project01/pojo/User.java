package com.example.demo.project01.pojo;

import java.io.Serializable;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/6 14:57
 * @Version 1.0
 **/
public class User implements Serializable {

    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
