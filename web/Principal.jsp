
<%@page import="Modelo.Empleado"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema PeruMarket</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
            <div class="container-fluid">

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a >
                            <img src="img/LOGO.png" alt="" style="width: 20%;"/></a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">                                           
                        <c:if var="est1" value="${requestScope.est1}" items="${!Admin}}">
                        <li class="nav-item ">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                        </li>
                        </c:if>
                        
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Categoria&accion=Listar" target="myFrame">Categoria</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Marca&accion=Listar" target="myFrame">Marca</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Proveedor&accion=Listar" target="myFrame">Proveedor</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Abastecimiento&accion=default" target="myFrame">Abastecimiento</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item active">
                            <a style="margin-left: 10px; border: none" class="btn btn-secondary" href="Controlador?menu=Venta&accion=default" target="myFrame">Nueva Venta</a>
                        </li>

                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${usuario.getNom()}
                        </button>
                       
                        
                        <ul class="dropdown-menu dropdown-menu-end text-center">
                            <li><a class="dropdown-item" href="#">
                                    <img src="img/user.png" alt="60" width="60"/>
                                </a></li>
                            <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                            <li><a class="dropdown-item" href="#">${usuario.getDni()}</a></li>
                            <div class="dropdown-divider"></div>
                            <form action="Validar" method="POST">
                                <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                            </form>
                        </ul>
                    </div>
                </div>
            </div>

        </nav>
        <div class="m-4 border border-dark" style="height: 900px;">
            
            <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
        </div>                                           
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    </body>
</html>
