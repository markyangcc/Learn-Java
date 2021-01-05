package com.yang.test;

//仍然存在的问题：存在url，username 硬编码
//解决方法，使用配置文件，.properties配置文件

import com.yang.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DBCPUtilsDemo {

    public static void main(String[] args) throws SQLException {
        Connection conn;
        Statement st;
        ResultSet rs;

        //将公共的部分抽取出来写到一个Utils工具包里面，写个同名函数 getConnection();进行调用即
        conn = DBCPUtils.getConnection();


        st = conn.createStatement();

        String sql = "select * from student";

        rs = st.executeQuery(sql);

        while (Objects.requireNonNull(rs).next()) {
            // 打印ResultSet 里面的内容
            System.out.println("DBCPUtilsDemo");
            System.out.print(rs.getString("StuNo") + "\t");
            System.out.print(rs.getString("StuName") + "\t");
            System.out.print(rs.getString("StuPwd") + "\t");
            System.out.println();
        }
    }

}