/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HoaiNam
 */
public class ThuocDung {
    private int id;
    private Thuoc thuoc;
    private int soLuong;
    private float chiPhi;
    private String cachSD;

    public ThuocDung() {
    }

    public ThuocDung(int id, Thuoc thuoc, int soLuong, float chiPhi, String cachSD) {
        this.id = id;
        this.thuoc = thuoc;
        this.soLuong = soLuong;
        this.chiPhi = chiPhi;
        this.cachSD = cachSD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getCachSD() {
        return cachSD;
    }

    public void setCachSD(String cachSD) {
        this.cachSD = cachSD;
    }
    
    
}
