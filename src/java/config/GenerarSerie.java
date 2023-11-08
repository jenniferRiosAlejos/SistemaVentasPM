/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author enriq
 */
public class GenerarSerie {
    
    int dato;
    String numero;
    public String NumeroSerie(int dato){
    
   this.dato = dato + 1;
        numero = String.format("%08d", this.dato); // Formatear a cadena con 8 dígitos y ceros a la izquierda
        return numero;
    }
    
    
    
}
