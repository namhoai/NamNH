package test.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import model.XetNghiem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.XetNghiemDao;

public class XetNghiemDaoTest {

    private XetNghiemDao xetNghiemDao;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        xetNghiemDao = new XetNghiemDao();
    }

    @After
    public void tearDown() throws SQLException {
        xetNghiemDao = null;
    }

    @Test
    public void testGetDSXetNghiem() {
        List<XetNghiem> dsXetNghiem = xetNghiemDao.getDSXetNghiem();
        assertNotNull(dsXetNghiem);
        assertNotEquals(dsXetNghiem.size(), 0);
    }

    @Test
    public void testGetXetNghiemSuccess() {
        XetNghiem xetNghiem = xetNghiemDao.getXetNghiemByPXN(4);
        assertNotNull(xetNghiem);
    }

    @Test
    public void testGetXetNghiemFail() {
        XetNghiem xetNghiem = xetNghiemDao.getXetNghiemByPXN(999);
        assertNull(xetNghiem);
    }
}
