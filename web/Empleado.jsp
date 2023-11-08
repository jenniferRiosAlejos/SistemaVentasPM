<%@page import="Modelo.Empleado"%>
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
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
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
            <h5 class="card-title mb-0">Empleado</h5>
        </div>
        <div class="card-body">
            <!-- Agregar un elemento para mostrar el mensaje de validación -->
            <p id="error-message" style="color: red;"></p>

            <form action="Controlador?menu=Empleado" method="POST" onsubmit="return validateForm()">
                <div class="mb-3">
                    <label class="form-label">DNI</label>
                    <input type="text" id="txtDNI" value="${empleado.getDni()}" name="txtDni" class="form-control" required maxlength="8" pattern="[0-9]{1,}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                    <small class="form-text text-muted">Por favor, ingresar solo números (máximo 8 dígitos).</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Nombres y Apellidos</label>
                    <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control" required>
                    <small class="form-text text-muted">Por favor, ingresar nombres completos.</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Teléfono</label>
                    <input type="text" value="${empleado.getTel()}" name="txtTel" class="form-control" required maxlength="9" pattern="[0-9]{1,}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                    <small class="form-text text-muted">Por favor, ingresar solo números (máximo 9 dígitos).</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Estado</label>
                    <select name="txtestado" class="form-select" required>
                        <option value="">Seleccionar</option>
                        <option value="Activo" ${empleado.getEstado() == 'Activo' ? 'selected' : ''}>Activo</option>
                        <option value="Inactivo" ${empleado.getEstado() == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
                        <option value="Admin" ${empleado.getEstado() == 'Admin' ? 'selected' : ''}>Admin</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Usuario</label>
                    <input type="text" id="txtUsuario" value="${empleado.getUser()}"  name="txtUsuario" class="form-control" required maxlength="15">
                     <button type="button" onclick="autogenerateUser()" class="btn btn-secondary">Autogenerar</button>                 
                </div>
                <div class="mb-3">
                    <label class="form-label">Contraseña</label>
                    <div class="input-group"> 
                        <input type="password" id="txtContrasena" value="${empleado.getContraseña()}"  name="txtContra" class="form-control" required maxlength="8">              
                         <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="button" id="togglePassword" class="eye-button">👁</button>
                        </div>
                    </div>
                    <small class="form-text text-muted">Por favor, ingresar mínimo 8 dígitos.</small>
                </div>
                         
                <div class="d-grid">
                    <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success mt-2">
                </div>                       
            </form>
        </div>
                         
    </div>
    <div class="col-sm-8">
        <table class="table table-hover">
            <thead class="table-primary">
                <tr>
                    <th>DNI</th>
                    <th>NOMBRES</th>
                    <th>TELÉFONO</th>
                    <th>ESTADO</th>
                    <th>USUARIO</th>                  
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="em" items="${empleados}">
                    <tr>                     
                        <td>${em.getDni()}</td>
                        <td>${em.getNom()}</td>
                        <td>${em.getTel()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUser()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}"><img src="img/edit.png" alt="Editar"/></a>
                            <!-- <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}"><img src="img/delete.png" alt="Eliminar"/></a> -->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
        <script>
        function allowOnlyNumbers(event) {
            // Get the ASCII value of the pressed key
            var charCode = event.which ? event.which : event.keyCode;

            // Allow only numbers (ASCII 48 to 57) and backspace (ASCII 8)
            if (charCode < 48 || charCode > 57) {
                // Allow backspace
                if (charCode !== 8) {
                    event.preventDefault();
                    return false;
                }
            }

            return true;
        }
            // Función para validar el formulario antes del envío
            function validateForm() {
              const dni = document.getElementsByName("txtDni")[0].value;
              const nombres = document.getElementsByName("txtNombres")[0].value;
              const telefono = document.getElementsByName("txtTel")[0].value;
              const estado = document.getElementsByName("txtestado")[0].value;
              const usuario = document.getElementsByName("txtUsuario")[0].value;
              const contrasena = document.getElementsByName("txtContra")[0].value;

              if (!dni || !nombres || !telefono || !estado || !usuario || !contrasena) {
                // Mostrar un mensaje de error en un elemento con el id "error-message"
                const errorMessageElement = document.getElementById("error-message");
                errorMessageElement.innerText = "Por favor, complete todos los campos requeridos.";
                errorMessageElement.style.color = "red";
                return false; // Evitar el envío del formulario
              }
              // Limpiar el mensaje de error si todos los campos están completos
              document.getElementById("error-message").innerText = "";
              return true; // Permitir el envío del formulario si todos los campos están completos
  }
            // ... tus otras funciones JavaScript ...

        function autogenerateUser() {
            const dniField = document.getElementById('txtDNI');
            const userField = document.getElementById('txtUsuario');

            if(dniField.value.length === 8) {
                userField.value = 'E' + dniField.value.slice(1);
            } else {
                alert('Por favor, ingrese un DNI válido con 8 dígitos.');
            }
        }
        
        document.getElementById('togglePassword').addEventListener('click', function () {
        var passwordField = document.getElementById('txtContrasena');
        var passwordFieldType = passwordField.type;
        if (passwordFieldType == 'password') {
            passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        });
                  
        </script>         
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>

    </body>
</html>

