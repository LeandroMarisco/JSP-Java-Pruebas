
<%@page import="java.sql.*"%>
<%@page import="Utils.Encriptar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"

    </head>
    <body>
        <div class="container mt-5"> 
            <div class="row">
                <div class="col-sm">
                    <form method="post" action="login.jsp">
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" class="form-control" name="user" placeholder="Pon Usuario">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Pon Password">
                        </div>

                        <button type="submit" class="btn btn-primary" name="login">Login</button>
                    </form>
                    <%

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
                             out.println(" <div class=\"alert alert-danger\" role=\"alert\"> "+e+"</div>");

                            }

                        }


                    %>
                </div>
            </div>
        </div>
    </body>

</html>


