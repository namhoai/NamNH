package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import model.BenhAn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BenhAnDao;

public class BenhAnDaoTest {
  private BenhAnDao benhAnDao;

  // Chạy trước test. setup trước.
  @Before
  public void setUp() {
    benhAnDao = new BenhAnDao();
  }

  // Chạy sau khi test. -> đỡ tốn tài nguyên <Khi không dùng đến>.
  @After
  public void tearDown() {
    benhAnDao = null;
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
    benhAn.setTrangThai("Cho Kham");
    assertTrue(benhAnDao.updateBenhAn(benhAn));
  }
  
  @Test
  public void testUpdateBenhAnFail() {
    BenhAn benhAn = new BenhAn();
    benhAn.setId(999);
    benhAn.setKhamLS("Binh Thuong");
    benhAn.setKetQua("Tot");
    benhAn.setTrangThai("Cho Kham");
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
      assertEquals(dsBenhAn.size(), 0);
  }
}
