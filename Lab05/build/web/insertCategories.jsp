<%-- 
    Document   : index
    Created on : Aug 2, 2016, 10:49:59 PM
    Author     : sonvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Object checkacc = session.getAttribute("loggedIn");
    if (checkacc == null) {
            response.sendRedirect("login.jsp");
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Insert Categories</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <form role="form" action="<%=request.getContextPath()%>/insertCateProc" style="width: 50%; margin: auto">
                <h1>Insert Categories</h1>
                <div class="form-group">
                    <label>ID </label>
                    <input type="text" name="id" class="form-control"/>
                    <%
                        Object check = session.getAttribute("checkinsert");
                        if (check == "false") {%>
                    <p class="help-block">Must be int</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <div>
                    <label>CategoryName </label>
                    <input type="text" name="categoryName" class="form-control"/>
                    <%
                        if (check == "false") {%>
                    <p class="help-block">Must be string</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <br>
                <button class="btn btn-default" type="submit">Insert</button>
            </form>
        </div>
                <p><a href="logout.jsp">Log out</a></p>
    </body>
</html>
