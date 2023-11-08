<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Abastecimiento</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                .btn-edit {
                    background-color: #ffc107;
                    border: none;
                }
                .btn-delete {
                    background-color: #dc3545;
                    border: none;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <h4 class="text-center mb-2">Registro de Abastecimiento</h4>
                <div class="row">
                    <!-- CABECERA DE LA COMPRA -->
                    <div class="col-sm-5">
                        <div class="card">
                             <form action="Controlador?menu=Abastecimiento" method="POST">
                                <!-- Datos del proveedor -->
                                <h5 class="card-title mb-3">Datos del proveedor</h5>
                                <div class="form-group mb-3 d-flex align-items-center">
                                    <input type="text" name="rucprovee" id="rucprovee" class="form-control" placeholder="Ruc" pattern="\d{11}" title="Debe contener 11 dígitos" maxlength="11" value="${prove.getRuc()}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                                    <input type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info">
                                </div>                           
                                <div class="form-group mb-3">
                                    <input type="text" name="NombreProveedor" class="form-control" placeholder="Nombre del proveedor" value="${prove.getProve()}" >
                                </div>

                                <!-- Datos del producto -->
                                <h5 class="card-title mb-3 mt-4">Datos del Producto</h5>
                                <div class="form-group mb-3 d-flex align-items-center">              
                                    <input type="text" name="CodigoProducto" class="form-control" placeholder="Código" title="Debe contener 10 dígitos numéricos" maxlength="10" value="${prod.getCod()}" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                </div>                           

                                <div class="form-group mb-3">
                                    <label>Nombre del producto</label>
                                    <input type="text" name="NombreProducto" value="${prod.getDescrip()}" class="form-control" placeholder="Nombre del producto">
                                </div>
                                <div class="form-group row mb-2">
                                    <div class="col-sm-3">
                                        <label>Precio</label>
                                        <input type="number" name="precio" value="${prod.getPrecioCom()}" class="form-control" placeholder="s/.0.00" step="0.01" min="0.01" >
                                    </div>
                                    <div class="col-sm-3">
                                        <label>Cantidad</label>                                      
                                        <input type="number" name="cant" value="1" placeholder="Cantidad" class="form-control" min="1" >
                                    </div>
                                    <div class="col-sm-3">
                                        <label>Stock</label>
                                        <input type="text" name="stock" value="${prod.getStock()}" class="form-control" placeholder="Stock" disabled>
                                    </div>
                                    <div class="col-sm-3 mt-4">
                                        <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info" onclick="return validarFormulario('Agregar')">

                                    </div>
                                </div>


                                <h5 class="card-title mb-3 mt-4">Comprobante</h5>
                                <div class="form-group mb-3">
                                    <label>Tipo de comprobante</label>
                                    <select name="tipComp" class="form-control">
                                        <option >Seleccionar</option>
                                        <option value="Boleta">Boleta</option>
                                        <option value="Factura">Factura</option>
                                    </select>
                                </div>
                                <div class="form-group mb-3">
                                    <label>Número de comprobante</label>
                                    <input type="text" name="NumComprobante" class="form-control">
                                </div>
                                <div class="form-group mb-3">
                                    <label>Fecha de compra</label>
                                    <div class="input-group">
                                        <input type="date" name="FechaCom" class="form-control" placeholder="Fecha" aria-label="Fecha" aria-describedby="calendario" >
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="form-group mb-3">
                                            <input type="submit" name="accion" value="Generar Compra" class="btn btn-info">
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
                                <h5 class="card-title mb-3">Detalle de la compra</h5>
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
                                                <th>ACCIONES</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="list" items="${listaAba}">
                                                <tr>
                                                    <td>${list.getItem()}</td>
                                                    <td>${list.getIdProduc()}</td>
                                                    <td>${list.getDescPro()}</td>
                                                    <td>s/. ${list.getPreComp()}</td>
                                                    <td>${list.getCantidad()}</td>
                                                    <td>s/. ${list.getPreTot()}</td>
                                                    <td>
                                                        <div class="d-flex gap-2">
                                                            <button class="btn btn-edit btn-sm" title="Editar">
                                                                <i class="fas fa-edit"></i>
                                                            </button>
                                                            <input type="hidden" name="idpodr" id="ipod" value="${list.getIdProduc()}">
                                                            <button class="btn btn-delete btn-sm" title="Eliminar">
                                                                <i class="fas fa-trash"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="card-footer d-flex">

                                <div class="col-sm-4 ml-auto">
                                    <input type="text" name="txtTotal" value="s/. ${totalpagar}"  class="form-control text-center bold-text" disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
            <script>
               
            </script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        </body>
    </html>
