package com.eun.firebaseapp;

public class ChatVO {
    private int img;
    private String name;
    private String msg;
    private String time;

    public ChatVO() {
    }

    public ChatVO(int img, String name, String msg, String time) {
        this.img = img;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
