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
public class CategoriaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     //Operaciones CRUD
    public List listar() {
        String sql = "Select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt(1));
                cat.setDescrip(rs.getString(2));
                cat.setEstado(rs.getString(3));
                lista.add(cat);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int agregar(Categoria cat) {
        String sql = "insert into categoria(Descripcion, Estado) values(?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getDescrip());
            ps.setString(2, cat.getEstado());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Categoria listarId(int id) {
        Categoria cat = new Categoria();
        String sql = "Select * from categoria where IdCategoria=" + id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                cat.setDescrip(rs.getString(2));
                cat.setEstado(rs.getString(3));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cat;
    }

    public int actualizar(Categoria cat) {
        String sql = "update categoria set Descripcion=?, Estado=? where IdCategoria=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getDescrip());
            ps.setString(2, cat.getEstado());
            ps.setInt(3, cat.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from categoria where IdCategoria=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
