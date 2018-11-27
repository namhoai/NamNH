package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.BenhNhan;

public class BenhNhanDao {

    Connection connection;

    // Lấy Thông tin bệnh nhân theo bệnh án "benhAnID"
    public BenhNhan getBenhNhanByBenhAn(int benhAnID) {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            BenhNhan benhNhan = null;
            ResultSet rs = stmt
                    .executeQuery("SELECT * FROM `tbl_benhnhan`,`tbl_benhan`"
                            + "where `tbl_benhnhan`.`ID` = `tbl_benhan`.`BenhNhanID`"
                            + "and `tbl_benhan`.`ID` = " + benhAnID);
            if (rs.next()) {
                benhNhan = extractTFromResultSet(rs);
            }
            stmt.close();
            return benhNhan;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private BenhNhan extractTFromResultSet(ResultSet rs) throws SQLException {
        BenhNhan bn = new BenhNhan();
        bn.setDiaChi(rs.getString("DiaChi"));
        bn.setId(rs.getInt("ID"));
        bn.setSDT(rs.getString("SDT"));
        bn.setTen(rs.getString("Ten"));
        bn.setTuoi(rs.getInt("Tuoi"));
        return bn;
    }
}
