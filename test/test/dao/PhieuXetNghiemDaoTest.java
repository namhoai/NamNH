package test.dao;

import test.dao.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connection.ConnectionFactory;
import dao.PhieuXetNghiemDao;
import java.util.List;
import model.PhieuXetNghiem;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;

public class PhieuXetNghiemDaoTest {
  private PhieuXetNghiemDao pxnDao;
  private Connection connection;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    connection = ConnectionFactory.getInstance().getConnection();
    pxnDao = new PhieuXetNghiemDao();
  }

  @After
  public void tearDown() throws SQLException {
    pxnDao = null;
    connection.rollback();
    connection.close();
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
      assertNull(dsPXN);
  }

  @Test
  public void testAddPhieuXetNghiemSuccess() {
    PhieuXetNghiem pxn = new PhieuXetNghiem();
    pxn.setId(1);
    pxn.setKetQua("Tot");
    int benhAnID = 1;

    assertTrue(pxnDao.addPhieuXetNghiem(pxn, benhAnID));
  }

  @Test
  public void testAddPhieuXetNghiemFail() {
    PhieuXetNghiem pxn = new PhieuXetNghiem();
    pxn.setId(999);
    pxn.setKetQua("Tot");
    int benhAnID = 999;

    assertFalse(pxnDao.addPhieuXetNghiem(pxn,benhAnID));
  }

  @Test
  public void testDeletePhieuXetNghiemSuccess() {
    assertTrue(pxnDao.deletePhieuXetNghiem(10));
  }

  @Test
  public void testDeletePhieuXetNghiemFail() {
    assertFalse(pxnDao.deletePhieuXetNghiem(999));
  }
}
