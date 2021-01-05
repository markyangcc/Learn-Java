package com.yang.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        // 读取dbcp.properties文件内容
        Properties ps = new Properties();
        // 创建文件流
        InputStream is;

        try {
            is = new FileInputStream("resources/dbcp.properties");
            // PropertiesDemo 是类名，类叫什么名，它就什么名
            // is =
            // PropertiesDemo.class.getClassLoader().getResourceAsStream("dbcp.properties");

            // Maybe: IDEA 中 Src 和 sourcefolder里面存放的东西最终才会被编译到classes文件中，
            // 如果系统找不到文件使用替换为这行代码，利用反射得到类加载器再得到Resources流
            // 实测IDEA 这样可是可以的，两种都要把存放配置文件的文件夹mark为 Resource Root

            // 这样将配置文件放在外面src文件夹外面的resources文件夹单独管理会好管理点，以后项目的所有配置文件可以采取这种方式

            try {
                ps.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String driverClassName = ps.getProperty("driverClassName");
            String url = ps.getProperty("url");
            String username = ps.getProperty("username");
            String password = ps.getProperty("password");

            System.out.println("PropertiesDemo");
            System.out.println("driverClassName: " + driverClassName);
            System.out.println("url: " + url);
            System.out.println("username: " + username);
            System.out.println("password: " + password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
