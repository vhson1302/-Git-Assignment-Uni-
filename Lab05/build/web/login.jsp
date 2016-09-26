<%-- 
    Document   : index
    Created on : Aug 2, 2016, 10:49:59 PM
    Author     : sonvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login Page</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">

            <form role="form" action="<%=request.getContextPath()%>/loginProc" style="width: 50%; margin: auto">
                <h1>Hello !</h1>
                <div class="form-group">
                    <label>Username: </label>
                    <input type="text" name="username" class="form-control"/>
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" name="password" class="form-control"/>
                </div>
                
                <!--check account true or false-->
                <%
                    Object check = session.getAttribute("loggedIn");
                    if (check == "false") { %>
                <p class="help-block">Account ID or Password NOT TRUE.</p>
                <%} else {%>
                <p class="help-block"></p>
                <%}%>

                <button class="btn btn-default" type="submit">Log In</button>
            </form>
        </div>
    </body>
</html>
