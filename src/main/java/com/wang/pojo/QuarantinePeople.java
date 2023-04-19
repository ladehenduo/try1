package com.wang.pojo;

import java.util.Date;

public class QuarantinePeople { // 隔离人员 实体类
    String username;    //用户名
    String name; // 姓名
    String IDcard; // 身份证号
    String tel; //电话
    String room; //在哪个房间隔离
    String type; //现在的隔离状态
    String health; //健康状态
    int day; //需要隔离多久
    Date date; //开始隔离的时间

    public QuarantinePeople() {
        this.username="default";
        this.name="default";
        this.IDcard="default";
        this.type="default";
        this.health="default";
        this.day=7;
        this.tel="default";
        this.date = new Date();
    }

    public QuarantinePeople(String username, String name, String IDcard, String tel, String room, String health, String type, int day, Date date) {
        this.username = username;
        this.name = name;
        this.IDcard = IDcard;
        this.tel = tel;
        this.room = room;
        this.type = type;
        this.day = day;
        this.date = date;
        this.health = health;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
