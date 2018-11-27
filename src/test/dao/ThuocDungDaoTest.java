package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import model.Thuoc;
import model.ThuocDung;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.ThuocDungDao;

public class ThuocDungDaoTest {
  private ThuocDungDao thuocDungDao;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    thuocDungDao = new ThuocDungDao();
  }

  @After
  public void tearDown() throws SQLException {
    thuocDungDao = null;
  }

  @Test
  public void testGetDSThuocDungSuccess() {
    List<ThuocDung> dsThuoc = thuocDungDao.getDSThuoc(1);
    assertNotNull(dsThuoc);
    assertNotEquals(dsThuoc.size(), 0);
  }

  @Test
  public void testGetDSThuocDungFail() {
    List<ThuocDung> dsThuoc = thuocDungDao.getDSThuoc(999);
    assertEquals(dsThuoc.size(), 0);
  }

  @Test
  public void testAddThuocDungSuccess() {
    int benhAnID = 1;
    ThuocDung thuocDung = new ThuocDung();
    Thuoc thuoc = new Thuoc();
    thuoc.setId(1);
    thuocDung.setThuoc(thuoc);
    assertTrue(thuocDungDao.addThuocDung(thuocDung, benhAnID));
  }

  @Test
  public void testAddThuocDungFail() {
    int benhAnID = 999;
    ThuocDung thuocDung = new ThuocDung();
    Thuoc thuoc = new Thuoc();
    thuoc.setId(1);
    thuocDung.setThuoc(thuoc);
    assertFalse(thuocDungDao.addThuocDung(thuocDung, benhAnID));
  }

  @Test
  public void testDeleteThuocDungSuccess() {
    assertTrue(thuocDungDao.deleteThuocDung(14));
  }

  @Test
  public void testDeleteThuocDungFail() {
    assertFalse(thuocDungDao.deleteThuocDung(999));
  }
}
