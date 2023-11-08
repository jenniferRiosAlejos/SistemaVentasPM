<%@page import="Modelo.Proveedor"%>
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
            <h5 class="card-title mb-0">Proveedor</h5>
        </div>
        <div class="card-body">
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
            <form action="Controlador?menu=Proveedor" accept-charset="UTF-8" method="POST" onsubmit="return validateForm()">                
                <div class="mb-3">
                    <label class="form-label">RUC</label>
                    <input type="text" value="${proveedor.getRuc()}" name="txtRuc" class="form-control" required="" maxlength="11" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                <small class="form-text text-muted">Por favor, ingresar solo números (máximo 11 dígitos).</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Proveedor</label>
                    <input type="text" value="${proveedor.getProve()}" name="txtProve" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Representante</label>
                    <input type="text" value="${proveedor.getRepre()}" name="txtRepre" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Tipo de Proveedor</label>
                    <input type="text" value="${proveedor.getTipProve()}" name="txtTipProve" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Teléfono</label>
                    <input type="text" value="${proveedor.getTel()}" name="txtTel" class="form-control" required maxlength="9" pattern="[0-9]{1,}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                    <small class="form-text text-muted">Por favor, ingresar solo números (máximo 9 dígitos).</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Dirección</label>
                    <input type="text" value="${proveedor.getDirec()}" name="txtDirec" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Estado</label>
                    <select name="txtEstado" class="form-select" required>
                        <option value="" selected disabled>Seleccionar</option>
                        <option value="Activo" ${proveedor.getEstado() == 'Activo' ? 'selected' : ''}>Activo</option>
                        <option value="Inactivo" ${proveedor.getEstado() == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
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
                    <th>RUC</th>
                    <th>PROVEEDOR</th>                 
                    <th>REPRESENTANTE</th>
                    <th>TIPO DE PROVEEDOR</th>
                    <th>TELEFONO</th>
                    <th>DIRECCION</th>
                    <th>ESTADO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pro" items="${proveedores}">
                    <tr>
                        <td>${pro.getRuc()}</td>
                        <td>${pro.getProve()}</td>                       
                        <td>${pro.getRepre()}</td>
                        <td>${pro.getTipProve()}</td>
                        <td>${pro.getTel()}</td>
                        <td>${pro.getDirec()}</td>
                        <td>${pro.getEstado()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Proveedor&accion=Editar&id=${pro.getIdprove()}"><img src="img/edit.png" alt="Editar"/> </a>
                            <!-- <a class="btn btn-danger" href="Controlador?menu=Proveedor&accion=Eliminar&id=${pro.getIdprove()}"><img src="img/delete.png" alt="Eliminar"/></a> -->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

        <script>
            function validateForm() {
                const proveedor = document.getElementsByName("txtProve")[0];
                const ruc = document.getElementsByName("txtRuc")[0];
                const representante = document.getElementsByName("txtRepre")[0];
                const tipoProveedor = document.getElementsByName("txtTipProve")[0];
                const telefono = document.getElementsByName("txtTel")[0];
                const direccion = document.getElementsByName("txtDirec")[0];
                const estado = document.getElementsByName("txtEstado")[0];

                // Validación de campos requeridos
                if (proveedor.value === "") {
                    alert("Por favor, ingrese el nombre del proveedor.");
                    return false;
                }
                if (ruc.value.length !== 11) {
                    alert("El RUC debe tener exactamente 11 dígitos.");
                    return false;
                }
                if (representante.value === "") {
                    alert("Por favor, ingrese el representante del proveedor.");
                    return false;
                }
                if (tipoProveedor.value === "") {
                    alert("Por favor, ingrese el tipo de proveedor.");
                    return false;
                }
                if (telefono.value === "") {
                    alert("Por favor, ingrese el teléfono del proveedor.");
                    return false;
                }
                if (direccion.value === "") {
                    alert("Por favor, ingrese la dirección del proveedor.");
                    return false;
                }
                if (estado.value === "") {
                    alert("Por favor, seleccione el estado del proveedor.");
                    return false;
                }

                // Si todos los campos están completos, permitimos enviar el formulario
                return true;
            }
        </script>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>

    </body>
</html>
