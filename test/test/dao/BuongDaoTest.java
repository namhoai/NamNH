/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import test.dao.*;
import connection.ConnectionFactory;
import dao.BuongDao;
import dao.PhieuXetNghiemDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Buong;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author HoaiNam
 */
public class BuongDaoTest {
  private BuongDao buongDao;
  private Connection connection;

  @Before
  public void setUp() throws ClassNotFoundException, SQLException {
    connection = ConnectionFactory.getInstance().getConnection();
    buongDao = new BuongDao();
  }

  @After
  public void tearDown() throws SQLException {
    buongDao = null;
    connection.rollback();
    connection.close();
  }
  
  @Test
  public void testGetBuongByPXNSuccess(){
      Buong buong = buongDao.getBuongbyPXN(1);
      assertNotNull(buong);
  }
  
  @Test
  public void testGetBuongByPXNFail(){
      Buong buong = buongDao.getBuongbyPXN(999);
      assertNull(buong);
  }
  
  @Test
  public void testGetDSBuongByXNSuccess(){
      List<Buong> dsBuong = buongDao.getDSBuongXN(1);
      assertNotNull(dsBuong);
      assertEquals(dsBuong.size(), 0);
  }
  
  @Test
  public void testGetDSBuongByXNFail(){
      List<Buong> dsBuong = buongDao.getDSBuongXN(999);
      assertNull(dsBuong);
  }
}
