/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ThuocDao;
import dao.ThuocDungDao;
import java.util.List;
import model.Thuoc;
import model.ThuocDung;

/**
 *
 * @author HoaiNam
 */
public class DonThuocController {
    
    public boolean deleteThuocDung (int thuocDungID) {
        ThuocDungDao thuocDungDao = new ThuocDungDao();
        return thuocDungDao.deleteThuocDung(thuocDungID);
    }
    
    public List<Thuoc> getDSThuoc () {
        ThuocDao thuocDao = new ThuocDao();
        return thuocDao.getDSThuoc();
    }

    public boolean addThucDung(ThuocDung thuocDung, int benhAnID) {
        ThuocDungDao thuocDungDao = new ThuocDungDao();
        return thuocDungDao.addThuocDung(thuocDung, benhAnID);
    }
}
