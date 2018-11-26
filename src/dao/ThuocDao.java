package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Thuoc;

public class ThuocDao {

    Connection connection;

    public List<Thuoc> getDSThuoc() {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_thuoc`");
            List<Thuoc> dsThuoc = new ArrayList<>();
            while (rs.next()) {
                Thuoc thuoc = extractTFromResultSet(rs);
                dsThuoc.add(thuoc);
            }
            stmt.close();
            return dsThuoc;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Thuoc getThuocByTD(int thuocDungID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_thuoc`, `tbl_thuocdung`"
                    + " where `tbl_thuoc`.ID = `tbl_thuocdung`.`ThuocID`"
                    + " and `tbl_thuocdung`.`ID`=" + thuocDungID);
            Thuoc thuoc = null;
            if (rs.next()) {
                thuoc = extractTFromResultSet(rs);
            }
            stmt.close();
            return thuoc;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Thuoc extractTFromResultSet(ResultSet rs) throws SQLException {
        Thuoc thuoc = new Thuoc();
        thuoc.setId(rs.getInt("ID"));
        thuoc.setTen(rs.getString("Ten"));
        thuoc.setMoTa(rs.getString("MoTa"));
        thuoc.setMa(rs.getString("Ma"));
        thuoc.setNhaSX(rs.getString("NhaSX"));
        thuoc.setGia(rs.getFloat("Gia"));
        return thuoc;
    }
}
