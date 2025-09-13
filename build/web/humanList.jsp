<%-- 
    Document   : humanList
    Created on : Aug 21, 2025, 10:18:35 PM
    Author     : 84904
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.table.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human List</title>
    </head>
    <jsp:include page="header.jsp"/>
    <body>

        <div class="container">
            <h2 class="mt-4 mb-3">List of human</h2>
            <form action="MainController" method="get" class="d-flex">
                <input type="text" name="search" value="${param.search}" class="form-control me-2" required="" placeholder="Enter human name to search">
                <button type="submit" name="action" value="searchHuman" class="btn btn-outline-primary">🔍 Search</button>
            </form><br>
            <form action="MainController" method="post" class="d-inline">
                <button type="submit" name="action" value="createHuman" class="btn btn-success">➕ Add user</button>
            </form>
            <p style="color: red">${requestScope.ERROR_UPDATE}</p>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Type ID</th>
                        <th>User name</th>
                        <th>Password</th>
                        <th>Role</th>
                        <th>Tools</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${LIST_HUMAN}">
                    <form action="MainController" method="post">
                        <tr>
                            <td>
                                ${i.humanID}
                                <input type="hidden" name="humanId" value="${i.humanID}">
                                <input type="hidden" name="action" value="updateHuman">
                            </td>
                            <td><input type="text" name="humanName" class="form-control" value="${i.humanName}" size="${i.humanName.length()}" required/></td>
                            <td><input type="date" name="dob" class="form-control" value="${i.dob}" required/></td>
                            <td><input type="text" name="gender" class="form-control" value="${i.gender}" required/></td>
                            <td><input type="text" name="typeId" class="form-control" value="${i.typeId}" required/></td>
                            <td><input type="text" name="uname" class="form-control" value="${i.userHuman}" size="${i.userHuman.length()}" required/></td>
                            <td><input type="text" name="psw" class="form-control" value="${i.passHuman}" size="${i.passHuman.length()}" required/></td>
                            <td><input type="text" name="role" class="form-control" value="${i.role}" size="${i.role.length()}" required/></td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm">Update</button>
                                <a class="btn btn-danger btn-sm" href="MainController?action=deleteHuman&humanId=${i.humanID}">Delete</a>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${not empty requestScope.EMPTY_LIST}">
                <div class="container" style="background-color:#f1f1f1">
                    <b style="color: red">${requestScope.EMPTY_LIST}</b>
                </div>
            </c:if>
            <p style="color: red">${requestScope.SUCCESS}</p>
            <p style="color: red">${requestScope.ERROR}</p>
        </div>
    </body>
</html>
