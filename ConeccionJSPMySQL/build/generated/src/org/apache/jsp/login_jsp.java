package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import Utils.Encriptar;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container mt-5\"> \n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm\">\n");
      out.write("                    <form method=\"post\" action=\"login.jsp\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Usuario</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"user\" placeholder=\"Pon Usuario\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Pon Password\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\" name=\"login\">Login</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");


                        Encriptar enc = new Encriptar();
                        Connection cnx = null;
                        Statement sta = null;
                        ResultSet rs = null;

                        if (request.getParameter("login") != null) {
                            String nombre = request.getParameter("user");
                            String pass = request.getParameter("password");
                            HttpSession sesion = request.getSession();

                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                //inicialisado cadena de coneccion
                                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojsp?user=root&password=");

                                //Iniciacilizar el statemten 
                                sta = cnx.createStatement();

                                //ejecuar sentencia sql
                                rs = sta.executeQuery("select * from usuarios where nomUsu='" + nombre + "' and passUsu='" + enc.getMD5(pass) + "';");

                                while (rs.next()) {

                                    sesion.setAttribute("logueado", "1");
                                    sesion.setAttribute("nombre", rs.getString(2));
                                    response.sendRedirect("Listado.jsp");

                                }

                                out.println(" <div class=\"alert alert-danger\" role=\"alert\"> Usuario no valido </div>");

                            } catch (Exception e) {
                            }

                        }


                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
