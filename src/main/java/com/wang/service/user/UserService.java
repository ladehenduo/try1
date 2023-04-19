package com.wang.service.user;

import com.wang.pojo.Profile;
import com.wang.pojo.Record;
import com.wang.pojo.User;

import java.util.List;

public interface UserService {
    // 用户登录
    public User getUser(String username, String password);    //获取一个User
    public boolean register(User user, Profile profile);    // 注册一个User 传入 用户 和 个人信息，必须有username和身份证号
    public Profile getProfile(String username); // 获取一个人的信息 传入用户名
    public boolean updateProfile(Profile profile);  // 更新一个人的信息 传入新的信息
    public boolean updatePassword(String oldpassword, User user);   // 修改密码 传入老密码和新 User
    public boolean updatePermission(User user); // 更新权限 传入新的 User
}
