package dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import model.Buong;

public class BuongDao {
        
    Connection connection;

    public Buong getBuongbyPXN(int phieuXNID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT * FROM `tbl_buong`,`tbl_phieuxetnghiem`"
                            + "where `tbl_buong`.`ID` = `tbl_phieuxetnghiem`.`BuongID` "
                            + "and `tbl_phieuxetnghiem`.`ID` =" + phieuXNID);
            Buong buong = null;
            if (rs.next()) {
                buong = extractTFromResultSet(rs);
            }
            stmt.close();
            return buong;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Buong> getDSBuongXN(int xetNghiemId) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `tbl_buong`,`tbl_buong_xetnghiem`"
                    + "where `tbl_buong`.`ID` = `tbl_buong_xetnghiem`.`BuongID` "
                    + "and `tbl_buong_xetnghiem`.`XetNghiemID` =" + xetNghiemId);
            ResultSet rs = ps.executeQuery();
            List<Buong> dsBuong = new ArrayList<>();
            while (rs.next()) {
                Buong buong = extractTFromResultSet(rs);
                dsBuong.add(buong);
            }
            ps.close();
            return dsBuong;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Buong extractTFromResultSet(ResultSet rs) throws SQLException {
        Buong buongXN = new Buong();
        buongXN.setId(rs.getInt("ID"));
        buongXN.setLoai(rs.getString("Loai"));
        buongXN.setTen(rs.getString("Ten"));
        buongXN.setViTri(rs.getString("ViTri"));
        return buongXN;
    }
}
