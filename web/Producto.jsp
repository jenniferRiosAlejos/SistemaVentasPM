<%@page import="Modelo.Producto"%>
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
                <h5 class="card-title mb-0">Producto</h5>
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
                <form action="Controlador?menu=Producto" method="POST" onsubmit="return validateForm()">    
                    <div class="mb-3">
                        <label class="form-label">Código</label>
                        <input type="text" value="${producto.getCod()}" name="txtCod" class="form-control" required="" maxlength="10" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Categoría</label>
                        <select name="txtCat" class="form-select" required>
                        <option value="" selected disabled>Seleccionar</option>
                        <c:forEach var="cate" items="${categorias}">
                            <c:if test="${cate.getEstado() == 'Activo'}">
                                <c:choose>
                                    <c:when test="${cate.getId() == producto.getIdCat()}">
                                        <option value="${producto.getIdCat()}" selected>${cate.getDescrip()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${cate.getId()}">${cate.getDescrip()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Marca</label>
                        <select name="txtMar" class="form-select" required>
                            <option value="" selected disabled>Seleccionar</option>
                            <c:forEach var="mar" items="${marcas}">
                                <c:if test="${mar.getEstado() == 'Activo'}">
                                    <c:choose>
                                        <c:when test="${mar.getId() == producto.getIdMar()}">
                                            <option value="${mar.getId()}" selected>${mar.getDescrip()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${mar.getId()}">${mar.getDescrip()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Producto</label>
                        <input type="text" value="${producto.getDescrip()}" name="txtPro" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Precio Compra</label>
                        <div class="input-group">
                            <span class="input-group-text">s/.</span>
                            <input type="text" value="${producto.getPrecioCom()}" name="txtPrecomp" class="form-control" required>                 
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Margen Ganancia</label>
                        <div class="input-group">
                            <input type="text" value="${producto.getMargen()}" name="txtMargen" class="form-control" placeholder="porcentaje ganancia" requiredpattern="[0-9]{1,}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                            <span class="input-group-text">%</span>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Estado</label>
                        <select name="txtEstado" class="form-select" required>
                            <option value="" selected disabled>Seleccionar</option>
                            <option value="Activo" ${producto.getEstado() == 'Activo' ? 'selected' : ''}>Activo</option>
                            <option value="Inactivo" ${producto.getEstado() == 'Inactivo' ? 'selected' : ''}>Inactivo</option>
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
                        <th>CODIGO</th>
                        <th>CATEGORIA</th>
                        <th>MARCA</th>
                        <th>PRODUCTO</th>
                        <th>PRECIO COMPRA</th>
                        <th>MARGEN GANANCIA</th>
                        <th>PRECIO VENTA</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${productos}">
                        <tr>
                            <td>${pr.getCod()}</td>
                            <td>${pr.getDescripCat()}</td>
                            <td>${pr.getDescripMar()}</td>
                            <td>${pr.getDescrip()}</td>
                            <td>s/. ${pr.getPrecioCom()}</td>
                            <td>${pr.getMargen()}%</td>
                            <td>s/. ${pr.getPrecioVen()}</td>
                            <td>${pr.getStock()}</td>
                            <td>${pr.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}"><img src="img/edit.png" alt="Editar"/> </a>
                                <!-- <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&id=${pr.getId()}"><img src="img/delete.png" alt="Eliminar"/></a> -->
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Script para la validación del formulario -->
        <script>
            function validateForm() {
                // Obtenemos los campos del formulario
                const categoria = document.querySelector('select[name="txtCat"]');
                const marca = document.querySelector('select[name="txtMar"]');
                const producto = document.querySelector('input[name="txtPro"]');
                const precioCompra = document.querySelector('input[name="txtPrecomp"]');
                const margenGanancia = document.querySelector('input[name="txtMargen"]');
                const estado = document.querySelector('select[name="txtEstado"]');

                // Verificamos que los campos no estén vacíos
                if (categoria.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, seleccione una categoría.";
                    return false;
                }
                if (marca.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, seleccione una marca.";
                    return false;
                }
                if (producto.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, ingrese el nombre del producto.";
                    return false;
                }
                if (precioCompra.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, ingrese el precio de compra.";
                    return false;
                }
                if (margenGanancia.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, ingrese el margen de ganancia.";
                    return false;
                }
                if (estado.value === "") {
                    document.getElementById("error-message").innerText = "Por favor, seleccione el estado del producto.";
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
