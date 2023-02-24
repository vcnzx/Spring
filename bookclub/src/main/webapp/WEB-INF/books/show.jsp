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
    <title>Bookclub</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <div class="card mt-3">
            <div class="d-flex justify-content-between">
                <h1>${book.title}</h1>
                <a href="/books">Back to book shelves</a>
            </div>
            <h4>${book.user.userName} read ${book.title} by ${book.author}.</h4>
            <br>
            <h3>Here are ${book.user.userName}'s thoughts:</h3>
            <p>${book.myThoughts}</p>
        </div>
        <c:choose>
            <c:when test="${book.user.id == userId}">
                <div class="d-flex gap-3">
                    <a href="/books/edit/${book.id}" class="btn btn-warning">Edit</a>                    
                    <form action="/books/delete/${book.id}" method="POST">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete" class="btn-danger">
                    </form>
                </div>
            </c:when>
        </c:choose>
    </div>

</body>
</html>