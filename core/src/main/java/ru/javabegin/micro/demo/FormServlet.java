package ru.javabegin.micro.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@WebServlet("/submit")
public class FormServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name == null || email == null
        || name.trim().isEmpty() || email.trim().isEmpty()
        || !email.contains("@")) {
            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<p style='color:red;'>Ошибка: заполните поля корректно!</p>");
            resp.getWriter().println("<a href='form.html'>Назад к форме</a>");
            resp.getWriter().println("</body></html>");
            return;
        }

        File file = new File(getServletContext().getRealPath("/WEB-INF/data.txt"));
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(name + ", " + email + "\n");
        }

        resp.sendRedirect("thanks.html");
    }
}
