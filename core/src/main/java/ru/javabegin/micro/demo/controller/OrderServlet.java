package ru.javabegin.micro.demo.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            sb.append(line);
        }
        String json = sb.toString();

        com.google.gson.Gson gson = new com.google.gson.Gson();
        java.util.List<java.util.Map<String, Object>> items = gson.fromJson(json, java.util.List.class);

        if(items == null || items.isEmpty()) {
            resp.getWriter().write("Корзина пуста!");
            return;
        }

        String fileName = "order_" + System.currentTimeMillis() + ".txt";
        try (PrintWriter writer = new PrintWriter(getServletContext().getRealPath("/") + fileName)) {
            double total = 0;
            for (java.util.Map<String,Object> item : items) {
                String name = (String) item.get("name");
                double price = ((Number)item.get("price")).doubleValue();
                int qty = ((Number)item.get("quantity")).intValue();
                double sum = price * qty;
                writer.println(name + " x " + qty + " = " + sum + " ₽");
                total += sum;
            }
            writer.println("Итого: " + total);
        }

        resp.getWriter().write("Заказ сохранен в " + fileName);
    }

}
