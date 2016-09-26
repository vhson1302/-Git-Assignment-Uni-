<%-- 
    Document   : index
    Created on : Aug 2, 2016, 10:49:59 PM
    Author     : sonvu
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.dataAccess"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

        <title>Delete Categories</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <%
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/PRJ321DB?useSSL=false";
            conn = DriverManager.getConnection(url, "sa", "123456");

            Statement st = conn.createStatement();
            String sqlSelect = "SELECT * FROM PRJ321DB_LAB5.Categories;";
            ResultSet rs = st.executeQuery(sqlSelect);

            dataAccess da = new dataAccess();
            String oldId = request.getParameter("oldId");

            String a;
            String id;
        %>

        <div class="container">
            <form name= "form" role="form" action="<%=request.getContextPath()%>/testSelect" style="width: 50%; margin: auto">
                <h1>Hello !</h1>
                <div class="form-group">
                    <label>ID </label>
                    <select id="mySelect" name = "oldId" class="form-group" onchange= "document.form.submit();">
                        <option></option>
                        <%
                            while (rs.next()) {
                                id = rs.getString(1);
                        %>
                        <option><%=id%></option>
                        <% }%>
                    </select>
                </div>
                <div>
                    <label>CategoryName </label>
                    <%
                        a = (String) request.getAttribute("listName");
                    %>
                    <input type="text" name="categoryName" class="form-control" value="<%=a%>"/>

                </div>
                <br>
                <button class="btn btn-default" type="submit">Delete</button>
            </form>
        </div>
                    <p><a href="logout.jsp">Log out</a></p>
    </body>
</html>
