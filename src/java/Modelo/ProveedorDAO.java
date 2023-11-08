/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enriq
 */
public class ProveedorDAO {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    //Operaciones CRUD
    public List listar() {
        String sql = "Select * from proveedor";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdprove(rs.getInt(1));
                pro.setProve(rs.getString(2));
                pro.setRuc(rs.getString(3));
                pro.setRepre(rs.getString(4));
                pro.setTipProve(rs.getString(5));
                pro.setTel(rs.getString(6));
                pro.setDirec(rs.getString(7));
                pro.setEstado(rs.getString(8));
                lista.add(pro);

            }

        } catch (Exception e) {
        }
        return lista;
    }

    public boolean existeRUC(String ruc) {
        String sql = "SELECT COUNT(*) FROM proveedor WHERE Ruc = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ruc);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Si el RUC existe, el count será mayor a 0, de lo contrario, será 0.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // En caso de error o si no se encontraron registros, asumimos que el RUC no existe.
    }
    public int agregar(Proveedor prov) {
        String sql = "INSERT INTO proveedor (Proveedor, Ruc, Representante, TipoProveedor, Telefono, Direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getProve());
            ps.setString(2, prov.getRuc() );
            ps.setString(3, prov.getRepre());
            ps.setString(4, prov.getTipProve());
            ps.setString(5, prov.getTel());
            ps.setString(6, prov.getDirec());
            ps.setString(7, prov.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Proveedor listarId(int id) {
        Proveedor prov = new Proveedor();
        String sql = "SELECT * FROM proveedor where IdProveedor=" + id;
        try {

           con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
                prov.setIdprove(rs.getInt(1));
                prov.setProve(rs.getString(2));
                prov.setRuc(rs.getString(3));
                prov.setRepre(rs.getString(4));
                prov.setTipProve(rs.getString(5));
                prov.setTel(rs.getString(6));
                prov.setDirec(rs.getString(7));
                prov.setEstado(rs.getString(8));
               
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prov;
    }
    
    public Proveedor buscar(String ruc) {
        Proveedor prov = new Proveedor();
        String sql = "SELECT * FROM proveedor where Ruc=" + ruc;
        try {

           con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
                prov.setIdprove(rs.getInt(1));
                prov.setProve(rs.getString(2));
                prov.setRuc(rs.getString(3));
                prov.setRepre(rs.getString(4));
                prov.setTipProve(rs.getString(5));
                prov.setTel(rs.getString(6));
                prov.setDirec(rs.getString(7));
                prov.setEstado(rs.getString(8));
               
                

            }
        } catch (Exception e) {
           
        }

        return prov;
    }
    

    public int actualizar(Proveedor prov) {
        String sql = "update proveedor set Proveedor=?, Ruc=?, Representante=?, TipoProveedor=?, Telefono=?, Direccion=?, estado=? where IdProveedor=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getProve());
            ps.setString(2, prov.getRuc());
            ps.setString(3, prov.getRepre());
            ps.setString(4, prov.getTipProve());
            ps.setString(5, prov.getTel());
            ps.setString(6, prov.getDirec());
            ps.setString(7, prov.getEstado());
            ps.setInt(8,prov.getIdprove());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from proveedor where IdProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
