package com.rentalproperty.util;
import java.sql.*;
public class DBConnection {
    private static final String URL="jdbc:mysql://localhost:3306/rental_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Kolkata";
    private static final String USER="root";
    private static final String PASSWORD="";
    static { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch(Exception e) { e.printStackTrace(); } }
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL,USER,PASSWORD); }
}
