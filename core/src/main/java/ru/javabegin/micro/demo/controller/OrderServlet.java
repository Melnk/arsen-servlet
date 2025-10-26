package ru.javabegin.micro.demo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        }

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(sb.toString(), JsonObject.class);

        // Получаем массив items
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> items = gson.fromJson(json.get("items"), listType);

        if (items == null || items.isEmpty()) {
            resp.getWriter().write("{\"status\":\"error\", \"message\":\"Пустой заказ\"}");
            return;
        }

        resp.getWriter().write("{\"status\":\"ok\", \"message\":\"Заказ успешно оформлен!\"}");
    }
}
