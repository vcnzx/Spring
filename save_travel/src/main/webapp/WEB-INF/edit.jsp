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
        <h1>Edit Expense Form</h1>

        <div class="card">

        <form:form action="/expenses/${expenses.id}" method="post" modelAttribute="expenses">
            <input type="hidden" name="_method" value="put">
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
            <button type="submit" class="btn btn-primary mt-3">Update Expense</button>
        </form:form>
        </div>
    </div>
</body>
</html>