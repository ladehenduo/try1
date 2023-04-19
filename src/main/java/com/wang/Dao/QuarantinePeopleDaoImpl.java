package com.wang.Dao;

import com.wang.pojo.QuarantinePeople;
import com.wang.utils.Date2Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuarantinePeopleDaoImpl implements QuarantinePeopleDao{
    List<QuarantinePeople> list = new ArrayList<QuarantinePeople>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Object[] params = null;
    Date date = null;

    public List<QuarantinePeople> getQuarantinePeople(Connection cn) throws SQLException {
        if(cn != null) {
            params = null;
            String sql = "select * from isolation_record i, profile p where i.username=p.username";
            resultSet = BaseDao.execute(cn, statement, resultSet, sql, params);
            while (resultSet.next()) {
                try {
                    date = Date2Date.sqlToJava(resultSet.getDate("time"), resultSet.getTime("time"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(date);
                list.add(new QuarantinePeople(resultSet.getString("username"),
                        resultSet.getString("name"), resultSet.getString("IDcard"),
                        resultSet.getString("contact"), resultSet.getString("room"),
                        resultSet.getString("health"), resultSet.getString("type"),
                        resultSet.getInt("day"), date));
                System.out.println(resultSet.getString("type"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return list;
    }

    public boolean modifyQuarantinePeople(Connection cn, QuarantinePeople people, int id) throws SQLException {
        boolean flag = false;
        int updateRow = 0;
        String username = people.getUsername();
        String type = people.getType();
        String time = Date2Date.javaToString(people.getDate());
        int day = people.getDay();
        String room = people.getRoom();
        String isused = type.equals("隔离中") ? "使用中" : "闲置";
        if(id == 0 || cn == null) {
            return false;
        }
        else if(id == 1){ // 删除
            // 在isolation表中删除记录
            params = new Object[]{username};
            String sql = "delete from isolation_record where username=?";
            updateRow = BaseDao.execute(cn, statement, sql, params);
            // 在Room表中更新房间占用情况
            String sql2 = "update Room set isused='闲置' where roomId=?";
            params = new Object[]{room};
            BaseDao.execute(cn, statement, sql2, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else if(id == 2) { // 插入
            params = new Object[]{username, "隔离中", time, day, room};
            String sql = "insert into isolation_record values(?,?,?,?,?)";
            updateRow = BaseDao.execute(cn, statement, sql, params);
            // 同时更新房间信息
            String sql2 = "update Room set isused=? where roomId=?";
            params = new Object[]{isused, room};
            BaseDao.execute(cn, statement, sql2, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else { // 更新隔离状态
            params = new Object[]{type, username};
            String sql = "update isolation_record set type=? where username=?";
            updateRow = BaseDao.execute(cn, statement, sql, params);
            // 同时更新房间使用信息
            String sql2 = "update Room set isused=? where roomId=?";
            params = new Object[]{isused, room};
            BaseDao.execute(cn, statement, sql2, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        if(updateRow > 0) flag = true;
        return flag;
    }
}
