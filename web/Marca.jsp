<%@page import="Modelo.Marca"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>JSP Page</title>
    <style>
        body {
            background-color: #f9f9f9;
        }
        .card {
            border: none;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .card-header {
            background-color: #007bff;
            color: white;
            text-align: center;
        }
        .form-control {
            border: 1px solid #ced4da;
            border-radius: 5px;
        }
        .btn-info {
            background-color: #17a2b8;
            border: none;
        }
        .btn-info:hover {
            background-color: #11707a;
            border: none;
        }
        .btn-success {
            background-color: #28a745;
            border: none;
        }
        .btn-success:hover {
            background-color: #1a7321;
            border: none;
        }
        .table thead th {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
        .table tbody td {
            border-color: #e9ecef;
        }
        .btn-warning {
            background-color: #ffc107;
            border: none;
        }
        .btn-warning:hover {
            background-color: #e0a800;
            border: none;
        }
    </style>
</head>
<body>
    <div class="d-flex justify-content-between p-4">
        <div class="card col-sm-3">
            <div class="card-header">
                <h5 class="card-title mb-0">Nombre Marca</h5>
            </div>
            <div class="card-body">
                <!-- Agregar un elemento para mostrar el mensaje de validación -->
                <p id="error-message" style="color: red;"></p>
            <!-- Agregar un elemento para mostrar el mensaje de validación -->
                <c:if test="${not empty mensaje}">
                    <div class="alert alert-danger" role="alert">
                        ${mensaje}
                    </div>
                </c:if>

                <c:if test="${not empty mensajeok}">
                    <div class="alert alert-success" role="alert">
                        ${mensajeok}
                    </div>
                </c:if>
                <c:if test="${not empty mensajeUpdate}">
                    <div class="alert alert-warning" role="alert">
                        ${mensajeUpdate}
                    </div>
                </c:if>

                <form action="Controlador?menu=Marca" method="POST" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label class="form-label">Descripción</label>
                        <input type="text" value="${marca.getDescrip()}" name="txtDesc" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Estado</label>
                        <select name="txtEstado" class="form-select" required>
                            <option value="">Seleccionar</option>
                            <option value="Activo" ${marca.getEstado() == 'Activo' ? 'selected' : ''}>Activo</option>
                            <option value="Inactivo" ${marca.getEstado() == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
                        </select>
                    </div>
                    <div class="d-grid gap-2">
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success mt-2">
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead class="table-primary">
                    <tr>                       
                        <th>NOMBRE MARCA</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="marc" items="${marcas}">
                        <tr>                          
                            <td>${marc.getDescrip()}</td>
                            <td>${marc.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Marca&accion=Editar&id=${marc.getId()}"><img src="img/edit.png" alt="Editar"/></a>
                                <!-- <a class="btn btn-danger" href="Controlador?menu=Marca&accion=Eliminar&id=${marc.getId()}"><img src="img/delete.png" alt="Eliminar"/></a> -->
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
        <script>
            // Función para validar el formulario antes del envío
            function validateForm() {
              const descripcion = document.getElementsByName("txtDesc")[0].value;
              const estado = document.getElementsByName("txtEstado")[0].value;

              if (!descripcion || !estado) {
                // Mostrar un mensaje de error en el elemento con el id "error-message"
                const errorMessageElement = document.getElementById("error-message");
                errorMessageElement.innerText = "Por favor, complete todos los campos requeridos.";
                return false; // Evitar el envío del formulario
              }

              // Limpiar el mensaje de error si todos los campos están completos
              document.getElementById("error-message").innerText = "";
              return true; // Permitir el envío del formulario si todos los campos están completos          
            }
          </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>

    </body>
</html>
