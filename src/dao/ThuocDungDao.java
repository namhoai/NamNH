package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.ThuocDung;

public class ThuocDungDao {

    Connection connection;

    public List<ThuocDung> getDSThuoc(int benhAnID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_thuocdung` WHERE `tbl_thuocdung`.`benhanID` = " + benhAnID);
            List<ThuocDung> dsThuocDung = new ArrayList<>();
            while (rs.next()) {
                ThuocDung thuocDung = extractTFromResultSet(rs);
                dsThuocDung.add(thuocDung);
            }
            stmt.close();
            return dsThuocDung;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private ThuocDung extractTFromResultSet(ResultSet rs) throws SQLException {
        ThuocDung thuocDung = new ThuocDung();
        thuocDung.setCachSD(rs.getString("CachSD"));
        thuocDung.setChiPhi(rs.getFloat("ChiPhi"));
        thuocDung.setId(rs.getInt("ID"));
        thuocDung.setSoLuong(rs.getInt("SoLuong"));
        return thuocDung;
    }

    public boolean addThuocDung(ThuocDung thuocDung, int benhAnID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO `tbl_thuocdung` VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setInt(1, benhAnID);
            ps.setInt(2, thuocDung.getThuoc().getId());
            ps.setInt(3, thuocDung.getSoLuong());
            ps.setFloat(4, thuocDung.getChiPhi());
            ps.setString(5, thuocDung.getCachSD());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteThuocDung(int id) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection
                    .prepareStatement("DELETE FROM `tbl_thuocdung` WHERE `id`=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if(count == 0)
            	return false;
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
