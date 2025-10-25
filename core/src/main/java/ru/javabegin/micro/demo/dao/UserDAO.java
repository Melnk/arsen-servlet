package ru.javabegin.micro.demo.dao;

import ru.javabegin.micro.demo.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/arsen_site";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ PostgreSQL драйвер загружен");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ PostgreSQL JDBC Driver не найден!");
            e.printStackTrace();
        }
    }

    // Поиск пользователей по email
    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                    );
                }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean save(User user) {
        String sql = "INSERT INTO users(email, password, role) values(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql)) {
            //
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при сохранении пользователя: " + e.getMessage());
            return false;
        }
    }
}
