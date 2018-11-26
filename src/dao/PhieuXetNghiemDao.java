package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Buong;
import model.PhieuXetNghiem;
import model.XetNghiem;

public class PhieuXetNghiemDao {

    Connection connection;

    public boolean addPhieuXetNghiem(PhieuXetNghiem phieuXetNghiem, int benhAnId) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO `tbl_phieuxetnghiem` VALUES (NULL, ?, ?, ?, ?)");
            ps.setInt(1, phieuXetNghiem.getBuong().getId());
            ps.setInt(2, benhAnId);
            ps.setInt(3, phieuXetNghiem.getXetNghiem().getId());
            ps.setString(4, phieuXetNghiem.getKetQua());
            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deletePhieuXetNghiem(int id) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection
                    .prepareStatement("DELETE FROM `tbl_phieuxetnghiem` WHERE `id`=?");
            ps.setInt(1, id);
            int count  = ps.executeUpdate();
            if(count == 0)
            	return false;
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public List<PhieuXetNghiem> getDsPhieuXetNghiem(int benhAnId) {
        PreparedStatement stmt;
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            stmt = connection
                    .prepareStatement("SELECT * FROM `tbl_phieuxetnghiem` WHERE `tbl_phieuxetnghiem`.`BenhAnID`=" + benhAnId);
            ResultSet rs = stmt.executeQuery();
            List<PhieuXetNghiem> dsPhieuXetNghiem = new ArrayList<>();
            while (rs.next()) {
                PhieuXetNghiem phieuXetNghiem = extractTFromResultSet(rs);
                dsPhieuXetNghiem.add(phieuXetNghiem);
            }
            stmt.close();
            return dsPhieuXetNghiem;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private PhieuXetNghiem extractTFromResultSet(ResultSet rs) throws SQLException {
        PhieuXetNghiem phieuXetNghiem = new PhieuXetNghiem();
        phieuXetNghiem.setBuong(new Buong());
        phieuXetNghiem.setId(rs.getInt("ID"));
        phieuXetNghiem.setKetQua(rs.getString("KetQua"));
        phieuXetNghiem.setXetNghiem(new XetNghiem());
        return phieuXetNghiem;
    }
}
