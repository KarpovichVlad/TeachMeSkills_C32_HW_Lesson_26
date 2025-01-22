package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Устанавливаем тип контента
        resp.setContentType("text/html;charset=UTF-8");

        // Получаем данные из формы регистрации
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Проверяем, если имя пользователя уже существует
        if (UserRepository.users.containsKey(username)) {
            resp.getWriter().write("<h3>A user with that name already exists.</h3>");
            return;
        }

        // Добавляем нового пользователя в репозиторий
        UserRepository.users.put(username, password);

        // Сообщаем пользователю об успешной регистрации
        resp.getWriter().write("<h3>Registration is successful! You can now log in.</h3>");
        resp.getWriter().write("<a href='login.html'>Go to login</a>");
    }
}
