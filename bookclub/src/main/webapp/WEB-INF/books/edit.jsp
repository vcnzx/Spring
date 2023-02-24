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
    <title>Book form</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>Add a Book to Your Shelf!</h1>
    
    <form:form action="/books/${book.id}" method="POST" modelAttribute="book">
        <input type="hidden" name="_method" value="put">
        <form:hidden path="user" value="${userId}"></form:hidden>
        <div class="form-control">
            <form:label path="title">Title: </form:label>
            <form:errors path="title"></form:errors>
            <form:input path="title"></form:input>
        </div>
        <div class="form-control">
            <form:label path="author">Author: </form:label>
            <form:errors path="author"></form:errors>
            <form:input path="author"></form:input>
        </div>
        <div class="form-control">
            <form:label path="myThoughts">Thoughts: </form:label>
            <form:errors path="myThoughts"></form:errors>
            <form:input path="myThoughts"></form:input>
        </div>
        <button type="submit" class="btn btn-warning mt-3">Update Book</button>
    </form:form>
</body>
</html>