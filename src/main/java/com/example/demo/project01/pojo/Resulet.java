package com.example.demo.project01.pojo;

/**
 * @ClassName Resulet
 * @Deacription TODO
 * @Author user
 * @Date 2021/1/7 9:09
 * @Version 1.0
 **/
public class Resulet {
    private int status;
    private String msg;

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
