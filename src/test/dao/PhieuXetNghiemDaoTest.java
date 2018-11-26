package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import model.Buong;
import model.PhieuXetNghiem;
import model.XetNghiem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.PhieuXetNghiemDao;

public class PhieuXetNghiemDaoTest {
  private PhieuXetNghiemDao pxnDao;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
   // connection = ConnectionFactory.getInstance().getConnection();
    pxnDao = new PhieuXetNghiemDao();
  }

  @After
  public void tearDown() throws SQLException {
    pxnDao = null;
    //connection.rollback();
   // connection.close();
  }

  @Test
  public void testGetDSPhieuXetNghiemSuccess(){
      List<PhieuXetNghiem> dsPXN = pxnDao.getDsPhieuXetNghiem(1);
      assertNotNull(dsPXN);
      assertNotEquals(dsPXN.size(), 0);
  }
  
  @Test
  public void testGetDSPhieuXetNghiemFail(){
      List<PhieuXetNghiem> dsPXN = pxnDao.getDsPhieuXetNghiem(999);
      assertEquals(dsPXN.size(), 0);
  }

  @Test
  public void testAddPhieuXetNghiemSuccess() {
    PhieuXetNghiem pxn = new PhieuXetNghiem();
    pxn.setId(1);
    pxn.setKetQua("Tot");
    int benhAnID = 1;
    
    // Thêm buồng vào.
    Buong buong = new Buong();
    buong.setId(1);
    pxn.setBuong(buong);
    
    // Thêm xét nghiệm.
    XetNghiem xn = new XetNghiem();
    xn.setId(1);
    pxn.setXetNghiem(xn);
    assertTrue(pxnDao.addPhieuXetNghiem(pxn, benhAnID));
  }

  @Test
  public void testAddPhieuXetNghiemFail() {
    PhieuXetNghiem pxn = new PhieuXetNghiem();
    pxn.setId(999);
    pxn.setKetQua("Tot");
    int benhAnID = 999;

    // Thêm buồng vào.
    Buong buong = new Buong();
    buong.setId(1);
    pxn.setBuong(buong);

    // Thêm xét nghiệm.
    XetNghiem xn = new XetNghiem();
    xn.setId(1);
    pxn.setXetNghiem(xn);

    assertFalse(pxnDao.addPhieuXetNghiem(pxn,benhAnID));
  }

  @Test
  public void testDeletePhieuXetNghiemSuccess() {
	  // TODO : xóa phiếu xét nghiệm có ID = 5;
    assertTrue(pxnDao.deletePhieuXetNghiem(5));
  }

  @Test
  public void testDeletePhieuXetNghiemFail() {
	  // TODO : xóa phiếu xét nghiệm có ID = 999;
    assertFalse(pxnDao.deletePhieuXetNghiem(999));
  }
}
