/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author enriq
 */
public class Ventas {
    int item;
    int idVentas;
    int idCliente;
    String NomCli;
    int idEmpleado;
    String NomEmp;
    String fecha;
    double total;
    String tipComp;
    String numComp;
    
    
    int idDetalleVenta;
    int idProdu;
    String descProd;
    int cant;
    double precioUnidad;
    double subtotal;

    public Ventas() {
    }

    public Ventas(int item, int idVentas, int idCliente, String NomCli, int idEmpleado, String NomEmp, String fecha, double total, String tipComp, String numComp, int idDetalleVenta, int idProdu, String descProd, int cant, double precioUnidad, double subtotal) {
       
        this.item = item;
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.NomCli = NomCli;
        this.idEmpleado = idEmpleado;
        this.NomEmp = NomEmp;
        this.fecha = fecha;
        this.total = total;
        this.tipComp = tipComp;
        this.numComp = numComp;
        this.idDetalleVenta = idDetalleVenta;
        this.idProdu = idProdu;
        this.descProd = descProd;
        this.cant = cant;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    
    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCli() {
        return NomCli;
    }

    public void setNomCli(String NomCli) {
        this.NomCli = NomCli;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNomEmp() {
        return NomEmp;
    }

    public void setNomEmp(String NomEmp) {
        this.NomEmp = NomEmp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipComp() {
        return tipComp;
    }

    public void setTipComp(String tipComp) {
        this.tipComp = tipComp;
    }

    public String getNumComp() {
        return numComp;
    }

    public void setNumComp(String numComp) {
        this.numComp = numComp;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdProdu() {
        return idProdu;
    }

    public void setIdProdu(int idProdu) {
        this.idProdu = idProdu;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
    
    
    
}
