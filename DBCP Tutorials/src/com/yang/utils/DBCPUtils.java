package com.yang.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPUtils {

    public static String driverClassName = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/course?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static String username = "root";
    public static String password = "123456";// 若没有密码, 这里写不写无所谓
    public static BasicDataSource ds = null;

    /*
     * 赋值 static { BasicDataSource ds = new BasicDataSource();
     * ds.setDriverClassName(driverClassName); ds.setUrl(url);
     * ds.setUsername(username); ds.setPassword(password); }
     */

    /**
     * 获取connection数据库连接 之前代码的对象创建完后，直接getConnection()
     *
     * @return return Connection or null
     */
    public static Connection getConnection() {

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     *
     * @param st  Statement
     * @param con Connection
     * @param rs  ResultSet
     */
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
