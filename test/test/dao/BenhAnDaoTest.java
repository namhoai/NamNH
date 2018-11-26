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
import dao.BenhAnDao;
import java.util.List;
import model.BenhAn;
import static org.junit.Assert.assertNotEquals;

public class BenhAnDaoTest {
  private BenhAnDao benhAnDao;
  private Connection connection;
  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    connection = ConnectionFactory.getInstance().getConnection();
    benhAnDao = new BenhAnDao();
    
  }

  @After
  public void tearDown() throws SQLException {
    benhAnDao = null;
    connection.rollback();
    connection.close();
  }

  @Test
  public void testGetBenhAnSuccess() {
    BenhAn actual = benhAnDao.getBenhAn(1);
    assertNotNull(actual);
  }

  @Test
  public void testGetBenhAnFail() {
    BenhAn actual = benhAnDao.getBenhAn(999);
    assertNull(actual);
  }

  @Test
  public void testUpdateBenhAnSuccess() {
    BenhAn benhAn = new BenhAn();
    benhAn.setId(1);
    benhAn.setKhamLS("Binh Thuong");
    benhAn.setKetQua("Tot");
    assertTrue(benhAnDao.updateBenhAn(benhAn));
  }
  
  @Test
  public void testUpdateBenhAnFail() {
    BenhAn benhAn = new BenhAn();
    benhAn.setId(999);
    benhAn.setKhamLS("Binh Thuong");
    benhAn.setKetQua("Tot");
    assertFalse(benhAnDao.updateBenhAn(benhAn));
  }
  
  @Test
  public void testGetDSBenhAnSuccess(){
      List<BenhAn> dsBenhAn = benhAnDao.getDSBenhAn(1);
      assertNotNull(dsBenhAn);
      assertNotEquals(dsBenhAn.size(), 0);
  }
  
  @Test
  public void testGetDSBenhAnFail(){
      List<BenhAn> dsBenhAn = benhAnDao.getDSBenhAn(999);
      assertNull(dsBenhAn);
  }
}
