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
public class Buong {
    private int id;
    private String ten;
    private String viTri;
    private String loai; // có 2 loại |Phong Kham| Xet Nghiem

    public Buong() {
    }
    
    public Buong(int id, String ten, String viTri, String loai) {
        this.id = id;
        this.ten = ten;
        this.viTri = viTri;
        this.loai = loai;
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

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
}
