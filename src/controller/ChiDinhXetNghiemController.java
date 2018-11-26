/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BuongDao;
import dao.PhieuXetNghiemDao;
import dao.XetNghiemDao;
import java.util.List;
import model.Buong;
import model.PhieuXetNghiem;
import model.XetNghiem;

/**
 *
 * @author HoaiNam
 */
public class ChiDinhXetNghiemController {
    public List<XetNghiem> getDSXetNghiem () {
        XetNghiemDao xetNghiemDao = new XetNghiemDao();
        return xetNghiemDao.getDSXetNghiem();
    }

    public List<Buong> getBuongXN(int xetNghiemId) {
        BuongDao buongDao = new BuongDao();
        return buongDao.getDSBuongXN(xetNghiemId);
    }

    public boolean deletePhieuXN(int PXNID) {
        PhieuXetNghiemDao phieuXetNghiem = new PhieuXetNghiemDao();
        return phieuXetNghiem.deletePhieuXetNghiem(PXNID);
    }
    
    public boolean addPhieuXN(PhieuXetNghiem phieuXN, int benhAnID) {
        PhieuXetNghiemDao phieuXetNghiem = new PhieuXetNghiemDao();
        return phieuXetNghiem.addPhieuXetNghiem(phieuXN, benhAnID);
    }
}
