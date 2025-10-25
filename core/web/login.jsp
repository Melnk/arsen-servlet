<%--
  Created by IntelliJ IDEA.
  User: melni
  Date: 23.10.2025
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вход — Сайт Арсена</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Добро пожаловать</h1>
    <p>Авторизуйтесь, чтобы продолжить</p>
</header>

<form action="login" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Пароль:</label>
    <input type="password" name="password" required>

    <button type="submit">Войти</button>
</form>

<% if (request.getParameter("error") != null) { %>
<p style="color:red;">Неверный логин или пароль</p>
<% } else if (request.getParameter("registered") != null) { %>
<p style="color:green;">Регистрация прошла успешно!</p>
<% } %>

<p><a href="register.jsp">Нет аккаунта? Зарегистрируйтесь</a></p>
</body>
</html>
