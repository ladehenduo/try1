package com.wang.Dao;

import com.wang.pojo.Record;
import com.wang.utils.Date2Date;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDaoImpl implements RecordDao{
    List<Record> list = new ArrayList<Record>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Object[] params = null;
    Date date = null;
    // 实现查找所有进出数据查询
    public List<Record> getRecord(Connection connection) throws SQLException, ParseException {
        if(connection != null) {
            params = null;
            String sql = "select * from inout_record a left join profile b on a.username = b.username";
            resultSet= BaseDao.execute(connection, statement, resultSet, sql, params);
            while(resultSet.next()) {
                date = Date2Date.sqlToJava(resultSet.getDate("time"), resultSet.getTime("time"));

                list.add(new Record(resultSet.getString("username"),
                        resultSet.getString("name"),
                        resultSet.getString("IDcard"),
                        resultSet.getString("inout_type"),
                        date,
                        resultSet.getString("contact")));
            }
            BaseDao.closeResource(connection, statement, resultSet);
        }
        return list;
    }

    public boolean modifyRecord(Connection cn, Record record, String oldTime, int id) throws SQLException {
        boolean flag=false;
        int updateRow = 0;
        String time = Date2Date.javaToString(record.getTime());
        String username = record.getUsername();

        if(id == 0 || cn == null) { // 无意义 或 连接建立失败 返回失败
            return false;
        }
        else if(id == 1) {
            String sql = "delete from inout_record where username=? and time=?";
            params = new Object[]{username, time};
            updateRow = BaseDao.execute(cn, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else if(id == 2) { // 执行插入语句
            params= new Object[]{record.getUsername(), record.getinout_type(), Date2Date.javaToString(record.getTime())};
            String sql = "insert into inout_record values(?, ?, ?)";
            updateRow = BaseDao.execute(cn, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        else {
            // 执行更新语句
            System.out.println(oldTime);
            System.out.println(username);
            params = new Object[]{record.getinout_type(), time, username, oldTime};
            String sql = "update inout_record set inout_type=?, time=? where username=? and time=?";
            updateRow = BaseDao.execute(cn, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }
        if(updateRow > 0) flag = true;
        return flag;
    }
}
