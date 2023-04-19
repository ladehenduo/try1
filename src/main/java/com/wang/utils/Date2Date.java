package com.wang.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2Date {
    private static SimpleDateFormat sdf;
    private final static String dateFormat= "yyyy-MM-dd HH:mm:ss";

    static {
        sdf = new SimpleDateFormat(dateFormat);
    }

    // 传入sql的Date 和 Time 返回 java的Date
    public static Date sqlToJava(java.sql.Date date, Time time) throws ParseException {
        return sdf.parse(date.toString() + ' ' + time.toString());
    }
    public static Date StringToJava(String date) throws ParseException {
        return sdf.parse(date);
    }
    // 传入 java 的 Date 返回SQL的 Date
    public static java.sql.Date javaToSQLDate(Date date) {
        String s = sdf.format(date);
        java.sql.Date d = java.sql.Date.valueOf(s.substring(0,10));
        return d;
    }
    // 传入 java 的 Date 返回SQL的 Time
    public static Time javaToSQLTime(Date date) {
        String s = sdf.format(date);
        Time time = Time.valueOf(s.substring(11, 18));
        return time;
    }
    // 传入sql Date Time 返回 String
    public static String sqlToString(java.sql.Date date, Time time) {
        return date.toString() + ' ' + time.toString();
    }
    // 传入 Java Date 返回 "yyyy-MM-dd HH:mm:ss" 格式String
    public static String javaToString(Date date) {
        java.sql.Date d = javaToSQLDate(date);
        Time t = javaToSQLTime(date);
        return sqlToString(d,t);
    }

}
