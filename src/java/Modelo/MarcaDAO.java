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
public class MarcaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     

    public int agregar(Marca mar) {
        String sql = "insert into marca(Descripcion, Estado) values(?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mar.getDescrip());
            ps.setString(2, mar.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Marca listarId(int id) {
        Marca mar = new Marca();
        String sql = "Select * from marca where IdMarca=" + id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                mar.setDescrip(rs.getString(2));
                mar.setEstado(rs.getString(3));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mar;
    }

    public int actualizar(Marca mar) {
        String sql = "update marca set Descripcion=?, Estado=? where IdMarca=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mar.getDescrip());
            ps.setString(2, mar.getEstado());
            ps.setInt(3, mar.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from marca where IdMarca=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
