package com.yang.test;

//存在问题：每次都要把配置信息写到每一个文件中，冗余

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPDemo {

    public static void main(String[] args) {

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/course?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";// 若没有密码, 这里写不写无所谓

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        // 创建连接对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // 打印ResultSet 里面的内容
                System.out.println("DBCPDemo");
                System.out.print(resultSet.getString("StuNo") + "\t");
                System.out.print(resultSet.getString("StuName") + "\t");
                System.out.print(resultSet.getString("StuPwd") + "\t");
                System.out.println();

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                // connection may be null, so assert it first
                assert connection != null;
                connection.close();
                assert statement != null;
                statement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
