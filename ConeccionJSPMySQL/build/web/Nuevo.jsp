<%@page import="Utils.Encriptar"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

              

        <title>Registro Usuario</title>
    </head>
    <body>
        <h2 align="center">Registro Usiarios</h2>
    <center>
        <form action="Nuevo.jsp" method="post">
            
        <div class="container"> 
             <div class="row">
                 <div class="col-md-6 text-center">

            <table class="table table-striped table-dark" >
                <tr>
                    <td>Codigo:</td>
                    <td><input type="text" name="txtCod" required="required"></td>
                </tr>  
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="txtNom" required="required"></td>
                </tr>
                <tr>    
                    <td>Edad: </td>
                    <td><input type="text" name="txtEdad" required="required"></td>
                </tr>
                <tr>    
                    <td>Sexo: </td>
                    <td><input type="text" name="txtSexo" required="required"></td>
                </tr>    
                <tr>    
                    <td>Password: </td>
                    <td><input type="text" name="txtPas" required="required"></td>
                </tr>
                
                <tr>
                    <th colspan="2">
                        <a href="Listado.jsp" class="btn btn-danger">
                        <img src="Iconos/back.png" width="30" height="30"></a>
                        <input type="submit" name="btnGrabar" value="Grabar Usuario">
                    </td>
                </tr>
            </table>
                     </div>
                         </div>
        </div>
        </form>
        </center>
        
        
        <%
            Encriptar enc = new Encriptar();
            if(request.getParameter("btnGrabar")!=null){
            
            //Tomo los datos ingresados y les doy una variable
        String cod=request.getParameter("txtCod");
        String nom=request.getParameter("txtNom");
        int edad=Integer.parseInt(request.getParameter("txtEdad"));
        String sexo=request.getParameter("txtSexo");
        String pas=request.getParameter("txtPas");
        
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
        sta.executeUpdate("insert into usuarios values('"+cod+"','"+nom+"',"+edad+",'"+sexo+"','"+enc.getMD5(pas)+"')");
        request.getRequestDispatcher("Listado.jsp").forward(request, response);
        
        sta.close();
        rs.close();
        cnx.close();
        
        }catch(Exception e){out.print(e+"");}   
        }
        %>
        
        
    </body>
</html>
