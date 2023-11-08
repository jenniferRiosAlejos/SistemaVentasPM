/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author enriq
 */
public class VentasDAO {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String IdVen() {

        String idven = "";
        String sql = "Select max(IdVentas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                idven = rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idven;

    }

    public int guardarVenta(Ventas vent) {
        String sql = "insert into ventas(IdCliente, IdEmpleado,Fecha,Total,tipocomprobante,numComprobante) values(?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vent.getIdCliente());
            ps.setInt(2, vent.getIdEmpleado());
            ps.setString(3, vent.getFecha());
            ps.setDouble(4, vent.getTotal());
            ps.setString(5, vent.getTipComp());
            ps.setString(6, vent.getNumComp());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public int guardarDetalleVenta(Ventas venta) {
        String sql = "insert into detalle_ventas(IdVentas, IdProducto,Cantidad,PrecioUnidad,PrecioTotal) values(?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getIdVentas());
            ps.setInt(2, venta.getIdProdu());
            ps.setInt(3, venta.getCant());
            ps.setDouble(4, venta.getPrecioUnidad());
            ps.setDouble(5, venta.getSubtotal());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public int getCantidadExistente(int idProducto) {
        int cantidadExistente = 0;
        String sql = "SELECT Stock FROM producto WHERE IdProducto = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                cantidadExistente = rs.getInt("Stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cantidadExistente;
    }
    
    

    public void actualizarCantidad(int idProducto, int nuevaCantidad) {
        String sql = "UPDATE producto SET Stock = ? WHERE IdProducto = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public String GenerarSerie2() {

        String numeroserie = "";
    // Crea una consulta SQL para obtener el último número correlativo para el tipo de comprobante
    String sql = "SELECT MAX(numComprobante) FROM ventas";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            numeroserie = rs.getString(1); // Obtener el valor directamente del ResultSet
            if (numeroserie == null || numeroserie.isEmpty()) {
                numeroserie = "00000001"; // Valor predeterminado si no hay datos en la base de datos
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return numeroserie;
    }
 
 
}
