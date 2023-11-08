/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author enriq
 */
public class Producto {
    int id;
    int cod;
    String descrip;
    double precioCom;
    double precioVen;
    int stock;
    String estado;
    int idCat;
    int idMar;
    String descripCat;
    String descripMar;
    int margen;

    public Producto() {
    }

    public Producto(int id,int cod, String descrip, double precioCom, double precioVen, int stock, String estado, int idCat, int idMar, String descripCat, String descripMar, int margen) {
        this.id = id;
        this.cod = cod;
        this.descrip = descrip;
        this.precioCom = precioCom;
        this.precioVen = precioVen;
        this.stock = stock;
        this.estado = estado;
        this.idCat = idCat;
        this.idMar = idMar;
        this.descripCat = descripCat;
        this.descripMar = descripMar;
        this.margen = margen;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecioCom() {
        return precioCom;
    }

    public void setPrecioCom(double precioCom) {
        this.precioCom = precioCom;
    }

    public double getPrecioVen() {
        return precioVen;
    }

    public void setPrecioVen(double precioVen) {
        this.precioVen = precioVen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getIdMar() {
        return idMar;
    }

    public void setIdMar(int idMar) {
        this.idMar = idMar;
    }

    public String getDescripCat() {
        return descripCat;
    }

    public void setDescripCat(String descripCat) {
        this.descripCat = descripCat;
    }

    public String getDescripMar() {
        return descripMar;
    }

    public void setDescripMar(String descripMar) {
        this.descripMar = descripMar;
    }

    public int getMargen() {
        return margen;
    }

    public void setMargen(int margen) {
        this.margen = margen;
    }
    
    
    
    
}
