package DAL.Services;

import DAL.Entities.LoaiPhong;
import DAL.IServices.ILoaiPhongServices;
import java.util.List;
import DAL.DatabaseContext.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaiPhongServices implements ILoaiPhongServices {

    String insert_Sql = "INSERT INTO LoaiPhong(MaLoaiPhong, TenLoaiPhong, GiaTheoGio, GiaTheoNgay) VALUES(?, ?, ?, ?)";
    String update_Sql = "UPDATE LoaiPhong SET TenLoaiPhong = ?, GiaTheoGio = ?, GiaTheoNgay = ? WHERE MaLoaiPhong = ?";
    String delete_Sql = "DELETE FROM LoaiPhong WHERE MaLoaiPhong = ?";
    String selectAll_Sql = "SELECT * FROM LoaiPhong";
    String selectById_Sql = "SELECT * FROM LoaiPhong WHERE MaLoaiPhong = ?";

    @Override
    public void addLoaiPhong(LoaiPhong lp) {
        try {
            Connection.update(insert_Sql, lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getGiaTheoGio(), lp.getGiaTheoNgay());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateLoaiPhong(LoaiPhong lp) {
        try {
            Connection.update(update_Sql, lp.getTenLoaiPhong(), lp.getGiaTheoGio(), lp.getGiaTheoNgay(), lp.getMaLoaiPhong());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteLoaiPhong(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LoaiPhong getListLoaiPhongByID(String key) {
        List<LoaiPhong> list = this.getListLoaiPhongBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiPhong> getListLoaiPhong() {
        return this.getListLoaiPhongBySql(selectAll_Sql);
    }

    @Override
    public List<LoaiPhong> getListLoaiPhongBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong();
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                lp.setGiaTheoGio(rs.getInt("GiaTheoGio"));
                lp.setGiaTheoNgay(rs.getInt("GiaTheoNgay"));
                list.add(lp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
