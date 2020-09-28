/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author marsi
 */
@WebServlet(name = "Empleados", urlPatterns = {"/Empleados"})
public class Empleados extends HttpServlet {

    Connection cnx = null;
    Statement sta = null;
    ResultSet rs = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
     try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojsp?user=root&password=");
                sta = cnx.createStatement();
                String query = "SELECT * FROM usuarios";
                String where=" where 1=1 ";
                String nombre = request.getParameter("nombre");
                              
                if (nombre!=null) {
                    where=where+" and nomUsu='"+nombre+"' ";
                   
                }
                query=query+where;
                nombre=nombre.replaceAll("'", "\\\\'");
                rs = sta.executeQuery(query);               
              
                while (rs.next()) {
                    out.print("<tr>"
                            + "<tr>"
                            + "<th> "+rs.getString(1)+"</th>"
                            + "<th> "+rs.getString(2)+"</th>"
                            + "<th> "+rs.getString(3)+"</th>"
                            + "<th> "+rs.getString(4)+"</th>"
                            + "<th> "
                            + " <a href=\"editar.jsp?cod="+rs.getString(1)+"\">"
                            + " <img src=\"Iconos/edit.png\"width=\"30\" height=\"30\"></a> ||"
                            + " \n" 
                            + " <a href=\"eliminar.jsp?cod="+rs.getString(1)+"\"> "
                            + " <img src=\"Iconos/delete.png\" width=\"45\" height=\"45\"></a>"
                            + "</th>"
                            + "</tr>");
                     
                        }
                
                sta.close();
                rs.close();
                cnx.close();
              

            } catch (Exception e) {
                out.print("error mysql " + e);
            }
     
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
