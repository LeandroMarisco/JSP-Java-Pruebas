package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class editar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Editar Usiarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2 align=\"center\">Editar Usiarios</h2>\n");
      out.write("        ");

            String cod = request.getParameter("cod");

            //declarado variables 
            Connection cnx = null;
            Statement sta = null;
            ResultSet rs = null;

            try {
                //Inicializado el driver 
                Class.forName("com.mysql.jdbc.Driver");
                //inicialisado cadena de coneccion
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojsp?user=root&password=");

                //Iniciacilizar el statemten 
                sta = cnx.createStatement();

                //ejecuar sentencia sql
                rs = sta.executeQuery("select * from usuarios where CodUsu='" + cod + "'");

                while (rs.next()) {

        
      out.write("\n");
      out.write("        <form action=\"\">\n");
      out.write("            <table border=\"1\" width=\"250\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Codigo:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtCod\" value=\"");
      out.print(rs.getString(1));
      out.write("\" readonly=\"readonly\"></td>\n");
      out.write("                </tr>  \n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtNom\" value=\"");
      out.print(rs.getString(2));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>    \n");
      out.write("                    <td>Edad: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtEdad\" value=\"");
      out.print(rs.getString(3));
      out.write("\" ></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>    \n");
      out.write("                    <td>Sexo: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtSexo\" value=\"");
      out.print(rs.getString(4));
      out.write("\" ></td>\n");
      out.write("                </tr>    \n");
      out.write("                <tr>    \n");
      out.write("                    <td>Password: </td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtPas\" value=\"");
      out.print(rs.getString(5));
      out.write("\" ></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"2\">\n");
      out.write("                        <input type=\"submit\" name=\"btnGrabar\" value=\"Editar Usuario\">\n");
      out.write("                        </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>                \n");
      out.write("        ");

                }
          } catch (Exception e) {}
            if(request.getParameter("btnGrabar")!=null){
            //Tomo los datos ingresados y les doy una variable
        String codu=request.getParameter("txtCod");
        String nomu=request.getParameter("txtNom");
        int edad=Integer.parseInt(request.getParameter("txtEdad"));
        String sexo=request.getParameter("txtSexo");
        String pas=request.getParameter("txtPass");
        
        //Edito los datos
        sta.executeUpdate("update usuarios set nomUsu='"+nomu+"',edadUsi="+edad+",SexoUsu='"+sexo+"',PassUsu'"+pas+"' where CodUsu='"+codu+"'");

        request.getRequestDispatcher("Listado.jsp").forward(request, response);
}
         
      out.write("                              \n");
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
