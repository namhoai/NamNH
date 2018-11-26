/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import model.Buong;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BuongDao;

/**
 *
 * @author HoaiNam
 */
public class BuongDaoTest {
  private BuongDao buongDao;

  @Before
  public void setUp() {
    buongDao = new BuongDao();
  }

  @After
  public void tearDown() {
    buongDao = null;
  }
  
  @Test
  public void testGetBuongByPXNSuccess(){
      Buong buong = buongDao.getBuongbyPXN(4);
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
      assertNotEquals(dsBuong.size(), 0);
  }
  
  @Test
  public void testGetDSBuongByXNFail(){
      List<Buong> dsBuong = buongDao.getDSBuongXN(999);
      assertEquals(dsBuong.size(),0);
  }
}
