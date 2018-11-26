package test.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import model.Thuoc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.ThuocDao;

public class ThuocDaoTest {
  private ThuocDao thuocDao;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    thuocDao = new ThuocDao();
  }

  @After
  public void tearDown(){
    thuocDao = null;
  }

  @Test
  public void testGetDSThuocSuccess() {
    List<Thuoc> dsThuoc = thuocDao.getDSThuoc();
    assertNotNull(dsThuoc);
    assertNotEquals(dsThuoc.size(), 0);
  }
  
  @Test
  public void testGetThuocSuccess(){
      Thuoc thuoc = thuocDao.getThuocByTD(3);
      assertNotNull(thuoc);
  }
  
  @Test
  public void testGetThuocFail(){
      Thuoc thuoc = thuocDao.getThuocByTD(999);
      assertNull(thuoc);
  }
}
