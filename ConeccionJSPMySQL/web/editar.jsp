<%@page import="java.sql.*"%>
<%@page import="Utils.Encriptar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usiarios</title>
    </head>
    <body>
        <h2 align="center">Editar Usiario</h2>
        <%
            Encriptar enc = new Encriptar();
            HttpSession sesion =request.getSession();
        if (sesion.getAttribute("logueado")==null || sesion.getAttribute("logueado").equals("0")) {
                response.sendRedirect("login.jsp");
            }
            
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

        %>
        <form action="editar.jsp" method="get">
            <table border="1" width="250" align="center">
                <tr>
                    <td>Codigo:</td>
                    <td><input type="text" name="txtCod" value="<%=rs.getString(1)%>" readonly="readonly"></td>
                </tr>  
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="txtNom" value="<%=rs.getString(2)%>"></td>
                </tr>
                <tr>    
                    <td>Edad: </td>
                    <td><input type="text" name="txtEdad" value="<%=rs.getString(3)%>" ></td>
                </tr>
                <tr>    
                    <td>Sexo: </td>
                    <td><input type="text" name="txtSexo" value="<%=rs.getString(4)%>" ></td>
                </tr>    
                <tr>    
                    <td>Password: </td>
                    <td><input type="text" name="txtPas" value="<%=rs.getString(5)%>" ></td>
                </tr>

                <tr>
                    <th colspan="2">
                        <a href="Listado.jsp">
                        <img src="Iconos/back.png" width="30" height="30"></a>
                        <input type="submit" name="btnGrabar" value="Editar Usuario">
                        </td>
                </tr>
            </table>
        </form>                
        <%
                }
          } catch (Exception e) {}
            if(request.getParameter("btnGrabar")!=null){
            //Tomo los datos ingresados y les doy una variable
        String codu=request.getParameter("txtCod");
        String nom=request.getParameter("txtNom");
        int edad=Integer.parseInt(request.getParameter("txtEdad"));
        String sexo=request.getParameter("txtSexo");
        String pas=request.getParameter("txtPas");
        

        //Edito los datos
        sta.executeUpdate("update usuarios set nomUsu='"+nom
        +"',edadUsi="+edad+",SexoUsu='"+sexo+"',PassUsu='"+
        enc.getMD5(pas)+"' where CodUsu='"+codu+"';");

        request.getRequestDispatcher("Listado.jsp").forward(request, response);
}
         %>                              
    </body>
</html>
