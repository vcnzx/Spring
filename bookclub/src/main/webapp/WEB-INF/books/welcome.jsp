<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container mt-3">
        <h1>Welcome, ${userName}</h1>
        <div class="d-flex justify-content-between">
            <p>Books from everyone's shelves</p>
            <a href="/logout" class="btn btn-danger">Logout</a>
        </div>
        <table class="table table-bordered">
            <thead class="table-warning">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>
                            <c:out value="${book.getId()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${book.getTitle()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${book.getAuthor()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${book.user.userName}"></c:out>
                        </td>
                        <td class="d-flex justify-content-around">
                            <a href="/books/${book.id}" class="btn btn-success">View</a>
                            <c:choose>
                                <c:when test="${book.user.id == userId}">
                                    <a href="/books/edit/${book.id}" class="btn btn-info">Edit</a>
                                    <form action="/books/delete/${book.id}" method="POST">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Delete" class="btn-danger">
                                    </form>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/books/new" class="btn btn-primary">Add a Book</a>
    </div>
</body>
</html>