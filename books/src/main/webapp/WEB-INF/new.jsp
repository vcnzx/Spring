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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <h1>New Book Form</h1>
        <!-- <form action="/books" method="post">
            <label for="title" class="form-label">Title</label>
            <input type="text" name="title" id="title" class="form-control">
            <label for="author" class="form-label">Author</label>
            <input type="text" name="author" id="author" class="form-control">
            <label for="pages" class="form-label">Number of pages</label>
            <input type="number" name="pages" id="pages" class="form-control">
            <button type="submit" class="btn btn-primary">Add Book</button>
        </form> -->
        <!-- <h1>new and improved form</h1> -->
        <form:form action="/books" method="POST" modelAttribute="book">
            <div class="form-control">
                <form:label path="title">Title: </form:label>
                <form:input path="title"></form:input>
            </div>
            <div class="form-control">
                <form:label path="author">Author: </form:label>
                <form:input path="author"></form:input>
            </div>
            <div class="form-control">
                <form:label path="pages">Pages: </form:label>
                <form:input path="pages"></form:input>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Add Book</button>
        </form:form>
    </div>
</body>
</html>