package ru.javabegin.micro.demo.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javabegin.micro.demo.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Кодировка и тип ответа
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        // Создаем список товаров
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Футболка Арсена", 1500));
        products.add(new Product(2, "Кепка Арсена", 800));
        products.add(new Product(3, "Постер Арсена", 400));
        products.add(new Product(4, "Футболка", 1590));

        // Формируем JSON вручную
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            sb.append("{")
                .append("\"id\":").append(p.getId()).append(",")
                .append("\"name\":\"").append(p.getName()).append("\",")
                .append("\"price\":").append(p.getPrice())
                .append("}");
            if (i < products.size() - 1) sb.append(",");
        }
        sb.append("]");

        // Отправляем ответ
        try (PrintWriter out = resp.getWriter()) {
            out.write(sb.toString());
        }
    }
}
