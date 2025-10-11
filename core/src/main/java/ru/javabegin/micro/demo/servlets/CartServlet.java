package ru.javabegin.micro.demo.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ru.javabegin.micro.demo.models.Cart;
import ru.javabegin.micro.demo.models.Product;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();

        List<Object> items = new ArrayList<>();
        for (Cart.CartItem ci : cart.getItems()) {
            items.add(new java.util.HashMap<>() {{
                put("id", ci.getProduct().getId());
                put("name", ci.getProduct().getName());
                put("price", ci.getProduct().getPrice());
                put("quantity", ci.getQuantity());
            }});
        }

        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write(new Gson().toJson(items));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));

        if ("add".equals(action)) {
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.addProduct(new Product(id, name, price), quantity);
        } else if ("update".equals(action)) {
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.updateProduct(id, quantity);
        } else if ("remove".equals(action)) {
            cart.removeProduct(id);
        }

        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write("{\"status\":\"ok\"}");
    }

}
