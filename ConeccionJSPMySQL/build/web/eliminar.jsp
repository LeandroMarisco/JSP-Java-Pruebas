<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usiarios</title>
    </head>
    <body>
        <%           
            //Tomo los datos ingresados y les doy una variable
        String cod=request.getParameter("cod");
        
        //Coneccion y declaracion de variable de la conexio
         Connection cnx=null;
         Statement sta=null;
         ResultSet rs=null; 

        try{
        //Inicialicar coneccion y driver
        Class.forName("com.mysql.jdbc.Driver");
        //inicialisado cadena de coneccion
        cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojsp?user=root&password=");
        
        sta= cnx.createStatement();
        
        //ejecuar sentencia sql
        sta.executeUpdate("delete from usuarios where CodUsu='"+cod+"'");
        request.getRequestDispatcher("Listado.jsp").forward(request, response);
        
        sta.close();
        rs.close();
        cnx.close();
        
        }catch(Exception e){out.print(e+"");}   
        
        %>
    </body>
</html>
