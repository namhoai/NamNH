/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BenhAnDao;
import dao.BenhNhanDao;
import java.util.ArrayList;
import java.util.List;
import model.BenhAn;
import model.BenhNhan;

/**
 *
 * @author HoaiNam
 */
public class MainController {
    public List<BenhAn> getDSBenhAnCho(int buongKhamId) {
        List<BenhAn> dsBA = new ArrayList<>();
        BenhAnDao benhAnDao = new BenhAnDao();
        dsBA = benhAnDao.getDSBenhAn(buongKhamId);

        BenhNhanDao benhNhanDao = new BenhNhanDao();
        for (BenhAn ba : dsBA) {
            BenhNhan bn = benhNhanDao.getBenhNhanByBenhAn(ba.getId());
            ba.setBenhNhan(bn);
        }
        return dsBA;
    }
}
