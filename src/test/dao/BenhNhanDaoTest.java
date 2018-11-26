package test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import model.BenhNhan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BenhNhanDao;

public class BenhNhanDaoTest {
  private BenhNhanDao benhNhanDao;

  // Chạy trước test. setup trước.
  @Before
  public void setUp() {
    benhNhanDao = new BenhNhanDao();
  }

  // Chạy sau khi test. -> đỡ tốn tài nguyên <Khi không dùng đến>.
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
