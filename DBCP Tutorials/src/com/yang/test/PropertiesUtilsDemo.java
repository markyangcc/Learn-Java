package com.yang.test;

//使用BasicDataSourceFactory 可以不用自己定义driverClassName,url,username,password
// 结合 .properties 配置文件更加简洁

import com.yang.utils.DBCPUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class PropertiesUtilsDemo {
    public static void main(String[] args) throws SQLException {
        Connection conn;
        Statement st;
        ResultSet rs;

        // 将公共的部分抽取出来写到一个Utils工具包里面，写个同名函数 getConnection();进行调用即
        conn = DBCPUtils2.getConnection();

        if (conn == null) {
            System.out.println("Connection is null");
        }

        st = conn.createStatement();

        String sql = "select * from student";

        rs = st.executeQuery(sql);

        while (Objects.requireNonNull(rs).next()) {
            // 打印ResultSet 里面的内容
            System.out.println("PropertiesUtilsDemo");
            System.out.print(rs.getString("StuNo") + "\t");
            System.out.print(rs.getString("StuName") + "\t");
            System.out.print(rs.getString("StuPwd") + "\t");
            System.out.println();
        }
    }
}
