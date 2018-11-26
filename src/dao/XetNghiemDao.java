package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.XetNghiem;

public class XetNghiemDao {

    Connection connection;

    public XetNghiem getXetNghiemByPXN(int phieuXNID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_XetNghiem`, `tbl_PhieuXetNghiem`"
                    + " where `tbl_XetNghiem`.ID = `tbl_PhieuXetNghiem`.`XetNghiemID`"
                    + " and `tbl_PhieuXetNghiem`.`ID`=" + phieuXNID);
            XetNghiem xetNghiem = null;
            if (rs.next()) {
                xetNghiem = extractTFromResultSet(rs);
            }
            stmt.close();
            return xetNghiem;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<XetNghiem> getDSXetNghiem() {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_XetNghiem`");
            List<XetNghiem> dsXetNghiem = new ArrayList<>();
            while (rs.next()) {
                XetNghiem xetNghiem = extractTFromResultSet(rs);
                dsXetNghiem.add(xetNghiem);
            }
            stmt.close();
            return dsXetNghiem;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private XetNghiem extractTFromResultSet(ResultSet rs) throws SQLException {
        XetNghiem xn = new XetNghiem();
        xn.setChiPhi(rs.getFloat("ChiPhi"));
        xn.setId(rs.getInt("ID"));
        xn.setTen(rs.getString("Ten"));
        return xn;
    }
}
