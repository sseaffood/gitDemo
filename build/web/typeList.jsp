<%-- 
    Document   : typeList
    Created on : Aug 24, 2025, 3:17:05 PM
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
            <h2 class="mt-4 mb-3">List of Type</h2>
            <form action="MainController" method="get" class="d-flex">
                <input type="number" name="searchType" value="${param.search}" required="" class="form-control me-2" placeholder="Enter Type ID to search">
                <button type="submit" name="action" value="searchType" class="btn btn-outline-primary">🔍 Search</button>
            </form><br>
            
            <form action="MainController" method="post" class="d-inline">
                <button type="submit" name="action" value="createType" class="btn btn-success">➕ New type</button>
            </form>
            
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Type ID</th>
                        <th>Type Name</th>
                        <th>Tools</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${LIST_TYPE}">
                    <form action="MainController" method="post">
                        <tr>
                            <td>
                                ${i.typeId}
                                <input type="hidden" name="typeId" value="${i.typeId}">
                                <input type="hidden" name="action" value="updateType">
                            </td>
                            <td>
                                <input type="text" name="typeName" class="form-control" 
                                       value="${i.typeName}" size="${i.typeName.length()}" required/>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm">Update</button>
                                <a class="btn btn-danger btn-sm" 
                                   href="MainController?action=deleteType&typeId=${i.typeId}">Delete</a>
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
            <p style="color: red">${requestScope.DELETE_ERROR}</p>
        </div>
    </body>
</html>