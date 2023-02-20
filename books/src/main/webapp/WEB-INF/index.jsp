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
    <title>Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <h1>Book Store</h1>
        <div class="card mt-3">
            <table class="table table-bordered">
                <thead class="table-warning">
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Pages</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td> 
                                <c:out value="${book.getTitle()}"></c:out>
                            </td>
                            <td>
                                <c:out value="${book.getAuthor()}"></c:out>
                            </td>
                            <td>
                                <c:out value="${book.getPages()}"></c:out>
                            </td>
                            <td><a href="/books/${book.id}">View</a>
                            <a href="/books/edit/${book.id}">Edit</a>
                            <form action="/books/delete/${book.id}" method="POST">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete">
                            </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a class="btn btn-primary" href="/books/new">Add a book</a>
    </div>

</body>
</html>