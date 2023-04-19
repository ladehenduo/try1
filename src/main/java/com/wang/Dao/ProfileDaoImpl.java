package com.wang.Dao;

import com.wang.pojo.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDaoImpl implements ProfileDao{
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Object[] params;

    public Profile getProfileByUser(Connection connection, String username) throws SQLException {
        Profile profile = new Profile();
        if(connection != null) {
            params = new Object[]{username};
            String sql = "select * from profile where username=?";
            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            if(resultSet.next()) {
                profile.setUsername(resultSet.getString("username"));
                profile.setSex(resultSet.getString("sex"));
                profile.setAge(resultSet.getInt("age"));
                profile.setIDcard(resultSet.getString("IDcard"));
                profile.setHealth(resultSet.getString("health"));
                profile.setTel(resultSet.getString("contact"));
                profile.setaddress(resultSet.getString("address"));
                profile.setName(resultSet.getString("name"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return profile;
    }

    public Profile getProfileByID(Connection connection, String IDcard) throws SQLException {
        Profile profile = new Profile();
        if(connection != null) {
            params = new Object[]{IDcard};
            String sql = "select * from profile where IDcard=?";
            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            if(resultSet.next()) {
                profile.setUsername(resultSet.getString("username"));
                profile.setSex(resultSet.getString("sex"));
                profile.setAge(resultSet.getInt("age"));
                profile.setIDcard(resultSet.getString("IDcard"));
                profile.setHealth(resultSet.getString("health"));
                profile.setTel(resultSet.getString("contact"));
                profile.setaddress(resultSet.getString("address"));
                profile.setName(resultSet.getString("name"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return profile;
    }

    public boolean modifyProfile(Connection connection, Profile profile, int id) throws SQLException {
        boolean flag = false;
        int updateRow = 0;
        String username = profile.getUsername();
        String name = profile.getName();
        String sex = profile.getSex();
        int age = profile.getAge();
        String IDcard = profile.getIDcard();
        String health = profile.getHealth();
        String tel = profile.getTel();
        String address = profile.getaddress();

        if(connection == null || id == 0) {
            return false;
        }
        else if(id == 1) { // 删除
            updateRow = 0;
            params = new Object[]{IDcard};
            String sql = "delete from profile where IDcard=?";
            updateRow = BaseDao.execute(connection, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else if(id == 2) { // 添加
            updateRow = 0;
            params = new Object[]{username, sex, age, IDcard, health, tel, address, name};
            String sql = "insert into profile values(?,?,?,?,?,?,?,?)";
            updateRow = BaseDao.execute(connection, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else {  // 修改
            updateRow = 0;
            params = new Object[]{username, sex, age, IDcard, health, tel, address, name, username};
            String sql = "update profile set username=?,sex=?,age=?,IDcard=?,health=?,contact=?,address=?,name=? where username=?";
            updateRow = BaseDao.execute(connection, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        if(updateRow > 0) flag = true;

        return flag;
    }
}
