package com.wang.service.ProfileService;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.wang.Dao.BaseDao;
import com.wang.Dao.ProfileDao;
import com.wang.Dao.ProfileDaoImpl;
import com.wang.pojo.Profile;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfileServiceImpl implements ProfileService{
    ProfileDao profileDao;

    public ProfileServiceImpl() {
        profileDao = new ProfileDaoImpl();
    }

    public Profile getProfileByUser(String username) {
        Connection connection = null;
        Profile profile = null;
        connection = BaseDao.getConnection();
        try {
            profile = profileDao.getProfileByUser(connection, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return profile;
    }

    public Profile getProfileByID(String IDcard) {
        Connection connection = null;
        Profile profile = null;
        connection = BaseDao.getConnection();
        try {
            profile = profileDao.getProfileByID(connection, IDcard);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return profile;
    }

    public boolean addProfile(Profile profile) {
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = profileDao.modifyProfile(connection, profile, 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean deleteProfile(String username, String IDcard) {
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setIDcard(IDcard);
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = profileDao.modifyProfile(connection, profile, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            flag = profileDao.modifyProfile(connection, profile, 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
