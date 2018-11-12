/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author HoaiNam
 */
public class BenhAn {
    private int id;
    private BenhNhan benhNhan;
    private List<PhieuXetNghiem> dsPhieuXN;
    private List<ThuocDung> donThuoc;
    private String ketQua;
    private String khamLS;

    public BenhAn() {
    }

    public BenhAn(int id, BenhNhan benhNhan, List<PhieuXetNghiem> dsPhieuXN, List<ThuocDung> donThuoc, String ketQua, String khamLS) {
        this.id = id;
        this.benhNhan = benhNhan;
        this.dsPhieuXN = dsPhieuXN;
        this.donThuoc = donThuoc;
        this.ketQua = ketQua;
        this.khamLS = khamLS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public List<PhieuXetNghiem> getDsPhieuXN() {
        return dsPhieuXN;
    }

    public void setDsPhieuXN(List<PhieuXetNghiem> dsPhieuXN) {
        this.dsPhieuXN = dsPhieuXN;
    }

    public List<ThuocDung> getDonThuoc() {
        return donThuoc;
    }

    public void setDonThuoc(List<ThuocDung> donThuoc) {
        this.donThuoc = donThuoc;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getKhamLS() {
        return khamLS;
    }

    public void setKhamLS(String khamLS) {
        this.khamLS = khamLS;
    }
    
    
}
