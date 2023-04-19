package com.wang.service.user;

import com.wang.Dao.BaseDao;
import com.wang.Dao.RecordDao;
import com.wang.Dao.RecordDaoImpl;
import com.wang.Dao.UserDao;
import com.wang.Dao.UserDaoImpl;
import com.wang.pojo.Profile;
import com.wang.pojo.Record;
import com.wang.pojo.User;
import com.wang.service.ProfileService.ProfileService;
import com.wang.service.ProfileService.ProfileServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    // 业务层要调用Dao层，引入Dao层
    private UserDao userDao; // 用户数据库交互对象

    // 初始化
    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    public User getUser(String username, String password) {
        Connection connection = null;
        User user = null;

        try{
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, username);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    public Profile getProfile(String username) {
        Connection connection = null;
        Profile profile = null;

        connection = BaseDao.getConnection();
        try {
            profile = userDao.getProfile(connection, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }

        return profile;
    }

    public boolean register(User user, Profile profile) {
        ProfileService profileService = new ProfileServiceImpl();
        User user1 = getUser(user.getUsrename(), " ");
        Profile profile1 = profileService.getProfileByID(profile.getIDcard());
        if(user1 != null || profile1.getIDcard().equals(profile.getIDcard())) {
            System.out.println("用户已存在，注册失败");
            return false;
        }

        Connection connection = null;
        boolean flag = false;   // true 表示注册成功
        try {
            connection = BaseDao.getConnection();
            flag = userDao.registerUser(connection, user, profile);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean updateProfile(Profile profile) {
        Connection connection = null;
        boolean flag = false;

        connection = BaseDao.getConnection();
        try {
            flag = userDao.updateProfile(connection, profile);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    public boolean updatePassword(String odlpassword, User user) {
        User user1 = getUser(user.getUsrename(), " ");
        if(!user1.getPassword().equals(odlpassword)) return false; // 老密码输错了，不能修改
        Connection connection = null;
        boolean flag = false;

        connection = BaseDao.getConnection();
        try {
            flag = userDao.updatePassword(connection, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean updatePermission(User user) {
        Connection connection = null;
        boolean flag = false;

        connection = BaseDao.getConnection();
        try {
            flag = userDao.updatePermission(connection, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

}
