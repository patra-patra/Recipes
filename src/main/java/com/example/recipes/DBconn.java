package com.example.recipes;
import java.sql.*;
public class DBconn {

    private static String url = "jdbc:mysql://localhost:3306/recipes";
    private static String user = "root";
    private static String password = "root";

    public static Connection GetConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }
}
