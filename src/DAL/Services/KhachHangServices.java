package DAL.Services;

import DAL.Entities.KhachHang;
import DAL.IServices.IKhachHangSevices;
import DAL.DatabaseContext.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangServices implements IKhachHangSevices {

    String insert_Sql = "INSERT INTO KhachHang(MaKhachHang,TenKhachHang,Tuoi,GioiTinh,SoDienThoai,SoCCCD,GhiChu) VALUES(?,?,?,?,?,?,?)";
    String update_Sql = "UPDATE KhachHang SET TenKhachHang =?, Tuoi =?, GioiTinh =?, SoDienThoai =?, SoCCCD =?, GhiChu=? WHERE MaKhachHang=?";
    String delete_Sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
    String selectAll_Sql = "SELECT * FROM KhachHang";
    String selectById_Sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";

    @Override
    public void addKhachHang(KhachHang kh) {
        try {
            Connection.update(insert_Sql, kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getTuoi(), kh.isGioiTinh(), kh.getSoDienThoai(), kh.getSoCCCD(), kh.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void updateKhachHang(KhachHang kh) {
        try {
            Connection.update(update_Sql, kh.getTenKhachHang(), kh.getTuoi(), kh.isGioiTinh(), kh.getSoDienThoai(), kh.getSoCCCD(), kh.getGhiChu(), kh.getMaKhachHang());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void deteleKhachHang(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang getListKhachHangByID(String key) {
        List<KhachHang> list = this.getListKhachHangBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> getListKhachHang() {
        return this.getListKhachHangBySql(selectAll_Sql);
    }

    @Override
    public List<KhachHang> getListKhachHangBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("MaKhachHang"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setTuoi(rs.getInt("Tuoi"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setSoCCCD(rs.getString("SoCCCD"));
                kh.setGhiChu(rs.getString("GhiChu"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhachHang> selectbyKeyword(String keyword) {
        String sql = "SELECT *FROM KhachHang WHERE MaKhachHang LIKE ?";
        return this.getListKhachHangBySql(sql, "%" + keyword + "%");
    }

    @Override
    public String getMaKHAuto() {
        try {
            ResultSet rs = Connection.query("{CALL sp_MaKHAuto}");
            String maKH = "";
            while (rs.next()) {
                maKH = rs.getString("MaKhachHang");
            }
            rs.getStatement().getConnection().close();
            return maKH;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
