/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Abastecimiento;
import Modelo.AbastecimientoDAO;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Marca;
import Modelo.MarcaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Ventas;
import Modelo.VentasDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author enriq
 */
public class Controlador extends HttpServlet {

    int ide;
    int idc;
    int idm;
    int idp;
    int idprov;
    int idCli;
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Categoria cat = new Categoria();
    CategoriaDAO cdao = new CategoriaDAO();
    Marca mar = new Marca();
    MarcaDAO mdao = new MarcaDAO();
    Producto pro = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Proveedor prov = new Proveedor();
    ProveedorDAO provdao = new ProveedorDAO();
    Cliente cli = new Cliente();
    ClienteDAO cliDAO = new ClienteDAO();
    GenerarSerie gs = new GenerarSerie();   
    AbastecimientoDAO aDAO = new AbastecimientoDAO();
    Abastecimiento a = new Abastecimiento();
    VentasDAO vDAO = new VentasDAO();
    Ventas ven = new Ventas();
    String numeroserie;
    List<Abastecimiento> listaAba = new ArrayList<>();
    List<Ventas> listaVen = new ArrayList<>();
    int item;
    int item2;
    int cod;
    int cod2;
    int idprove;
    int idprodu;
    String produ;
    String produ2;
    double precio;
    double precio2;
    int cant;
    int cant2;
    double subtotal;
    double subtotal2;
    double totalPagar;
    double totalPagar2;
    int idcli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu != null && menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Categoria")) {

            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("categorias", lista);
                    break;
                case "Agregar":
                    String descr = request.getParameter("txtDesc");
                    String est = request.getParameter("txtEstado");
                    cat.setDescrip(descr);
                    cat.setEstado(est);
                    cdao.agregar(cat);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Categoria c = cdao.listarId(idc);
                    request.setAttribute("categoria", c);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String descr1 = request.getParameter("txtDesc");
                    String est1 = request.getParameter("txtEstado");
                    cat.setDescrip(descr1);
                    cat.setEstado(est1);
                    cat.setId(idc);
                    cdao.actualizar(cat);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Categoria.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Marca")) {
            switch (accion) {
                case "Listar":
                    List lista = mdao.listar();
                    request.setAttribute("marcas", lista);
                    break;
                case "Agregar":
                    String descr = request.getParameter("txtDesc");
                    String est = request.getParameter("txtEstado");                                    
                     if (mdao.existeMarca(descr)) {
                        request.setAttribute("mensaje", "La marca ya existe");
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    } else {
                        mar.setDescrip(descr);
                        mar.setEstado(est);
                        mdao.agregar(mar);
                        request.setAttribute("mensajeok", "Marca registrada exitosamente");
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    }                    
                    break;
                case "Editar":
                    idm = Integer.parseInt(request.getParameter("id"));
                    Marca m = mdao.listarId(idm);
                    request.setAttribute("marca", m);
                    request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String descr1 = request.getParameter("txtDesc");
                    String est1 = request.getParameter("txtEstado");
                    mar.setDescrip(descr1);
                    mar.setEstado(est1);
                    mar.setId(idm);
                    mdao.actualizar(mar);
                    request.setAttribute("mensajeUpdate", "Marca actualizado con exito");
                    request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idm = Integer.parseInt(request.getParameter("id"));
                    mdao.delete(idm);
                    request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Marca.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    List listaCat = cdao.listar();
                    request.setAttribute("categorias", listaCat);
                    List listaMar = mdao.listar();
                    request.setAttribute("marcas", listaMar);
                    break;
                case "Agregar":
                    int catego = Integer.parseInt(request.getParameter("txtCat"));
                    int Marc = Integer.parseInt(request.getParameter("txtMar"));
                    int Marge = Integer.parseInt(request.getParameter("txtMargen"));
                    String Prod = request.getParameter("txtPro");
                    int CodP=  Integer.parseInt(request.getParameter("txtCod"));
                    double Preco = 0.0; // Valor predeterminado
                    String txtPreventa = request.getParameter("txtPrecomp");

                    if (txtPreventa != null && !txtPreventa.isEmpty()) {
                        Preco = Double.parseDouble(txtPreventa);
                    }

                    String Est = request.getParameter("txtEstado");
                    pro.setIdCat(catego);
                    pro.setIdMar(Marc);
                    pro.setCod(CodP);
                    pro.setDescrip(Prod);
                    pro.setPrecioCom(Preco);
                    pro.setMargen(Marge);
                    pro.setPrecioVen((Preco * Marge) / 100 + Preco);
                    pro.setEstado(Est);

                    if(pdao.ExisteProCodigo(CodP)) {
                        request.setAttribute("mensaje", "El producto con código " + CodP + " ya está registrado");
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    } else {
                        pdao.agregar(pro);
                        request.setAttribute("mensajeok", "Producto registrado con éxito");
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    }

                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int catego1 = Integer.parseInt(request.getParameter("txtCat"));
                    int Marc1 = Integer.parseInt(request.getParameter("txtMar"));
                    int Marge1 = Integer.parseInt(request.getParameter("txtMargen"));
                    String Prod1 = request.getParameter("txtPro");
                    int CodP1= Integer.parseInt(request.getParameter("txtCod"));

                    double Preco1 = Double.parseDouble(request.getParameter("txtPrecomp"));
                    String Est1 = request.getParameter("txtEstado");                
                    pro.setIdCat(catego1);
                    pro.setIdMar(Marc1);
                    pro.setCod(CodP1);
                    pro.setDescrip(Prod1);
                    pro.setPrecioCom(Preco1);
                    pro.setPrecioVen((Preco1 * Marge1) / 100 + Preco1);
                    pro.setEstado(Est1);
                    pro.setMargen(Marge1);
                    pro.setId(idp);
                    pdao.actualizar(pro);
                    request.setAttribute("mensajeUpdate", "Producto actualizado con exito");
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Proveedor")) {

            switch (accion) {
                case "Listar":
                    List lista1 = provdao.listar();
                    request.setAttribute("proveedores", lista1);
                    break;
                case "Agregar":
                    String prove = request.getParameter("txtProve");
                    String ruc = request.getParameter("txtRuc");
                    String repre = request.getParameter("txtRepre");
                    String tipProv = request.getParameter("txtTipProve");
                    String tel = request.getParameter("txtTel");
                    String direc = request.getParameter("txtDirec");
                    String est = request.getParameter("txtEstado");                 
                    if (provdao.existeRUC(ruc)) {
                        // Puedes configurar un mensaje de error y mandarlo de vuelta al formulario
                        request.setAttribute("mensaje", "El RUC ya está registrado");
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    } else {
                        prov.setProve(prove);
                        prov.setRuc(ruc);
                        prov.setRepre(repre);
                        prov.setTipProve(tipProv);
                        prov.setTel(tel);
                        prov.setDirec(direc);
                        prov.setEstado(est);
                        provdao.agregar(prov);
                        request.setAttribute("mensajeok", "Proveedor registrada exitosamente");
                        request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    }
                    break;
                case "Editar":
                    idprov = Integer.parseInt(request.getParameter("id"));
                    Proveedor proved = provdao.listarId(idprov);
                    request.setAttribute("proveedor", proved);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String prove1 = request.getParameter("txtProve");
                    String ruc1 = request.getParameter("txtRuc");
                    String repre1 = request.getParameter("txtRepre");
                    String tipProv1 = request.getParameter("txtTipProve");
                    String tel1 = request.getParameter("txtTel");
                    String direc1 = request.getParameter("txtDirec");
                    String est1 = request.getParameter("txtEstado");
                    prov.setProve(prove1);
                    prov.setRuc(ruc1);
                    prov.setRepre(repre1);
                    prov.setTipProve(tipProv1);
                    prov.setTel(tel1);
                    prov.setDirec(direc1);
                    prov.setEstado(est1);
                    prov.setIdprove(idprov);
                    provdao.actualizar(prov);
                    request.setAttribute("mensajeUpdate", "Proveedor actualizado con exito");
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idprov = Integer.parseInt(request.getParameter("id"));
                    provdao.delete(idprov);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Abastecimiento")) {
            Proveedor prove = new Proveedor();
            switch (accion) {

                case "BuscarProveedor":
                    String ruc = request.getParameter("rucprovee");
                    prove.setRuc(ruc);
                    prove = provdao.buscar(ruc);
                    request.getSession().setAttribute("prove", prove);
                    request.setAttribute("listaAba", listaAba);
                    break;
                case "BuscarProducto": 
                    int codBus = Integer.parseInt(request.getParameter("CodigoProducto"));
                    pro = pdao.listarCod(codBus);
                    request.setAttribute("prod", pro);
                    request.setAttribute("listaAba", listaAba);                     
                    break;
                // Buscar producto por nombre
                /*case "BuscarProductoNombre":
                    String nomBus = request.getParameter("NombreProducto");
                    prod.setDescrip(nomBus);
                    prod = pdao.listarNom(nomBus);
                    request.setAttribute("prod", prod);
                    request.setAttribute("listaAba", listaAba);
                    break;*/  
                case "Agregar":
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pro.getCod();
                    produ = request.getParameter("NombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;

                    a = new Abastecimiento();
                    a.setItem(item);
                    a.setIdProduc(cod);
                    a.setDescPro(produ);
                    a.setPreComp(precio);
                    a.setCantidad(cant);
                    a.setPreTot(subtotal);
                    listaAba.add(a);
                    for (int i = 0; i < listaAba.size(); i++) {
                        totalPagar = totalPagar + listaAba.get(i).getPreTot();
                    }

                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("listaAba", listaAba);

                    break;
                case "Generar Compra":
                    prove = (Proveedor) request.getSession().getAttribute("prove");
                    idprove = prove.getIdprove();

                    Abastecimiento abs = new Abastecimiento();
                    abs.setTipComprob(request.getParameter("tipComp"));
                    abs.setNumFac(request.getParameter("NumComprobante"));
                    abs.setFechComp(request.getParameter("FechaCom"));

                    String tip = abs.getTipComprob();
                    String numfac = abs.getNumFac();
                    String fech = abs.getFechComp();
                    //Guardar  compra
                    a.setIdProve(idprove);
                    a.setTipComprob(tip);
                    a.setNumFac(numfac);
                    a.setFechComp(fech);
                    a.setTotalpago(totalPagar);
                    aDAO.guardarCompra(a);
                    //Guardar  detalle

                    String idCoStr = aDAO.IdCo(); // Obtener el valor del método aDAO.IdCo()
                    int idCo = 0; // Valor predeterminado o cualquier otro valor que consideres apropiado

                    if (idCoStr != null && !idCoStr.isEmpty()) {
                        try {
                            idCo = Integer.parseInt(idCoStr); // Convertir a entero solo si no es nulo o vacío
                        } catch (NumberFormatException e) {
                            // Manejar el caso en el que no se pueda convertir a entero
                            // Puedes imprimir un mensaje de error o realizar alguna acción adecuada
                        }
                    }
                    for (int i = 0; i < listaAba.size(); i++) {
                        a = new Abastecimiento();
                        a.setIdComp(idCo);
                        a.setIdProduc(listaAba.get(i).getIdProduc());
                        a.setCantidad(listaAba.get(i).getCantidad());
                        a.setPreComp(listaAba.get(i).getPreComp());
                        a.setPreTot(listaAba.get(i).getPreTot());
                        aDAO.guardarDetalleCompra(a);

                        // Actualizar la cantidad en la tabla "productos"
                        int cantidadComprada = listaAba.get(i).getCantidad();
                        int idProducto = listaAba.get(i).getIdProduc();
                        // Obtener la cantidad existente del producto antes de la compra
                        int cantidadExistente = aDAO.getCantidadExistente(idProducto);
                        // Calcular la nueva cantidad luego de la compra
                        int nuevaCantidad = cantidadExistente + cantidadComprada;
                        // Actualizar la cantidad en la tabla "productos"
                        aDAO.actualizarCantidad(idProducto, nuevaCantidad);

                        // Obtén el nuevo precio de compra del detalle de compra actual
                        int margenganancia = aDAO.getMargenGanancia(idProducto);
                        double nuevoPrecioCompra = listaAba.get(i).getPreComp();
                        double nuevoPrecioVenta = (nuevoPrecioCompra * margenganancia) / 100 + nuevoPrecioCompra;

                        // Actualiza el precio de compra del producto en la tabla "productos"
                        aDAO.actualizarPrecioCompraProducto(listaAba.get(i).getIdProduc(), nuevoPrecioCompra, nuevoPrecioVenta);

                    }

                    // Limpiar la lista de detalles de compra y otros atributos relacionados
                    // Limpiar los campos y redireccionar con el mensaje de éxito
                    totalPagar = 0.0;
                    listaAba.clear();
                    request.getSession().removeAttribute("prove"); // Esto limpiará los datos del proveedor de la sesión

                    break;

                case "Delete":
                    Abastecimiento av = new Abastecimiento();

                    av.setIdProduc(Integer.parseInt(request.getParameter("idpodr")));

                    //int idproduct =Integer.parseInt(request.getParameter("idpodr"));
                    for (int i = 0; i < listaAba.size(); i++) {
                        if (listaAba.get(i).getIdProduc() == av.getIdProduc()) {
                            listaAba.remove(i);
                        }
                    }
                    break;
                case "Cancelar":
                    totalPagar = 0.0;
                    listaAba.clear();
                    request.getSession().removeAttribute("prove"); // Esto limpiará los datos del proveedor de la sesión
                    break;
                default:

            }

            request.getRequestDispatcher("Abastecimiento.jsp").forward(request, response);
        }

        if (menu != null && menu.equals("Clientes")) {

            switch (accion) {
                case "Listar":
                    List lista = cliDAO.listar();
                    request.getSession().setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtestado");
                    // Obtener el valor del IdCliente desde el formulario
                    int idCliente = cliDAO.obtenerIdCliente();

                    // Verificar si el IdCliente es válido (por ejemplo, asegúrate de que no sea negativo)
                    // Si no es válido, puedes asignarle un valor predeterminado o generar uno según tus necesidades.
                    if (idCliente <= 0) {
                        idCliente = idCliente + 1; // Aquí, genera un IdCliente según tus requisitos
                    }
                    cli.setId(idCliente);
                    cli.setDni(dni);
                    cli.setNom(nom);
                    cli.setDir(dir);
                    cli.setEstado(est);
                    cliDAO.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idCli = Integer.parseInt(request.getParameter("id"));
                    Cliente clie = cliDAO.listarId(idCli);
                    request.setAttribute("cliente", clie);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String dir1 = request.getParameter("txtDir");
                    String est1 = request.getParameter("txtestado");
                    cli.setDni(dni1);
                    cli.setNom(nom1);
                    cli.setDir(dir1);
                    cli.setEstado(est1);
                    cli.setId(idCli);
                    cliDAO.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                /*case "Eliminar":
                    idCli = Integer.parseInt(request.getParameter("id"));
                    cliDAO.delete(idCli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;*/
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu != null && menu.equals("Empleado")) {
                  
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtestado");
                    String user = request.getParameter("txtUsuario");
                    String contra = request.getParameter("txtContra");
                           // Verificar si el DNI ya está registrado
                    if (edao.existeDNI(dni)) {
                        JOptionPane.showMessageDialog(null, "El DNI ya está registrado. Ingrese un DNI diferente.");
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response); 
                        return; // Detener la ejecución para evitar agregar el empleado duplicado
                    } 
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    em.setContraseña(contra);
                    edao.agregar(em);
                    request.setAttribute("successModal", "Empleado registrado correctamente");           
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);                 
                    break;
                    
                    
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);                
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtestado");
                    String user1 = request.getParameter("txtUsuario");
                    String contra1 = request.getParameter("txtContra");
                    request.setAttribute("est1", est1);  
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setContraseña(contra1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
                       
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu != null && menu.equals("Venta")) {
            Cliente clien = new Cliente();
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("dnicli");
                    cli.setDni(dni);
                    cli = cliDAO.buscar(dni);
                    request.getSession().setAttribute("cli", cli);
                    
                     String numeroserie = vDAO.GenerarSerie2();
                    if (numeroserie == null || numeroserie.isEmpty()) {
                        numeroserie = "00000001";
                        request.getSession().setAttribute("nserie", numeroserie);
                    } else {
                        try {
                            int incrementar = Integer.parseInt(numeroserie);
                            
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.getSession().setAttribute("nserie", numeroserie);
                        } catch (NumberFormatException e) {
                            // Manejar el caso en el que no se pueda convertir a entero
                            // Puedes imprimir un mensaje de error o realizar alguna acción adecuada
                            e.printStackTrace(); // Imprimir la traza de la excepción para depurar
                        }
                    }

                    break;
                case "Buscar Producto":
                    int codBus = Integer.parseInt("CodigoProducto2");
                    pro.setCod(codBus);
                    pro = pdao.listarCod(codBus);
                    request.setAttribute("prod", pro);
                    request.setAttribute("listaVen", listaVen);

                    break;
                case "Agregar":
                    totalPagar2 = 0.0;
                    item2 = item2 + 1;
                    cod2 = pro.getId();
                    produ2 = request.getParameter("Nombre Producto");
                    String precio2Param = request.getParameter("precio2");
                    double precio2 = 0.0; // Valor predeterminado si el parámetro es null o no válido
                    if (precio2Param != null && !precio2Param.isEmpty()) {
                        precio2 = Double.parseDouble(precio2Param);
                    }
                    cant2 = Integer.parseInt(request.getParameter("cant2"));
                    subtotal2 = precio2 * cant2;

                    ven = new Ventas();
                    ven.setItem(item2);
                    ven.setIdProdu(cod2);
                    ven.setDescProd(produ2);
                    ven.setPrecioUnidad(precio2);
                    ven.setCant(cant2);
                    ven.setSubtotal(subtotal2);
                    listaVen.add(ven);
                    for (int i = 0; i < listaVen.size(); i++) {
                        totalPagar2 = totalPagar2 + listaVen.get(i).getSubtotal();
                    }

                    request.setAttribute("totalpagar2", totalPagar2);
                    request.setAttribute("listaVen", listaVen);

                    break;
                case "Generar Venta":
                    clien = (Cliente) request.getSession().getAttribute("cli");
                    idcli = clien.getId();
                    em = (Empleado) request.getSession().getAttribute("usuario");
                    ide = em.getId();

                    Ventas ven = new Ventas();
                    ven.setTipComp(request.getParameter("tipComp2"));
                    ven.setNumComp(request.getParameter("NumComprobante2"));
                    ven.setFecha(request.getParameter("FechaVen"));

                    String tip = ven.getTipComp();
                    String numfac = ven.getNumComp();
                    String fech = ven.getFecha();
                    //Guardar  compra
                    ven.setIdCliente(idcli);
                    ven.setIdEmpleado(ide);
                    ven.setFecha(fech);
                    ven.setTotal(totalPagar2);
                    ven.setTipComp(tip);
                    ven.setNumComp(numfac);
                    vDAO.guardarVenta(ven);
                    //Guardar  detalle

                    String idVeStr = vDAO.IdVen(); // Obtener el valor del método vDAO.IdVen()
                    int idVen = 0; // Valor predeterminado o cualquier otro valor que consideres apropiado

                    if (idVeStr != null && !idVeStr.isEmpty()) {
                        try {
                            idVen = Integer.parseInt(idVeStr); // Convertir a entero solo si no es nulo o vacío
                        } catch (NumberFormatException e) {
                            // Manejar el caso en el que no se pueda convertir a entero
                            // Puedes imprimir un mensaje de error o realizar alguna acción adecuada
                            e.printStackTrace(); // Imprimir la traza de la excepción para depurar
                        }
                    }

                    for (int i = 0; i < listaVen.size(); i++) {
                        ven = new Ventas();
                        ven.setIdVentas(idVen);
                        ven.setIdProdu(listaVen.get(i).getIdProdu());
                        ven.setCant(listaVen.get(i).getCant());
                        ven.setPrecioUnidad(listaVen.get(i).getPrecioUnidad());
                        ven.setSubtotal(listaVen.get(i).getSubtotal());
                        vDAO.guardarDetalleVenta(ven);

                        // Actualizar la cantidad en la tabla "productos"
                        int cantidadVendida = listaVen.get(i).getCant();
                        int idProducto = listaVen.get(i).getIdProdu();
                        // Obtener la cantidad existente del producto antes de la compra
                        int cantidadExistente = vDAO.getCantidadExistente(idProducto);
                        // Calcular la nueva cantidad luego de la compra
                        int nuevaCantidad = cantidadExistente - cantidadVendida;
                        // Actualizar la cantidad en la tabla "productos"
                        vDAO.actualizarCantidad(idProducto, nuevaCantidad);

                    }

                    // Limpiar la lista de detalles de compra y otros atributos relacionados
                    // Limpiar los campos y redireccionar con el mensaje de éxito
                    totalPagar = 0.0;
                    listaAba.clear();
                    request.getSession().removeAttribute("cli"); // Esto limpiará los datos del proveedor de la sesión

                    break;
                    case "Cancelar":
                    totalPagar2 = 0.0;
                    listaVen.clear();
                    request.getSession().removeAttribute("cli"); // Esto limpiará los datos del proveedor de la sesión
                    break;

                
                default:

                   
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
