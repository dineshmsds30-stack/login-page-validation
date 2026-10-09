<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://code.jquery.com/jquery-3.12.4.min.js"></script>
</head>
<body>
<div class="login-container">
    <form id="loginForm" method="post" action="${pageContext.request.contextPath}/login" novalidate>
        <h2>Login</h2>

        <c:if test="${not empty errorMessage}">
            <div class="error-message" id="serverError">${errorMessage}</div>
        </c:if>

        <div class="input-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter username or email" value="${param.username}">
            <span class="field-error" id="usernameError"></span>
        </div>

        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter password">
            <span class="field-error" id="passwordError"></span>
        </div>

        <button type="submit" class="login-btn">Login</button>
    </form>
</div>

<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>
