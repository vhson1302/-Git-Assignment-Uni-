package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import dao.dataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class deleteCategories_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    Object checkacc = session.getAttribute("loggedIn");
    if (checkacc == null) {
        response.sendRedirect("login.jsp");
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Delete Categories</title>\n");
      out.write("\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"bootstrap/jquery.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form name= \"form\" role=\"form\" action=\"");
      out.print(request.getContextPath());
      out.write("/testSelect\" style=\"width: 50%; margin: auto\">\n");
      out.write("                <h1>Hello !</h1>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>ID </label>\n");
      out.write("                    <select id=\"mySelect\" name = \"oldId\" class=\"form-group\" onchange= \"document.form.submit();\">\n");
      out.write("                        <option></option>\n");
      out.write("                        ");

                            while (rs.next()) {
                                id = rs.getString(1);
                        
      out.write("\n");
      out.write("                        <option>");
      out.print(id);
      out.write("</option>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label>CategoryName </label>\n");
      out.write("                    ");

                        a = (String) request.getAttribute("listName");
                    
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"categoryName\" class=\"form-control\" value=\"");
      out.print(a);
      out.write("\"/>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <button class=\"btn btn-default\" type=\"submit\">Delete</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("                    <p><a href=\"logout.jsp\">Log out</a></p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
