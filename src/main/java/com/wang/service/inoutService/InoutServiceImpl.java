package com.wang.service.inoutService;

import com.wang.Dao.BaseDao;
import com.wang.Dao.RecordDao;
import com.wang.Dao.RecordDaoImpl;
import com.wang.pojo.Record;
import com.wang.utils.Date2Date;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class InoutServiceImpl implements InoutService {
    private RecordDao recordDao;

    public InoutServiceImpl() {
        recordDao = new RecordDaoImpl();
    }

    public List<Record> getAllRecord() throws ParseException {
        Connection connection = null;
        List<Record> list = null;
        try{
            connection = BaseDao.getConnection();
            list = recordDao.getRecord(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return list;
    }

    public boolean addRecord(String username, String inout_type, String time) {
        Record record = new Record();
        record.setUsername(username);
        record.setinout_type(inout_type);
        try {
            record.setTime(Date2Date.StringToJava(time));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = recordDao.modifyRecord(connection, record, null,2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    public boolean updateRecord(String username, String inout_type, String time, String oldTime) {
        Record record = new Record();
        record.setinout_type(inout_type);
        record.setUsername(username);
        try {
            record.setTime(Date2Date.StringToJava(time));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = recordDao.modifyRecord(connection, record, oldTime, 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean deleteRecord(String username, String time) {
        Record record = new Record();
        record.setUsername(username);
        try {
            record.setTime(Date2Date.StringToJava(time));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = recordDao.modifyRecord(connection, record,null, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

}
