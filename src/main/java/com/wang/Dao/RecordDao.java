package com.wang.Dao;

import com.wang.pojo.Record;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface RecordDao {
    public List<Record> getRecord(Connection connection) throws SQLException, ParseException;
    public boolean modifyRecord(Connection cn, Record record, String oldTime, int id) throws SQLException;
    /*
     * cn 不能为空 Record不能为空
     * id = 0 无意义
     * id = 1 表示删除
     * id = 2 表示插入
     * id = 3 表修改
     * */
}
