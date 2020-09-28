<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        
    </head>
    <body>
        <%
        HttpSession sesion =request.getSession();
        if (sesion.getAttribute("logueado")==null || sesion.getAttribute("logueado").equals("0")) {
                response.sendRedirect("login.jsp");
            }
        
        %>
         <div class="container mt-1"> 
             
             <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Empleados</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
          <a> <img src="Iconos/user.png" width="30" height="30" class="mt-1"></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" ><%=session.getAttribute("nombre")%></a>

      <li class="nav-item active">
        <a class="nav-link" href="logout.jsp" tabindex="-1" aria-disabled="true">Log Out</a>
      </li>
    </ul>
        
        <form class="form-inline my-2 my-lg-0" action="Listado.jsp" method="post">
      <input class="form-control mr-sm-2" type="search" name="nombre" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-light my-2 my-sm-0" type="submit" name="buscar">Search</button>
    </form>
        
  </div>
</nav>
             
             <div class="row">
                 <div class="col-sm">
        <table class="table table-striped table-dark"   >
                      <tr >
                <th  colspan="4" class="text-center" ><h3>Usuarios</h3></th>
                <th align="center"><a href="Nuevo.jsp">
                <img src="Iconos/add.png" width="40" height="40">

                    </a></th>
                       </tr>
                <tr>
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Edad</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Accion</th>
                </tr>
                <jsp:include page="Empleados"/>
        </table>
        </div>
        </div>
        </div>
    </body>
</html>
