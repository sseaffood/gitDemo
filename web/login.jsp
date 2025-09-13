<%-- 
    Document   : login
    Created on : Aug 20, 2025, 9:45:45 AM
    Author     : 84904
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN UI</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.login.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <form action="loginController" method="post">
            <div class="imgcontainer">
                <img src="imgs/2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <button type="submit">Login</button>
            </div>
            <c:if test="${not empty requestScope.ERROR}">
                <div class="container" style="background-color:#f1f1f1">
                    <b style="color: red">${requestScope.ERROR}</b>
                </div>
            </c:if>
        </form>
    </body>
</html>
