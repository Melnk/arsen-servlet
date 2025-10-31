package ru.javabegin.micro.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/arsen_site";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ PostgreSQL драйвер загружен");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ PostgreSQL JDBC Driver не найден! Блок ProductDAO");
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
