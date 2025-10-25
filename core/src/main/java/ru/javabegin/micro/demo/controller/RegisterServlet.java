package ru.javabegin.micro.demo.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javabegin.micro.demo.dao.UserDAO;
import ru.javabegin.micro.demo.model.User;
import java.io.IOException;
import java.util.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");

        String contextPath = req.getContextPath();

        if (email == null || password == null || !password.equals(confirm)) {
            resp.sendRedirect(contextPath + "/register.jsp?error=true");
            return;
        }

        UserDAO dao = new UserDAO();
        if (dao.findByEmail(email) != null) {
            resp.sendRedirect(contextPath + "/register.jsp?error=true");
            return;
        }

        User newUser = new User(0, email, password, "user");
        if (dao.save(newUser)) {
            resp.sendRedirect(contextPath + "/login.jsp?registered=true");
        } else {
            resp.sendRedirect(contextPath + "/register.jsp?error=true");
        }
    }


}
