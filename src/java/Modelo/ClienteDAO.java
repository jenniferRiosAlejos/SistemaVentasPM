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
public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    //Operaciones CRUD
    public List listar() {
        String sql = "Select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));
                lista.add(cli);

            }

        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Cliente cli) {
        String sql = "insert into cliente(IdCliente, Dni, Nombres, Direccion, Estado) values(?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getDni());
            ps.setString(3, cli.getNom());
            ps.setString(4, cli.getDir());
            ps.setString(5, cli.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Cliente listarId(int id) {
         Cliente clie = new Cliente();
        String sql = "Select * from cliente where IdCliente=" + id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                clie.setDni(rs.getString(2));
                clie.setNom(rs.getString(3));
                clie.setDir(rs.getString(4));
                clie.setEstado(rs.getString(5));
               
                
                

            }
        } catch (Exception e) {
        }
        return clie;
    }

    public int actualizar(Cliente cli) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int obtenerIdCliente() {
    int idCliente=0;
    String sql = "SELECT MAX(IdCliente) FROM cliente";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            idCliente = rs.getInt(1)+1 ;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return idCliente;
}
    
    public Cliente buscar(String dni) {
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM cliente where Dni=" + dni;
        try {

           con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setEstado(rs.getString(5));
           
            }
        } catch (Exception e) {
           
        }
    return cli;
    
}
}