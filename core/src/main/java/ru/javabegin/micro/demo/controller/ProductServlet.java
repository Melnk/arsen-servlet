package ru.javabegin.micro.demo.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javabegin.micro.demo.dao.ProductDAO;
import ru.javabegin.micro.demo.model.Product;

import java.io.IOException;
import java.util.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");

        System.out.println("Получен запрос на /products");

        try {
            List<Product> products = productDAO.getAllProducts();

            System.out.println("После запроса к БД, количество товаров: " + products.size());

            // Добавьте отладку каждого товара
            for (Product p : products) {
                System.out.println("Товар: " + p.getName() +
                    ", ID: " + p.getId() +
                    ", Цена: " + p.getPrice() +
                    ", Точек выдачи: " + (p.getPickupPoints() != null ? p.getPickupPoints().size() : 0));
            }

            String json = new Gson().toJson(products);
            System.out.println("Отправляемый JSON: " + json);

            resp.getWriter().write(json);

        } catch (Exception e) {
            System.err.println("Критическая ошибка в ProductServlet: " + e.getMessage());
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"error\":\"Ошибка сервера\"}");
        }
    }
}
