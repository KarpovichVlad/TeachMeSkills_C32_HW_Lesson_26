package servlet;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    // Храним пользователей в Map
    public static final Map<String, String> users = new HashMap<>();

    static {
        // Добавляем несколько пользователей для теста
        users.put("admin", "admin");
        users.put("user", "user");
    }

    public static Boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        }
        return false;
    }

    // Метод для добавления пользователя в Map
    public static void addUser(String username, String password) {
        users.put(username, password);
    }
}
