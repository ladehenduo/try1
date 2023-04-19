package com.wang.service.quarantineService;

import com.wang.Dao.*;
import com.wang.pojo.QuarantinePeople;
import com.wang.utils.Date2Date;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class QuarantineServiceImpl implements QuarantineService{
    private QuarantinePeopleDao peopleDao;
    private UserDao userDao;

    public QuarantineServiceImpl() {
        peopleDao = new QuarantinePeopleDaoImpl();
        userDao = new UserDaoImpl();
    }

    public List<QuarantinePeople> getAllQuarantine() {
        Connection connection = null;
        List<QuarantinePeople> list = null;

        connection = BaseDao.getConnection();
        try {
            list = peopleDao.getQuarantinePeople(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return list;
    }

    public boolean addQuarantinePeople(String username, String date, int day, String room) {
        QuarantinePeople people = new QuarantinePeople("default", "default","default","default","default","default","default",0,new Date());
        people.setUsername(username);
        people.setDay(day);
        people.setRoom(room);
        try {
            people.setDate(Date2Date.StringToJava(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        boolean flag = false;

        connection = BaseDao.getConnection();
        try {
            flag = peopleDao.modifyQuarantinePeople(connection, people, 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean deleteQuarantinePeople(String username) {
        QuarantinePeople people = new QuarantinePeople("default", "default","default","default","default","default","default",0,new Date());
        people.setUsername(username);
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = peopleDao.modifyQuarantinePeople(connection, people, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean updateQurantinePeople(String username, String type, String date, int day, String room) {
        QuarantinePeople people = new QuarantinePeople("default", "default","default","default","default","default","default",0,new Date());
        people.setUsername(username);
        people.setType(type);
        people.setDay(day);
        people.setRoom(room);
        try {
            people.setDate(Date2Date.StringToJava(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();
        try {
            flag = peopleDao.modifyQuarantinePeople(connection, people, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
