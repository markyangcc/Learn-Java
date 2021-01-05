package com.yang.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtils2 {

    public static BasicDataSource ds = null;

    static {
        Properties ps = new Properties();

        InputStream is = null;
        try {
            is = new FileInputStream("resources/dbcp.properties");
            //is = DBCPUtils2.class.getClassLoader().getResourceAsStream("dbcp.properties");

            try {
                ps.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // BasicDataSourceFactory 源码里面已经为 driverClassName, url, username, password 赋值了
            // 不信可以看源码，IDEA鼠标悬浮后右键-> goto Implementation
            // 所以 dbcp.properties 文件里面的名字不能乱取
            ds = BasicDataSourceFactory.createDataSource(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Statement st, Connection con, ResultSet rs) {

        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }

}
