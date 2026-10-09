package com.example.login.service;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("admin@demo.com", "Admin@123");
        USERS.put("user123", "User@123");
        USERS.put("demo.user", "Demo@456");
    }

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        String trimmedUsername = username.trim();
        String trimmedPassword = password.trim();

        String storedPassword = USERS.get(trimmedUsername);
        return storedPassword != null && storedPassword.equals(trimmedPassword);
    }
}
