package ru.javabegin.micro.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javabegin.micro.demo.models.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Футболка Арсена", 1500));
        products.add(new Product(2, "Кепка Арсена", 800));
        products.add(new Product(3, "Постер Арсена", 2990));

        req.setAttribute("products", products);
        req.getRequestDispatcher("merches.html").forward(req, resp);
    }

}
