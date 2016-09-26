<%-- 
    Document   : index
    Created on : Jul 27, 2016, 12:29:50 AM
    Author     : sonvu
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Object check = session.getAttribute("loggedIn");
    if (check == null) {
            response.sendRedirect("login.jsp");
        }
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Index Page</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body style="text-align: center">
        <h1 class="jumbotron" style="text-align: center">Hello World! This is Index Page</h1>
        <p><a href="categories.jsp">Categories</a></p>
        <p><a href="products.jsp">Products</a></p>       
        <p><a href="logout.jsp">Log out</a></p>
    </body>
</html>
