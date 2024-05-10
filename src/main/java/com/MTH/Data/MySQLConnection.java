package com.MTH.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String USER = "root";
    private static final String password = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/world";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, password);
        } catch (SQLException e) {
            e.printStackTrace();
            //todo throw a custom exception
        }
        return connection;
    }
}
