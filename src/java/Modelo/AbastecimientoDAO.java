/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author enriq
 */
public class AbastecimientoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String IdCo() {

        String idcom = "";
        String sql = "Select max(IdCompras) from compras";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                idcom = rs.getString(1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idcom;

    }

    public int guardarCompra(Abastecimiento abas) {
        String sql = "insert into compras(IdProveedor, TipoComprobante,NroFactura,Fecha,TotalPagar) values(?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, abas.getIdProve());
            ps.setString(2, abas.getTipComprob());
            ps.setString(3, abas.getNumFac());
            ps.setString(4, abas.getFechComp());
            ps.setDouble(5, abas.getTotalpago());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public int guardarDetalleCompra(Abastecimiento abaste) {
        String sql = "insert into detalle_compras(IdCompras, IdProducto,Cantidad,PrecioCompra,PrecioTotal) values(?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, abaste.getIdComp());
            ps.setInt(2, abaste.getIdProduc());
            ps.setInt(3, abaste.getCantidad());
            ps.setDouble(4, abaste.getPreComp());
            ps.setDouble(5, abaste.getPreTot());

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
    
    public int getMargenGanancia(int idProducto) {
        int margenganancia = 0;
        String sql = "SELECT MargenGanancia FROM producto WHERE IdProducto = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                margenganancia = rs.getInt("MargenGanancia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return margenganancia;
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

    public void actualizarPrecioCompraProducto(int idProducto, double nuevoPrecioCompra, double nuevoPrecioVenta) {
        String sql = "UPDATE producto SET PrecioCompra = ?, PrecioVenta=? WHERE IdProducto = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, nuevoPrecioCompra);
            ps.setDouble(2, nuevoPrecioVenta);
            ps.setInt(3, idProducto);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
