/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author HoaiNam
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({test.dao.BenhAnDaoTest.class, test.dao.ThuocDungDaoTest.class, test.dao.ThuocDaoTest.class, test.dao.BuongDaoTest.class, test.dao.BenhNhanDaoTest.class, test.dao.PhieuXetNghiemDaoTest.class, test.dao.XetNghiemDaoTest.class})
public class DaoSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
