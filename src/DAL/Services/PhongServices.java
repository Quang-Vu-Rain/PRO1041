package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.LoaiPhong;
import DAL.Entities.Phong;
import DAL.Entities.Phong;
import DAL.IServices.IPhongServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PhongServices implements IPhongServices {

    String insert_Sql = "INSERT INTO Phong VALUES(?, ?, ?, ?, ?)";
    String update_Sql = "UPDATE Phong SET MaLoaiPhong = ?, MaTang = ?, GhiChu = ?, TrangThai = ? WHERE MaPhong = ?";
    String update_TrangThai = "UPDATE Phong SET TrangThai = ? WHERE MaPhong = ?";
    String delete_Sql = "DELETE FROM Phong WHERE MaPhong = ?";
    String selectAll_Sql = "SELECT * FROM Phong";
    String selectById_Sql = "SELECT * FROM Phong WHERE MaPhong = ?";
    String checkPhong = "select * from Phong join HoaDonChiTiet on Phong.MaPhong = HoaDonChiTiet.MaPhong where HoaDonChiTiet.TrangThai = 1 And HoaDonChiTiet.MaPhong = ?";

    @Override
    public void addPhong(Phong p) {
        try {
            Connection.update(insert_Sql, p.getMaPhong(), p.getMaLoaiPhong(), p.getMaTang(), p.getGhiChu(), p.getTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePhong(Phong p) {
        try {
            Connection.update(update_Sql, p.getMaLoaiPhong(), p.getMaTang(), p.getGhiChu(), p.getTrangThai(), p.getMaPhong());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateTrangThai(int trangThai, String maPhong) {
        try {
            Connection.update(update_TrangThai, trangThai, maPhong);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePhong(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Phong getListPhongByID(String key) {
        List<Phong> list = this.getListPhongBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Phong checkPhong(String key) {
        List<Phong> list = this.getListPhongBySql(checkPhong, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Phong> getListPhong() {
        return this.getListPhongBySql(selectAll_Sql);
    }

    @Override
    public List<Phong> getListPhongBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getString("MaPhong"));
                p.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                p.setMaTang(rs.getString("MaTang"));
                p.setGhiChu(rs.getString("GhiChu"));
                p.setTrangThai(rs.getInt("TrangThai"));
                list.add(p);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMaPhongAuto(String kyHieu) {
        try {
            ResultSet rs = Connection.query("{CALL sp_MaPhong(?)}", kyHieu);
            String maPhong = "";
            while (rs.next()) {
                maPhong = rs.getString("MaPhong");
            }
            rs.getStatement().getConnection().close();
            return maPhong;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
