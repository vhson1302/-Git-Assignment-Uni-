<%-- 
    Document   : index
    Created on : Aug 2, 2016, 10:49:59 PM
    Author     : sonvu
--%>

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

        <title>Update Products</title>

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
            String sqlSelect = "SELECT * FROM PRJ321DB_LAB5.Products;";
            ResultSet rs = st.executeQuery(sqlSelect);             
        %>
        
        <div class="container">
            <form role="form" action="<%=request.getContextPath()%>/updateProdProc" style="width: 50%; margin: auto">
                <h1>UPDATE Products</h1>
                <br>
                <div class="form-group">
                    <label>ID </label>
                    <select name = "oldId" class="form-group">
                        <%
                            while(rs.next()) { 
                        %>
                        <option><%=rs.getString(1)%></option>
                        <% } %>
                    </select>
                    <br>
                    <label>New ID</label>
                    <input type="text" name="newId" class="form-control"/>
                    <%
                        Object checkUpdate = session.getAttribute("checkUpdate");
                        if (checkUpdate == "false") {%>
                    <p class="help-block">Must be int</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <div>
                    <label>New Product Name </label>
                    <input type="text" name="newProductName" class="form-control"/>
                    <%
                        if (checkUpdate == "false") {%>
                    <p class="help-block">Must be string</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <div class="form-group">
                    <label>New Quantity </label>
                    <input type="text" name="newQuantity" class="form-control"/>
                    <%
                        if (checkUpdate == "false") {%>
                    <p class="help-block">Must be int</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <div class="form-group">
                    <label>New Price </label>
                    <input type="text" name="newPrice" class="form-control"/>
                    <%
                        if (checkUpdate == "false") {%>
                    <p class="help-block">Must be int</p> 
                    <% } else { %>
                    <p class="help-block"></p>
                    <%}
                    %>
                </div>
                <br>
                <button class="btn btn-default" type="submit">Update</button>
            </form>
        </div>
                <p><a href="logout.jsp">Log out</a></p>
    </body>
</html>
