package ru.javabegin.micro.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/submit")
public class FormServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name == null || email == null
        || name.trim().length() == 0 || email.trim().length() == 0
        || !email.contains("@")) {
            resp.getWriter().println("<!DOCTYPE html><html><body>");
            resp.getWriter().println("<p style='color:red;'>Ошибка: заполните поля корректно!</p>");
            resp.getWriter().println("<a href='form.html'>Назад к форме</a>");
            resp.getWriter().println("</body></html>");
            return;
        }

        File file = new File(getServletConte)
    }

}
