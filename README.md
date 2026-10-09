# Login Page Validation Project

This project demonstrates a login page built with:
- HTML
- CSS
- jQuery
- JSP
- Java Servlet validation

## Features
- Client-side validation using jQuery
- Server-side validation using Java
- Required field checks
- Email / username pattern validation
- Password strength validation
- Session-based successful login flow
- Error messages displayed on the page

## Project Structure

- `src/main/webapp/` - JSP, CSS, JS files
- `src/main/java/com/example/login/controller/LoginServlet.java` - login request handling
- `src/main/java/com/example/login/service/UserService.java` - credential validation logic

## Run the project

1. Open terminal in the project folder.
2. Run:

```bash
mvn clean package
```

3. Deploy the generated WAR file to Tomcat.
4. Open:

```text
http://localhost:8080/login-app/login.jsp
```

## Demo credentials

- Username: `admin@demo.com`  
  Password: `Admin@123`

- Username: `user123`  
  Password: `User@123`

