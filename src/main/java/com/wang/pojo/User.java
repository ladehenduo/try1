package com.wang.pojo;

public class User {
    private String usrename;
    private String password;
    private  String permission;

    public User() {
        this.usrename="default";
        this.password="default";
        this.permission="default";
    }

    public User(String usrename, String password, String permission) {
        this.usrename = usrename;
        this.password = password;
        this.permission = permission;
    }

    public String getUsrename() {
        return usrename;
    }

    public String getPassword() {
        return password;
    }

    public String getPermission() {
        return permission;
    }

    public void setUsrename(String usrename) {
        this.usrename = usrename;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
