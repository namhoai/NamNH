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
public class XetNghiem {
    private int id;
    private String ten;
    private float chiPhi;

    public XetNghiem() {
    }

    public XetNghiem(int id, String ten, float chiPhi) {
        this.id = id;
        this.ten = ten;
        this.chiPhi = chiPhi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    
    
}
