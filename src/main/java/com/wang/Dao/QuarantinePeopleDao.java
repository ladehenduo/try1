package com.wang.Dao;

import com.wang.pojo.QuarantinePeople;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface QuarantinePeopleDao {
    public List<QuarantinePeople> getQuarantinePeople(Connection cn) throws SQLException;   // 传入数据库连接，获取所有隔离信息
    public boolean modifyQuarantinePeople(Connection cn, QuarantinePeople people, int id) throws SQLException; // 数据库连接，姓名， 身份证号
    /*
    * cn 不能为空 people不能为空
    * id = 0 无意义
    * id = 1 表示删除
    * id = 2 表示插入
    * id = 3 表修改
    * */
}
