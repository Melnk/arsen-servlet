<%--
  Created by IntelliJ IDEA.
  User: melni
  Date: 23.10.2025
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация — Сайт Арсена</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Регистрация</h1>
    <p>Создайте свой аккаунт</p>
</header>

<form action="register" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Пароль:</label>
    <input type="password" name="password" required>

    <label>Повторите пароль:</label>
    <input type="password" name="confirm" required>

    <button type="submit">Зарегистрироваться</button>
</form>

<% if (request.getParameter("exists") != null) { %>
<p style="color:red;">Такой email уже существует!</p>
<% } else if (request.getParameter("error") != null) { %>
<p style="color:red;">Ошибка при регистрации!</p>
<% } %>

</body>
</html>

