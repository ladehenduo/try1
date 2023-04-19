package com.wang.Dao;

import com.wang.pojo.Profile;
import com.wang.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Object[] params=null;
    Profile profile = null;
    User user = null;
    // 查询并返回当前登陆的用户，如果未找到返回 null
    public User getLoginUser(Connection connection, String username) throws SQLException {
        if(connection != null) {
            String sql = "select * from account where username = ?";
            params= new Object[]{username};
            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            if(resultSet.next()) {
                user = new User();
                user.setUsrename(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setPermission(resultSet.getString("permission"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return user;
    }

    // 查询个人信息
    public Profile getProfile(Connection cn, String username) throws SQLException {
        profile = new Profile();
        if (cn != null) {
            String sql = "select * from profile where username=?";
            params = new Object[]{username};
            resultSet = BaseDao.execute(cn, statement, resultSet, sql, params);
            if(resultSet.next()) {
                profile = new Profile(username, resultSet.getString("name"),
                        resultSet.getString("sex"), resultSet.getInt("age"),
                        resultSet.getString("IDcard"), resultSet.getString("health"),
                        resultSet.getString("contact"), resultSet.getString("address"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return profile;
    }

    // 注册用户，向数据库插入用户数据
    public boolean registerUser(Connection connection, User user, Profile profile) throws SQLException {
        boolean flag = false;
        if(connection != null) {
            String sql1 = "insert into account values(?, ?, ?)";
            params=new Object[]{user.getUsrename(), user.getPassword(), user.getPermission()};
            System.out.println("即将执行BaseDao调用");
            int updateRow = BaseDao.execute(connection, statement, sql1, params);

            if(profile != null) {   // 如果没有传递个人信息，不进行插入
                String sql2 = "insert into profile values(?,?,?,?,?,?,?,?)";
                params = new Object[]{profile.getUsername(), profile.getSex(), profile.getAge(), profile.getIDcard(),
                        profile.getHealth(), profile.getTel(), profile.getaddress(), profile.getName()};
                updateRow += BaseDao.execute(connection, statement, sql2, params);
            }
            if(updateRow > 0){
                flag = true;
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return flag;
    }

    // 更新个人信息
    public boolean updateProfile(Connection cn, Profile profile) throws SQLException {
        boolean flag = false;
        if(cn != null) {
            String sql = "update profile set sex=?, age=?,set IDcard=?, set contact=?, set address=?, set name=? where username=?";
            params = new Object[]{profile.getSex(), profile.getAge(), profile.getIDcard(), profile.getTel(),
            profile.getaddress(), profile.getName(), profile.getUsername()};
            int updateRow = BaseDao.execute(cn, statement, sql, params);
            if(updateRow > 0) flag = true;
            BaseDao.closeResource(null, statement, resultSet);
        }
        return flag;
    }

    // 更新密码
    public boolean updatePassword(Connection cn, User user) throws SQLException {
        boolean flag = false;
        if(cn != null) {
            String sql = "update account set password=? where username=?";
            params = new Object[]{user.getPassword(), user.getUsrename()};
            int updateRow = BaseDao.execute(cn, statement, sql, params);
            if(updateRow > 0) flag = true;
            BaseDao.closeResource(null, statement, resultSet);
        }
        return flag;
    }
    // 跟新权限
    public boolean updatePermission(Connection cn, User user) throws SQLException {
        boolean flag = false;
        if(cn != null) {
            String sql = "update account set permission=? where username=?";
            params = new Object[]{user.getPermission(), user.getUsrename()};
            int updateRow = BaseDao.execute(cn, statement, sql, params);
            if(updateRow > 0) flag = true;
            BaseDao.closeResource(null, statement, resultSet);
        }
        return flag;
    }
}
