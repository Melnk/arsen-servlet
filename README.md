# Arsen Servlet Demo

Пример простого Java Servlet-приложения на Apache Tomcat.  
Форма HTML отправляет данные на сервлет, который выполняет базовую валидацию, сохраняет их в файл и перенаправляет пользователя на страницу «Спасибо».

---

## Структура проекта

- `form.html` — форма для ввода имени и e-mail.
- `thanks.html` — страница с сообщением «Спасибо».
- `SubmitServlet` — принимает POST-запросы, валидирует данные, пишет в файл `WEB-INF/data.txt`, делает редирект.

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

## Использование

1. Открой [http://localhost:8080/form.html](http://localhost:8080/form.html)
2. Введи имя и e-mail.
3. Нажми «Отправить».
4. Сервер проверит данные:
   - если ошибка — вернёт сообщение;
   - если всё корректно — добавит запись в `WEB-INF/data.txt` и перенаправит на `thanks.html`.

---

## Примечания

- Файл с данными создаётся/дополняется в папке `WEB-INF`. Он недоступен напрямую из браузера.
- Для добавления новых страниц помести их в корень `web/` (не в `WEB-INF`).
- Для сборки `.war` можно использовать `Build → Build Artifacts → Build War`.

---

## Функционал

- **Светлая/тёмная тема** (CSS-переключатель).
- **Навигационная панель** (header с ссылками на разделы).
- **Анимации для изображений и кнопок** (CSS transitions/animations).
- **HTML-форма**
- **Валидация данных**
- **Сохранение данных в .txt файл**
- **Реализовано 6 HTML страниц**
---

## Галерея

### Главная страница
<img width="1905" height="1004" alt="image" src="https://github.com/user-attachments/assets/a87cba1e-0478-45d7-abdb-d825903cf29f" />

### Биография с темной темой
<img width="1908" height="1004" alt="image" src="https://github.com/user-attachments/assets/8d26648d-8755-49b9-8572-00a2a428205c" />

### Галерея с изображениями
<img width="1905" height="1004" alt="image" src="https://github.com/user-attachments/assets/26b0934a-7819-4329-a36e-135592bc7c46" />

### Форма для обратной связи
<img width="1905" height="1002" alt="image" src="https://github.com/user-attachments/assets/c291de14-6516-4ba7-93b1-3f2e73754f3f" />


