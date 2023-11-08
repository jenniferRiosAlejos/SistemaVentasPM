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
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author enriq
 */
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String contraseña) {

        Empleado em = new Empleado();
        String sql = "Select * from empleado where User=? and contraseña=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while (rs.next()) {

                em.setUser(rs.getString("User"));
                em.setContraseña(rs.getString("contraseña"));
                em.setNom(rs.getString("Nombres"));
                em.setDni(rs.getString("Dni"));
                em.setEstado(rs.getString("estado"));
                em.setId(rs.getInt("IdEmpleado"));

            }

        } catch (Exception e) {
        }
        return em;
    }

    //Operaciones CRUD
    public List listar() {
        String sql = "Select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                em.setContraseña("Oculto");
                lista.add(em);

            }

        } catch (Exception e) {
        }
        return lista;
    }
    
    public boolean existeDNI(String dni) {
        String sql = "SELECT COUNT(*) FROM empleado WHERE Dni = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Si el DNI existe, el count será mayor a 0, de lo contrario, será 0.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // En caso de error o si no se encontraron registros, asumimos que el DNI no existe.
    }


    public int agregar(Empleado em) {
        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User, contraseña) values(?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setString(6,em.getContraseña());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "Select * from empleado where IdEmpleado=" + id;
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
                emp.setContraseña("");
                
                

            }
        } catch (Exception e) {
        }
        return emp;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set DNI=?, Nombres=?, Telefono=?, Estado=?, User=?, contraseña=SHA2(?, 256) where IdEmpleado=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setString(6, em.getContraseña());
            ps.setInt(7, em.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
