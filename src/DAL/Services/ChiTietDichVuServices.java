package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.ChiTietDichVu;
import DAL.IServices.IChiTietDichVuServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietDichVuServices implements IChiTietDichVuServices {

    String insert_Sql = "INSERT INTO ChiTietDichVu(MaChiTietDichVu, MaHoaDonChiTiet, MaDichVu, SoLuong) VALUES(?, ?, ?, ?)";
    String update_Sql = "UPDATE ChiTietDichVu SET MaHoaDonChiTiet = ?, MaDichVu =?, SoLuong = ? WHERE MaChiTietDichVu = ?";
    String delete_Sql = "DELETE FROM ChiTietDichVu WHERE MaChiTietDichVu = ?";
    String selectAll_Sql = "SELECT * FROM ChiTietDichVu";
    String selectById_Sql = "SELECT * FROM ChiTietDichVu WHERE MaChiTietDichVu = ?";
    String checkDichVu = "select * from ChiTietDichVu where MaHoaDonChiTiet = ? and MaDichVu = ?";
    String updateSoLuong = "UPDATE ChiTietDichVu SET SoLuong = ? WHERE MaChiTietDichVu = ?";

    @Override
    public void addChiTietDichVu(ChiTietDichVu ctdv) {
        try {
            Connection.update(insert_Sql, ctdv.getMaChiTietDichVu(), ctdv.getMaHoaDonChiTiet(), ctdv.getMaDichVu(), ctdv.getSoLuong());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateChiTietDichVu(ChiTietDichVu ctdv) {
        try {
            Connection.update(update_Sql, ctdv.getMaHoaDonChiTiet(), ctdv.getMaDichVu(), ctdv.getSoLuong(), ctdv.getMaChiTietDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateSoLuong(ChiTietDichVu ctdv) {
        try {
            Connection.update(updateSoLuong, ctdv.getSoLuong(), ctdv.getMaChiTietDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteChiTietDichVu(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietDichVu getListChiTietDichVuByID(String key) {
        List<ChiTietDichVu> list = this.getListChiTietDichVuBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public ChiTietDichVu checkDichVu(String maHDCT, String maLoaiDichVu) {
        List<ChiTietDichVu> list = this.getListChiTietDichVuBySql(checkDichVu, maHDCT, maLoaiDichVu);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVuByMaHoaDonChiTiet(String key) {
        String selectByMaHoaDonChiTiet_Sql = "SELECT * FROM ChiTietDichVu WHERE MaHoaDonChiTiet = " + key;
        return this.getListChiTietDichVuBySql(selectByMaHoaDonChiTiet_Sql);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVu() {
        return this.getListChiTietDichVuBySql(selectAll_Sql);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVuBySql(String sql, Object... args) {
        List<ChiTietDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                ChiTietDichVu ctdv = new ChiTietDichVu();
                ctdv.setMaChiTietDichVu(rs.getString("MaChiTietDichVu"));
                ctdv.setMaHoaDonChiTiet(rs.getString("MaHoaDonChitiet"));
                ctdv.setMaDichVu(rs.getString("MaDichVu"));
                ctdv.setSoLuong(rs.getInt("SoLuong"));
                list.add(ctdv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMaCTDVAuto() {
        try {
            ResultSet rs = Connection.query("{CALL sp_ChiTietDichVuAuto}");
            String maHD = "";
            while (rs.next()) {
                maHD = rs.getString("ChiTietDichVuAuto");
            }
            rs.getStatement().getConnection().close();
            return maHD;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
