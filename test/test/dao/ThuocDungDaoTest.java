package test.dao;

import test.dao.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connection.ConnectionFactory;
import dao.ThuocDungDao;
import model.ThuocDung;

public class ThuocDungDaoTest {
  private ThuocDungDao thuocDungDao;
  private Connection connection;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    connection = ConnectionFactory.getInstance().getConnection();
    thuocDungDao = new ThuocDungDao();
  }

  @After
  public void tearDown() throws SQLException {
    thuocDungDao = null;
    connection.rollback();
    connection.close();
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
    assertNull(dsThuoc);
  }

  @Test
  public void testAddThuocDungSuccess() {
    int benhAnID = 10;
    ThuocDung thuocDung = new ThuocDung();
    assertTrue(thuocDungDao.addThuocDung(thuocDung, benhAnID));
  }

  @Test
  public void testAddThuocDungFail() {
    int benhAnID = 999;
    ThuocDung thuocDung = new ThuocDung();
    assertFalse(thuocDungDao.addThuocDung(thuocDung, benhAnID));
  }

  @Test
  public void testDeleteThuocDungSuccess() {
    assertTrue(thuocDungDao.deleteThuocDung(5));
  }

  @Test
  public void testDeleteThuocDungFail() {
    assertFalse(thuocDungDao.deleteThuocDung(999));
  }
}
