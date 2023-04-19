package com.wang.Dao;

import com.wang.pojo.Profile;

import java.sql.Connection;
import java.sql.SQLException;

public interface ProfileDao {
    public Profile getProfileByUser(Connection connection, String username) throws SQLException;
    public Profile getProfileByID(Connection connection, String IDcard) throws SQLException;
    public boolean modifyProfile(Connection connection, Profile profile, int id) throws SQLException;
    /*
     * cn 不能为空 people不能为空
     * id = 0 无意义
     * id = 1 表示删除
     * id = 2 表示插入
     * id = 3 表修改
     * */
}
