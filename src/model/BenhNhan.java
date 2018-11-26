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
public class BenhNhan {
    private int id;
    private String ten;
    private int tuoi;
    private String SDT;
    private String DiaChi;

    public BenhNhan() {
    }

    public BenhNhan(int id, String ten, int tuoi, String SDT, String DiaChi) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
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

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    // test
    @Override
    public String toString() {
        return "BenhNhan{" + "id=" + id + ", ten=" + ten + ", tuoi=" + tuoi + ", SDT=" + SDT + ", DiaChi=" + DiaChi + '}';
    }
}
