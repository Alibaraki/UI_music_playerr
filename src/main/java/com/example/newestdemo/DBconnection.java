package com.example.newestdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public Connection DBlink;

    public Connection getConnection() {
        String DBname = "new_schema";
        String DBuser = "root";
        String DBpassword = "123321Jebaa";
        String url = "jdbc:mysql://localhost/" + DBname;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DBlink = DriverManager.getConnection(url, DBuser, DBpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DBlink;
    }
}