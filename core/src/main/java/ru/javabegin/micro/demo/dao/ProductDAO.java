package ru.javabegin.micro.demo.dao;

import ru.javabegin.micro.demo.model.Product;
import ru.javabegin.micro.demo.model.PuckupPoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from products ORDER BY id DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("description")
                );
                p.setPickupPoints(getPickupPointsForProduct(p.getId()));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    private List<PuckupPoint> getPickupPointsForProduct(int productId) {
        List<PuckupPoint> list = new ArrayList<>();
        String sql = "SELECT p.id, p.city, p.address " +
            "FROM pickup_points p " +
            "JOIN product_pickup_points pp ON p.id = pp.pickup_id " +
            "WHERE pp.product_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PuckupPoint(
                    rs.getInt("id"),
                    rs.getString("city"),
                    rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void addProduct(Product product, List<Integer> pickupIds) {
        String sql = "INSERT INTO products (name, price, description) " +
            "VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt("id");
                linkProductToPickupPoints(conn, productId, pickupIds);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void linkProductToPickupPoints(Connection conn, int productId, List<Integer> pickupIds) {
        String sql = "INSERT INTO product_pickup_points (product_id, pickup_id) VALUES(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int pickupId : pickupIds) {
                ps.setInt(1, productId);
                ps.setInt(2, pickupId);
                ps.addBatch(); //Добавляет в пакет для совместного выполнения
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
