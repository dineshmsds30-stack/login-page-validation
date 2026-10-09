package com.example.login.controller;

import com.example.login.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.{6,30}$)([a-zA-Z0-9._@-]+)$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String errorMessage = validateLogin(username, password);

        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        if (!userService.authenticate(username, password)) {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username.trim());
        session.setAttribute("loggedIn", true);

        response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
    }

    private String validateLogin(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return "Username is required.";
        }

        if (password == null || password.trim().isEmpty()) {
            return "Password is required.";
        }

        String trimmedUsername = username.trim();
        String trimmedPassword = password.trim();

        if (!USERNAME_PATTERN.matcher(trimmedUsername).matches()) {
            return "Username must be 6 to 30 characters and may contain letters, numbers, dot, underscore, @, hyphen.";
        }

        if (!PASSWORD_PATTERN.matcher(trimmedPassword).matches()) {
            return "Password must be at least 8 characters including uppercase, lowercase, number, and special character.";
        }

        return null;
    }
}
