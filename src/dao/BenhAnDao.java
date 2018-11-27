package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BenhAn;
import model.BenhNhan;
import model.Buong;

public class BenhAnDao {

	Connection connection;

	public boolean updateBenhAn(BenhAn benhAn) {
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = connection
					.prepareStatement("UPDATE `tbl_benhan` SET `KetQua` = ?, `KhamLS` = ?, `TrangThai` = ? WHERE `tbl_benhan`.`ID` = ?");
			ps.setString(1, benhAn.getKetQua());
			ps.setString(2, benhAn.getKhamLS());
			ps.setString(3, benhAn.getTrangThai());
			ps.setInt(4, benhAn.getId());
                        // số lượng hàng được cập nhập.
			int rowCount = ps.executeUpdate();
			if (rowCount == 0)
				return false;
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public BenhAn getBenhAn(int id) {
		PreparedStatement stmt;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			stmt = connection
					.prepareStatement("SELECT * FROM `tbl_benhan` WHERE `ID`="
							+ id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extractTFromResultSet(rs);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

        // lấy danh sách các bệnh án đang chờ trong buồng khám "buongKhamID".
	public List<BenhAn> getDSBenhAn(int buongKhamID) {
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `tbl_benhan`"
					+ "where `tbl_benhan`.`TrangThai` = 'Cho Kham'"
					+ "and `tbl_benhan`.`BuongID` = " + buongKhamID);
			List<BenhAn> dsBenhAn = new ArrayList<>();
			while (rs.next()) {
				BenhAn benhAn = extractTFromResultSet(rs);
				dsBenhAn.add(benhAn);
			}
			stmt.close();
			return dsBenhAn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private BenhAn extractTFromResultSet(ResultSet rs) throws SQLException {
		BenhAn benhan = new BenhAn();
		benhan.setBenhNhan(new BenhNhan());
                benhan.setBuongKham(new Buong());
		benhan.setDonThuoc(new ArrayList<>());
		benhan.setDsPhieuXN(new ArrayList<>());
		benhan.setId(rs.getInt("ID"));
		benhan.setKetQua(rs.getString("KetQua"));
		benhan.setKhamLS(rs.getString("KhamLS"));
		benhan.setTrangThai(rs.getString("TrangThai"));
		return benhan;
	}
}
