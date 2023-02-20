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
    <div class="container mt-3">
        <h1>Save Travels</h1>
        <div class="card">
            <table class="table table-bordered">
                <thead class="table-warning">
                    <tr>
                        <th scope="col">Expense</th>
                        <th scope="col">Vendor</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="expense" items="${expenses}">
                        <tr>
                            <td> 
                                <c:out value="${expense.getExpense()}"></c:out>
                            </td>
                            <td>
                                <c:out value="${expense.getVendor()}"></c:out>
                            </td>
                            <td>
                                <c:out value="${expense.getAmount()}"></c:out>
                            </td>
                            <td><a href="/expenses/${expense.id}">View</a>
                            <a href="/expenses/edit/${expense.id}">Edit</a>
                            <form action="/expenses/delete/${expense.id}" method="POST">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete">
                            </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="/expenses/new">Add Expense</a>
        </div>

    </div>
</body>
</html>
