package test.dao;

import test.dao.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BenhNhanDao;
import model.BenhNhan;
import static org.junit.Assert.assertNull;

public class BenhNhanDaoTest {
  private BenhNhanDao benhNhanDao;

  @Before
  public void setUp() {
    benhNhanDao = new BenhNhanDao();
  }

  @After
  public void tearDown() {
    benhNhanDao = null;
  }

  @Test
  public void testGetBenhNhanSuccess() {
    BenhNhan benhNhan = benhNhanDao.getBenhNhanByBenhAn(1);
    assertNotNull(benhNhan);
  }
    
  @Test
  public void testGetBenhNhanFail() {
    BenhNhan benhNhan = benhNhanDao.getBenhNhanByBenhAn(999);
    assertNull(benhNhan);
  }

}
