<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Ventas</title>
        <!-- Agrega esta línea en el encabezado de tu página -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        
        <style>
            @media print{
                input.btn, .parte01, .parte02,.parte03, .parte04, .parte05, .parte06, .parte07, .parte08 {
                    display: none
                }
            }
        </style>
        <script src="js/funciones.js" type="text/javascript"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
       <style>.bold-text {
                font-weight: bold;</style>
        <style>
            body {
                background-color: #f8f9fa;
                padding-top: 20px;
            }
            .container {
                max-width: 1200px;
                margin: 0 auto;
            }
            .card {
                border: none;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }
            .form-group label {
                font-weight: bold;
            }
            .btn-outline-info {
                border-color: #17a2b8;
                color: #17a2b8;
            }
            .table thead th {
                background-color: #17a2b8;
                color: white;
            }
            .card-footer {
                background-color: #f8f9fa;
            }
            .table-container {
                max-height: 400px;
                overflow-y: auto;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h4 class="text-center mb-2">Registro de Venta</h4>
            <div class="row">
                <!-- CABECERA DE LA VENTA -->
                <div class="col-sm-5">
                    <div class="card">
                        <form action="Controlador?menu=Venta" method="POST">
                            <!-- Datos del Cliente -->
                            <h5 class="card-title mb-3">Datos del Cliente</h5>
                            <div class="form-group mb-3 d-flex align-items-center">
                                <input type="text" name="dnicli" class="form-control" placeholder="DNI" value="${cli.getDni()}">


                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>                           
                            <div class="form-group mb-3">
                                <input type="text" name="NombreCliente" class="form-control" placeholder="Nombre del cliente" value="${cli.getNom()}" >
                            </div>

                            <!-- Datos del producto -->
                            <h5 class="card-title mb-3 mt-4 parte01">Datos del Producto</h5>
                            <div class="form-group mb-3 parte02">

                                <input type="text" name="CodigoProducto2" class="form-control parte03"value="${produ.getId()}">
                                <input type="submit" name="accion" value="Buscar Producto" class="btn btn-outline-info">
                            </div>                           

                            <div class="form-group mb-3 parte04">
                                <label>Nombre del producto</label>
                                <input type="text" name="Nombre Producto" value="${produ.getDescrip()}" class="form-control" placeholder="Nombre del producto">
                            </div>
                            <div class="form-group row mb-3 parte05">
                                <div class="col-sm-3 parte06">
                                    <label>Precio</label>
                                    <input type="text" name="precio2" value="${produ.getPrecioVen()}" class="form-control" placeholder="s/.0.00" >
                                </div> 
                                <div class="col-sm-3 parte07">
                                    <label>Cantidad</label>
                                    <input type="number" name="cant2" value="1" placeholder="Cantidad" class="form-control" >
                                </div> 
                                <div class="col-sm-3 parte08">
                                    <label>Stock</label>
                                    <input type="text" name="stock2" value="${produ.getStock()}" class="form-control" placeholder="Stock" disabled>
                                </div> 
                                <div class="col-sm-3 mt-4">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                                </div>
                            </div>

                            <h5 class="card-title mb-3 mt-4">Comprobante</h5>
                            <div class="form-group mb-3">
                                <label>Tipo de comprobante</label>
                                <select name="tipComp2" class="form-control">
                                    <option >Seleccionar</option>
                                    <option value="Boleta">Boleta</option>
                                    <option value="Factura">Factura</option>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <label>Número de comprobante</label>
                                <input type="text" value="${nserie}" name="NumComprobante2" class="form-control" disabled>
                            </div>
                            <div class="form-group mb-3">
                                <label>Fecha de compra</label>
                                <div class="input-group">
                                    <input type="date" name="FechaVen" class="form-control" placeholder="Fecha" aria-label="Fecha" aria-describedby="calendario" disabled>

                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group mb-2">
                                        <input type="submit" name="accion" onclick="print()" value="Generar Venta" class="btn btn-info">
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group mb-2">
                                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                                    </div>
                                </div>
                            </div>

                        </form>

                    </div>
                </div>

                <!-- DETALLE DE LA COMPRA -->
                <div class="col-sm-7">
                    <div class="card" style="width: 140%;">
                        <div class="card-body" >

                            <h5 class="card-title mb-3">Detalle de la venta</h5>
                            <div class="table-container">
                                <table class="table table-hover w-100">
                                    <thead>
                                        <tr>
                                            <th>NRO</th>
                                            <th>CODIGO</th>
                                            <th>PRODUCTO</th>
                                            <th>PRECIO</th>
                                            <th>CANTIDAD</th>
                                            <th>SUBTOTAL</th>
                                            <!--<th>ACCIONES</th>-->
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="list" items="${listaVen}">
                                            <tr>
                                                <td >${list.getItem()}</td>
                                                <td >${list.getIdProdu()}</td>
                                                <td >${list.getDescProd()}</td>
                                                <td >s/. ${list.getPrecioUnidad()}</td>
                                                <td>${list.getCant()}</td>
                                                <td>s/. ${list.getSubtotal()}</td>
                                                <!-- <td>
                                                    <div style="display: flex; gap: 5px;">
                                                         <a href="#" class="btn btn-warning btn-sm"><img src="img/edit.png" alt="" style="width: 90%;"/></a>
                                                        <input type="hidden" name="idpodr" id="ipod" value="${list.getIdProdu()}">
                                                        <a href="#" id="btnDelete"><img src="img/delete.png" alt="" style="width: 90%;"/></a>
                                                    </div>
                                                </td>-->


                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer d-flex">

                            <div class="col-sm-4 ml-auto">
                                <input type="text" name="txtTotal2" value="s/. ${totalpagar2}"class="form-control text-center bold-text" disabled>
                                <input type="hidden" name="idEmpl" value=${usuario.getId()}>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<script>
    // Obtener la fecha actual
    var today = new Date();
    var day = String(today.getDate()).padStart(2, '0');
    var month = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0!
    var year = today.getFullYear();

    // Formato de fecha yyyy-mm-dd
    var fechaActual = year + '-' + month + '-' + day;

    // Establecer el valor del campo de fecha
    document.getElementsByName('FechaVen')[0].value = fechaActual;
</script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>
</html>
