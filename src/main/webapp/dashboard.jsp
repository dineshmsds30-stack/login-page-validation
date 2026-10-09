<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            color: #222;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .card {
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.12);
            width: 420px;
            padding: 30px;
            text-align: center;
        }

        h2 {
            margin-top: 0;
            color: #2c3e50;
        }

        .welcome {
            font-size: 20px;
            margin: 12px 0;
        }

        .logout {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            background: #2c3e50;
            color: #fff;
            padding: 10px 18px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Welcome</h2>
        <div class="welcome">Hello, <strong>${sessionScope.username}</strong>!</div>
        <p>Your login is successful.</p>
        <a href="${pageContext.request.contextPath}/login.jsp" class="logout">Logout</a>
    </div>
</body>
</html>
