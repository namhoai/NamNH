/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BenhAnDao;
import dao.BuongDao;
import dao.PhieuXetNghiemDao;
import dao.ThuocDao;
import dao.ThuocDungDao;
import dao.XetNghiemDao;
import java.util.List;
import model.BenhAn;
import model.Buong;
import model.PhieuXetNghiem;
import model.Thuoc;
import model.ThuocDung;
import model.XetNghiem;

/**
 *
 * @author HoaiNam
 */
public class KhamController {
    public List<PhieuXetNghiem> getDSPhieuXetNghiem(int benhAnId) {
        List<PhieuXetNghiem> dsPXN;
        
        PhieuXetNghiemDao phieuXetNghiemDao = new PhieuXetNghiemDao();
        dsPXN = phieuXetNghiemDao.getDsPhieuXetNghiem(benhAnId);
        
        XetNghiemDao xetNghiemDao = new XetNghiemDao();
        
        BuongDao buongDao = new BuongDao();
        
        for (PhieuXetNghiem pxn : dsPXN) {
            XetNghiem xetNghiem = xetNghiemDao.getXetNghiemByPXN(pxn.getId());
            Buong buong = buongDao.getBuongbyPXN(pxn.getId());
            pxn.setXetNghiem(xetNghiem);
            pxn.setBuong(buong);
        }
        
        return dsPXN;
    }

    public List<ThuocDung> getDonThuoc(int benhAnId) {
        List<ThuocDung> donThuoc;
        
        ThuocDungDao thuocDungDao = new ThuocDungDao();
        donThuoc = thuocDungDao.getDSThuoc(benhAnId);
        
        ThuocDao thuocDao = new ThuocDao();
        
        for (ThuocDung thuocDung : donThuoc) {
            Thuoc thuoc = thuocDao.getThuocByTD(thuocDung.getId());
            thuocDung.setThuoc(thuoc);
        }
        
        return donThuoc;
    }

    public boolean updateBenhAn(BenhAn benhAn) {
        BenhAnDao benhAnDao = new BenhAnDao();
        return benhAnDao.updateBenhAn(benhAn);
    }
}
