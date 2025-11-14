package edu.univ.erp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // TODO: change these according to your MySQL setup
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Mayank123@";

    private static final String AUTH_URL = "jdbc:mysql://localhost:3306/auth_db";
    private static final String ERP_URL  = "jdbc:mysql://localhost:3306/erp_db";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded");
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load MySQL driver");
            e.printStackTrace();
        }
    }

    public static Connection getAuthConnection() throws SQLException {
        return DriverManager.getConnection(AUTH_URL, DB_USER, DB_PASSWORD);
    }

    public static Connection getErpConnection() throws SQLException {
        return DriverManager.getConnection(ERP_URL, DB_USER, DB_PASSWORD);
    }
}
