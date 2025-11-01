# Arsen Servlet Demo

Полнофункциональный учебный web-проект на Jakarta Servlets (Tomcat 10+) с подключением PostgreSQL, JDBC, JWT-аутентификацией и MVC-архитектурой.
Приложение реализует личный кабинет пользователя, каталог товаров, корзину и оформление заказов.

---

Основные функционал

- **Регистрация и авторизация пользователей**
- **Разделение ролей User/Admin**
- **Добавление и просмотр товаров**
- **Корзина с расчётом итоговой суммы**
- **Оформление заказов**
- **Подключение к PostgreSQL через JDBC**
- **Работа по паттерну MVC**
- **Использование WebFilter и WebListener**
- **HTML/JS frontend с AJAX и LocalStorage**
- **Поддержка светлой/тёмной темы**
- **Использование JSP/Freemarker (для динамических страниц)**

---

## Запуск проекта в IntelliJ IDEA

1. Убедись, что установлен **Apache Tomcat 10.x** и JDK 17+.
2. Открой проект в IDEA.
3. Создай артефакт:
   - `File → Project Structure → Artifacts → + → Web Application: Exploded → выбери модуль`.
   - Перетащи `form.html`, `thanks.html`, `style.css`, `script.js` в корень артефакта.
4. Создай конфигурацию Tomcat:
   - `Run → Edit Configurations → + → Tomcat Server → Local`.
   - Во вкладке **Deployment** добавь свой артефакт.
   - Укажи `Application context: /`.
5. Запусти сервер (`Shift+F10`).

---

## Примечания

- Файл с данными создаётся/дополняется в папке `WEB-INF`. Он недоступен напрямую из браузера.
- Для добавления новых страниц помести их в корень `web/` (не в `WEB-INF`).
- Для сборки `.war` можно использовать `Build → Build Artifacts → Build War`.

---


## Галерея

### Авторизация
<img width="1917" height="955" alt="image" src="https://github.com/user-attachments/assets/f5596b44-80a6-48bf-a2b4-359d5c1f5af2" />

### Главное меню
<img width="1917" height="958" alt="image" src="https://github.com/user-attachments/assets/437bbf40-cb7b-4a3e-9490-69828d639771" />

### Биография с темной темой
<img width="1918" height="964" alt="image" src="https://github.com/user-attachments/assets/69368ee3-babe-4e52-a373-0ac70e7b8f6c" />

### Галерея с изображениями
<img width="1915" height="959" alt="image" src="https://github.com/user-attachments/assets/4a208fb7-a94b-4193-aecc-35ddbdbacf70" />

### Форма для обратной связи
<img width="1918" height="962" alt="image" src="https://github.com/user-attachments/assets/986bd784-7c0f-4cc8-b505-ac6f62d1d4cb" />

### Товары
<img width="1916" height="959" alt="image" src="https://github.com/user-attachments/assets/b70e98ea-805b-49e6-bd3c-3a8b7d5e56d9" />

### Добавление в корзину
<img width="1916" height="959" alt="image" src="https://github.com/user-attachments/assets/b1bd28d0-e4d7-4c41-9749-8c095c887b5e" />

### Корзина
<img width="1918" height="955" alt="image" src="https://github.com/user-attachments/assets/e406e316-c83c-4452-8b6a-3aae7c3aa46e" />





