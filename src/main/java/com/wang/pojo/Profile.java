package com.wang.pojo;

public class Profile {
    String username;
    String name;
    String sex;
    int age;
    String IDcard;
    String health;
    String tel;
    String address;

    public Profile() {
        this.username="default";
        this.name="default";
        this.sex="default";
        this.age=0;
        this.IDcard="default";
        this.health="default";
        this.tel="default";
        this.address="default";
    }

    public Profile(String username, String name, String sex, int age, String IDcard, String health, String tel, String address) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.IDcard = IDcard;
        this.health = health;
        this.tel = tel;
        this.address = address;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}
