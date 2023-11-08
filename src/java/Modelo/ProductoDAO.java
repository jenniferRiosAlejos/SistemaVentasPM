/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enriq
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //Operaciones CRUD
    public List listar() {
        String sql = "SELECT c.descripcion AS categoria, m.descripcion AS marca, p.idProducto, p.descripcion, p.codigo, p.PrecioCompra, p.MargenGanancia, p.PrecioVenta,p.Stock, p.Estado, p.IdCategoria, p.IdMarca\n"
                + "FROM producto p\n"
                + "JOIN categoria c ON p.idCategoria = c.idCategoria\n"
                + "JOIN marca m ON p.idMarca = m.idMarca";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(3));
                pro.setDescripCat(rs.getString(1));
                pro.setDescripMar(rs.getString(2));
                pro.setDescrip(rs.getString(4));
                pro.setCod(rs.getInt(5));
                pro.setPrecioCom(rs.getDouble(6));
                pro.setMargen(rs.getInt(7));
                pro.setPrecioVen(rs.getDouble(8));
                pro.setStock(rs.getInt(9));
                pro.setEstado(rs.getString(10));
                pro.setIdCat(rs.getInt(11));
                pro.setIdMar(rs.getInt(12));
                
                lista.add(pro);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public boolean ExisteProCodigo(int codigo) {
        String sql = "SELECT COUNT(*) FROM producto WHERE Codigo = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si el producto existe, el count será mayor a 0.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Por defecto, consideramos que el producto no existe.
    }

    public int agregar(Producto pro) {
        String sql = "INSERT INTO producto (Codigo,Descripcion, PrecioCompra, PrecioVenta, Stock, Estado, IdCategoria, IdMarca, MargenGanancia) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCod());
            ps.setString(2, pro.getDescrip());
            ps.setDouble(3, pro.getPrecioCom());
            ps.setDouble(4, pro.getPrecioVen());
            ps.setInt(5, 0);
            ps.setString(6, pro.getEstado());
            ps.setInt(7, pro.getIdCat());
            ps.setInt(8, pro.getIdMar());
            ps.setInt(9, pro.getMargen());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto pro = new Producto();
        String sql = "SELECT c.descripcion AS categoria, m.Descripcion AS marca,p.IdProducto, p.Codigo, p.descripcion, p.PrecioCompra, p.PrecioVenta,"
                + "p.Stock, p.Estado,p.IdCategoria, p.IdMarca , p.MargenGanancia FROM producto p JOIN categoria c ON p.idCategoria = c.idCategoria JOIN marca m ON p.idMarca = m.idMarca where IdProducto=" + id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setDescripCat(rs.getString(1));
                pro.setDescripMar(rs.getString(2));
                pro.setId(rs.getInt(3));
                pro.setCod(rs.getInt(4));
                pro.setDescrip(rs.getString(5));
                pro.setPrecioCom(rs.getDouble(6));
                pro.setPrecioVen(rs.getDouble(7));
                pro.setStock(rs.getInt(8));
                pro.setEstado(rs.getString(9));
                pro.setIdCat(rs.getInt(10));
                pro.setIdMar(rs.getInt(11));
                pro.setMargen(rs.getInt(12));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pro;
    }
    public Producto listarCod(int codBus) {
        Producto pro = new Producto();
        String sql = "SELECT c.descripcion AS categoria, m.Descripcion AS marca,p.IdProducto, p.Codigo, p.descripcion, p.PrecioCompra, p.PrecioVenta,"
                + "p.Stock, p.Estado,p.IdCategoria, p.IdMarca , p.MargenGanancia FROM producto p JOIN categoria c ON p.idCategoria = c.idCategoria JOIN marca m ON p.idMarca = m.idMarca where Codigo=" + codBus;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setDescripCat(rs.getString(1));
                pro.setDescripMar(rs.getString(2));
                pro.setId(rs.getInt(3));
                pro.setCod(rs.getInt(4));
                pro.setDescrip(rs.getString(5));
                pro.setPrecioCom(rs.getDouble(6));
                pro.setPrecioVen(rs.getDouble(7));
                pro.setStock(rs.getInt(8));
                pro.setEstado(rs.getString(9));
                pro.setIdCat(rs.getInt(10));
                pro.setIdMar(rs.getInt(11));
                pro.setMargen(rs.getInt(12));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pro;
    }
    
    public Producto listarNom(String nomBus) {
        Producto pro = new Producto();
        String sql = "SELECT c.descripcion AS categoria, m.Descripcion AS marca, p.IdProducto, p.Codigo, p.descripcion, p.PrecioCompra, p.PrecioVenta, "
            + "p.Stock, p.Estado, p.IdCategoria, p.IdMarca, p.MargenGanancia FROM producto p "
            + "JOIN categoria c ON p.idCategoria = c.idCategoria "
            + "JOIN marca m ON p.idMarca = m.idMarca where Descripcion LIKE ?";
        System.out.println("Ejecutando consulta con descripción: " + nomBus);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nomBus + "%");
            rs = ps.executeQuery();  
            while (rs.next()) {
                pro.setDescripCat(rs.getString(1));
                pro.setDescripMar(rs.getString(2));
                pro.setId(rs.getInt(3));
                pro.setCod(rs.getInt(4));
                pro.setDescrip(rs.getString(5));
                pro.setPrecioCom(rs.getDouble(6));
                pro.setPrecioVen(rs.getDouble(7));
                pro.setStock(rs.getInt(8));
                pro.setEstado(rs.getString(9));
                pro.setIdCat(rs.getInt(10));
                pro.setIdMar(rs.getInt(11));
                pro.setMargen(rs.getInt(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pro;
    }
    public int actualizar(Producto pro) {
        String sql = "update producto set Codigo=?,Descripcion=?,PrecioCompra=?, PrecioVenta=?, Estado=?, IdCategoria=?, IdMarca=?, MargenGanancia=? where IdProducto=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCod());
            ps.setString(2, pro.getDescrip());
            ps.setDouble(3, pro.getPrecioCom());
            ps.setDouble(4, pro.getPrecioVen());
            ps.setString(5, pro.getEstado());
            ps.setInt(6, pro.getIdCat());
            ps.setInt(7, pro.getIdMar());
            ps.setInt(8, pro.getMargen());
            ps.setInt(9, pro.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
