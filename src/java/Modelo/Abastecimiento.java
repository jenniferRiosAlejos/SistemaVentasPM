/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author enriq
 */
public class Abastecimiento {

    int item;
//datos para la tabla compra
    int idComp;
    int idProve;
    String tipComprob;
    String NumFac;
    String FechComp;
    double Totalpago;

    int idDetaComp;
    int idProduc;
    String descPro;
    int cantidad;
    double preComp;
    double preTot;

    public Abastecimiento() {
    }

    public Abastecimiento(int item, int idComp, int idProve, String tipComprob, String NumFac, String FechComp, double Totalpago, int idDetaComp, int idProduc, String descPro, int cantidad, double preComp, double preTot) {
        this.item = item;
        this.idComp = idComp;
        this.idProve = idProve;
        this.tipComprob = tipComprob;
        this.NumFac = NumFac;
        this.FechComp = FechComp;
        this.Totalpago = Totalpago;
        this.idDetaComp = idDetaComp;
        this.idProduc = idProduc;
        this.descPro = descPro;
        this.cantidad = cantidad;
        this.preComp = preComp;
        this.preTot = preTot;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public int getIdProve() {
        return idProve;
    }

    public void setIdProve(int idProve) {
        this.idProve = idProve;
    }

    public String getTipComprob() {
        return tipComprob;
    }

    public void setTipComprob(String tipComprob) {
        this.tipComprob = tipComprob;
    }

    public String getNumFac() {
        return NumFac;
    }

    public void setNumFac(String NumFac) {
        this.NumFac = NumFac;
    }

    public String getFechComp() {
        return FechComp;
    }

    public void setFechComp(String FechComp) {
        this.FechComp = FechComp;
    }

    public double getTotalpago() {
        return Totalpago;
    }

    public void setTotalpago(double Totalpago) {
        this.Totalpago = Totalpago;
    }

    public int getIdDetaComp() {
        return idDetaComp;
    }

    public void setIdDetaComp(int idDetaComp) {
        this.idDetaComp = idDetaComp;
    }

    public int getIdProduc() {
        return idProduc;
    }

    public void setIdProduc(int idProduc) {
        this.idProduc = idProduc;
    }

    public String getDescPro() {
        return descPro;
    }

    public void setDescPro(String descPro) {
        this.descPro = descPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreComp() {
        return preComp;
    }

    public void setPreComp(double preComp) {
        this.preComp = preComp;
    }

    public double getPreTot() {
        return preTot;
    }

    public void setPreTot(double preTot) {
        this.preTot = preTot;
    }


    
}
