package com.MTH;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Hassan_45!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Tables");
            //executeQuery method is used for executing SELECT queries(READ)
            //executeUpdate method is used for executing INSERT, DELETE, UPDATE queries

            while(resultSet.next()){
                int CityId = resultSet.getInt("CityId");

                String CountryCode = resultSet.getString("CountryCode");

                System.out.println(CityId + ","+ CountryCode);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }

    }
}