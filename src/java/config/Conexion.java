/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author enriq
 */
public class Conexion {
    Connection con;
    public Connection Conexion(){
        
        String url="jdbc:mysql://localhost:3306/bd_ventas";
        String user="root";
        String pass="123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
        }
        
        return con;
        
    }
}
