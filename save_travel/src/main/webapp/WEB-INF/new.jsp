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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <h1>New Expense Form</h1>
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
        <div class="card">
            <!-- <form action="/expenses" method="post">
            <label for="expense" class="form-label">Expense: </label>
            <input type="text" name="expense" id="expense" class="form-control w-50">
            <label for="vendor" class="form-label">Vendor: </label>
            <input type="text" name="vendor" id="vendor" class="form-control w-50">
            <label for="amount" class="form-label">Price</label>
            <input type="number" name="amount" id="amount" class="form-control w-50">
            <div class="d-flex flex-column mb-3 w-50">
                <label for="description" class="form-label my-auto">Description: </label>
                <textarea name="description" id="description" cols="30" rows="5"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form> -->
        <form:form action="/expenses" method="POST" modelAttribute="expenses">
            <div class="form-control">
                <form:label path="expense">Expense: </form:label>
                <form:errors path="expense"></form:errors>
                <form:input path="expense"></form:input>
            </div>
            <div class="form-control">
                <form:label path="vendor">Vendor: </form:label>
                <form:errors path="vendor"></form:errors>
                <form:input path="vendor"></form:input>
            </div>
            <div class="form-control">
                <form:label path="amount">Price: </form:label>
                <form:errors path="amount"></form:errors>
                <form:input path="amount"></form:input>
            </div>
            <div class="form-control">
                <form:label path="description">Description: </form:label>
                <form:errors path="description"></form:errors>
                <form:input path="description"></form:input>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Add Book</button>
        </form:form>
        </div>
    </div>
</body>
</html>