<%-- 
    Document   : header
    Created on : Aug 21, 2025, 8:16:35 AM
    Author     : 84904
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.header.css"/>

<div class="navbar">
    <div class="navbar-left">
        <a href="user.jsp" class="logo">Human System</a>
        <a href="user.jsp">Home</a>
        <div class="dropdown">
            <button class="dropbtn">Menu</button>
            <div class="dropdown-content">
                <a href="MainController?action=searchType">Human Type</a>
                <a href="MainController?action=searchHuman">Human List</a>
            </div>
        </div>
    </div>
    <div class="navbar-right">
        <a href="#">Sign Up</a>
        <a href="MainController?action=logout">Log out</a>
    </div>
</div>