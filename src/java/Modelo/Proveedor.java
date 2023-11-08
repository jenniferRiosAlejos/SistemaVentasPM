/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author enriq
 */
public class Proveedor {
    int idprove;
    String prove;
    String ruc;
    String repre;
    String tipProve;
    String tel;
    String direc;
    String estado;

    public Proveedor() {
    }

    public Proveedor(int idprove, String prove, String ruc, String repre, String tipProve, String tel, String direc, String estado) {
        this.idprove = idprove;
        this.prove = prove;
        this.ruc = ruc;
        this.repre = repre;
        this.tipProve = tipProve;
        this.tel = tel;
        this.direc = direc;
        this.estado = estado;
    }

    public int getIdprove() {
        return idprove;
    }

    public void setIdprove(int idprove) {
        this.idprove = idprove;
    }

    public String getProve() {
        return prove;
    }

    public void setProve(String prove) {
        this.prove = prove;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepre() {
        return repre;
    }

    public void setRepre(String repre) {
        this.repre = repre;
    }

    public String getTipProve() {
        return tipProve;
    }

    public void setTipProve(String tipProve) {
        this.tipProve = tipProve;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
}
