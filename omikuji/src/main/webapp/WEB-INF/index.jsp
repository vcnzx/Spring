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
    <link rel="stylesheet" href="/src/main/resources/static/css/lux.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container mt-3">
        <h1>Send an Omikuji</h1>
        <div class="card w-75">
            <form action="/process" method="post">
                <div class="d-flex flex-column justify-content-center">
                    <div>
                        <label for="number" class="form-label mt-3">Pick any number from 5 to 25:</label>
                        <input type="number" name="number" id="number" class="form-control w-50">
                    </div>
                    <div>
                        <label for="city" class="form-label mt-3">Enter the name of any city:</label>
                        <input type="text" name="city" id="city" class="form-control">
                    </div>
                    <div>
                        <label for="name" class="form-label mt-3">Enter the name of any real person:</label>
                        <input type="text" name="name" id="name" class="form-control">
                    </div>
                    <div>
                        <label for="hobby" class="form-label mt-3">Enter professional endeavor or hobby:</label>
                        <input type="text" name="hobby" id="hobby" class="form-control">
                    </div>
                    <div>
                        <label for="animal" class="form-label mt-3">Enter any type of living thing:</label>
                        <input type="text" name="animal" id="animal" class="form-control">
                    </div>

                    <label for="message" class="form-label">Say something nice to someone:</label>
                    <textarea name="message" id="message" cols="20" rows="5"></textarea>

                </div>
                <div><em>Send and show a friend</em></div>
                <div class="d-flex justify-content-end">
                    <button class="d-flex btn btn-primary">Send</button>
                </div>
            </form>

        </div>
    </div>
</body>
</html>