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
public class PhieuXetNghiem {

    private int id;
    private Buong buong;
    private XetNghiem xetNghiem;
    private String ketQua;

    public PhieuXetNghiem() {
    }

    public PhieuXetNghiem(int id, Buong buong, XetNghiem xetNghiem, String ketQua) {
        this.id = id;
        this.buong = buong;
        this.xetNghiem = xetNghiem;
        this.ketQua = ketQua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buong getBuong() {
        return buong;
    }

    public void setBuong(Buong buong) {
        this.buong = buong;
    }

    public XetNghiem getXetNghiem() {
        return xetNghiem;
    }

    public void setXetNghiem(XetNghiem xetNghiem) {
        this.xetNghiem = xetNghiem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    
}
