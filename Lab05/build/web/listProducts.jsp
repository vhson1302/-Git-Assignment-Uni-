<%-- 
    Document   : loginHistoryPage
    Created on : Jul 27, 2016, 1:19:12 AM
    Author     : sonvu
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Object check = session.getAttribute("loggedIn");
    if (check == null || check == "1") {
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

        <title>List Products</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%  Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
            conn = DriverManager.getConnection(url, "sa", "123456");
            Statement st = conn.createStatement();
            String sqlSelect = "SELECT * FROM PRJ321DB_LAB5.Products;";
            ResultSet rs = st.executeQuery(sqlSelect);
        %>

        <div class="container">
            <h1>ALL PRODUCTS DATA</h1>
            <br>
            <form role="form" action="<%=request.getContextPath()%>/deleteProdProc">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td></td>
                            <th>Id</th>
                            <th>Categories Id</th>
                            <th>productName</th>
                            <th>quantity</th>
                            <th>pricing</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% while (rs.next()) {%>
                        <tr>
                            <td><input type="radio" name="radio" value="<%=rs.getString(1)%>"></td>
                            <td><%=rs.getString(1)%></td>
                            <td><%=rs.getString(2)%></td>
                            <td><%=rs.getString(3)%></td>
                            <td><%=rs.getString(4)%></td>
                            <td><%=rs.getString(5)%></td>
                            <td><input type="submit" class="btn btn-default" value="Delete"></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </form>
                
                <p><a href="logout.jsp">Log out</a></p>
        </div>

    </body>
</html>
