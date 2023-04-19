package com.wang.Dao;

import com.wang.pojo.Profile;
import com.wang.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    // 获取登陆对象
    public User getLoginUser(Connection connection, String username) throws SQLException;
    public Profile getProfile(Connection cn, String username) throws SQLException;
    // 注册账号
    public boolean registerUser(Connection connection, User user, Profile profile) throws SQLException;
    // 更新个人信息
    public boolean updateProfile(Connection cn, Profile profile) throws SQLException;
    // 更新用户密码
    public boolean updatePassword(Connection cn, User user) throws SQLException;
    // 更新权限
    public boolean updatePermission(Connection cn, User user) throws SQLException;
}
