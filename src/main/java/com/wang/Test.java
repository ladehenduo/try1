package com.wang;

import com.wang.Dao.*;
import com.wang.pojo.Profile;
import com.wang.pojo.QuarantinePeople;
import com.wang.pojo.Record;
import com.wang.pojo.User;
import com.wang.service.ProfileService.ProfileService;
import com.wang.service.ProfileService.ProfileServiceImpl;
import com.wang.service.inoutService.InoutService;
import com.wang.service.inoutService.InoutServiceImpl;
import com.wang.service.quarantineService.QuarantineService;
import com.wang.service.quarantineService.QuarantineServiceImpl;
import com.wang.service.user.UserService;
import com.wang.service.user.UserServiceImpl;
import com.wang.utils.Date2Date;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        // 实体类对象
        Profile profile = new Profile("9625331621", "wwt", "男", 18, "123465798", "健康", "176343", "20#606");
        Record record = new Record("962533162","wwt", "546123", "进入", new Date(), "1231654");
        User user = new User("9625331621", "123456", "管理员");
        QuarantinePeople people = new QuarantinePeople("962533162", "cnm", "46513216", "1764546", "20#608","健康", "隔离中", 7,new Date());
        String username = "123";
        String time = "2000-01-10 20:08:35";

        // Dao 对象
        UserDao userDao = new UserDaoImpl();
        RecordDao recordDao = new RecordDaoImpl();
        QuarantinePeopleDao quarantine = new QuarantinePeopleDaoImpl();
        Connection cn = BaseDao.getConnection();
        ProfileDao profileDao = new ProfileDaoImpl();

        // Service 对象
        UserService userService = new UserServiceImpl();
        InoutService inoutService = new InoutServiceImpl();
        QuarantineService qService = new QuarantineServiceImpl();
        ProfileService pService = new ProfileServiceImpl();

        // ProfileService 测试--通过
//        pService.addProfile(profile);
//        System.out.println(pService.getProfileByID("1234657981").getUsername());
//        pService.deleteProfile(null, "1234657981");
//        Profile profile1 = pService.getProfileByID("1234657987");
//        profile1.setHealth("良");
//        profile1.setSex("女");
//        pService.updateProfile(profile1);
        // ProfileDao测试--通过
//        Profile profile1 = profileDao.getProfileByUser(cn, "123");
//        System.out.println(profile1.getIDcard());
//        profileDao.modifyProfile(cn, profile, 1);
//        Profile profile1 = profileDao.getProfileByUser(cn, "962533162");
//        System.out.println(profile1.getIDcard());
//        profile1.setTel("19121");
//        profileDao.modifyProfile(cn, profile1, 3);


        // QuarantineService 测试--通过
//        List<QuarantinePeople> list = qService.getAllQuarantine();
//        qService.addQuarantinePeople("962533162", time, 7, "20#608");
//        qService.deleteQuarantinePeople("962533162");


        // userService 测试--通过
//        userService.register(user, profile);
//        userService.getProfile(username);
//        userService.updatePassword("1234", user);

        // inoutService测试--通过
//        inoutService.addRecord(username, "进入", time);
//        inoutService.updateRecord("123", "进入", "2022-12-07 13:57:00", time);
//        inoutService.deleteRecord(username, time);
        // Quarantine测试--通过
//        quarantine.modifyQuarantinePeople(cn, people, 2);
//        quarantine.modifyQuarantinePeople(cn, people, 2);
//        quarantine.modifyQuarantinePeople(cn, people, 2);
//        List<QuarantinePeople> list = quarantine.getQuarantinePeople(cn);
//
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getUsername());
//        }
    }
}
