package com.wang.pojo;

import java.util.Date;

public class Record {
    String username;
    String name;
    String IDcard;
    String inout_type;
    Date time;
    String contact;

    public Record() {
        this.username="default";
        this.name="default";
        this.IDcard="default";
        this.inout_type="进入";
        this.time=new Date();
        this.contact="default";
    }

    public Record(String username, String name, String IDcard, String inout_type, Date time, String contact) {
        this.username = username;
        this.name = name;
        this.IDcard = IDcard;
        this.inout_type = inout_type;
        this.time = time;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public Record(String username, String type, Date time) {
        this.username = username;
        this.inout_type = type;
        this.time = time;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getinout_type() {
        return inout_type;
    }

    public void setinout_type(String inout_type) {
        this.inout_type = inout_type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
