package com.wang.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块，类加载的时候执行
    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    // 数据库连接
    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 编写查询公共方法
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] params) throws SQLException {
        // 预编译的 sql在后面直接执行
        preparedStatement = connection.prepareStatement(sql);
        if(params != null) {
            for(int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
        resultSet=preparedStatement.executeQuery();
        return resultSet;
    }
    // 增删改公共方法
    public static int execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        int updateRows = 0;
        System.out.println("预编译完成！");
        if(params != null) {
            for(int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            System.out.println("params装载完成！");
            updateRows=preparedStatement.executeUpdate();
            System.out.println("更新了" + updateRows + "行");
        }
        return updateRows;
    }
    // 释放资源
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if(resultSet != null) {
            try {
                resultSet.close();
                resultSet=null;
            }catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null) {
            try {
                connection.close();
                connection=null;
            }catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if(preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement=null;
            }catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
