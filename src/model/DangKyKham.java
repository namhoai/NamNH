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
public class DangKyKham {
    private int id;
    private BenhAn benhAn;
    private Buong buongKham;
    private String trangThai; 
    // có 3 trạng thái khám : "Cho Kham" | "Dang Xet Nghiem" | "Kham Lai" | "Hoan Thanh" |

    public DangKyKham() {
    }

    public DangKyKham(int id, BenhAn benhAn, Buong buongKham, String trangThai) {
        this.id = id;
        this.benhAn = benhAn;
        this.buongKham = buongKham;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BenhAn getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(BenhAn benhAn) {
        this.benhAn = benhAn;
    }

    public Buong getBuongKham() {
        return buongKham;
    }

    public void setBuongKham(Buong buongKham) {
        this.buongKham = buongKham;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
  
}
