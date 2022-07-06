package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.ChiTietHoaDon;
import DAL.IServices.IChiTietHoaDonServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDonServices implements IChiTietHoaDonServices {

    String insert_Sql = "INSERT INTO HoaDonChiTiet(MaHoaDonChiTiet, MaPhong , MaHoaDon, MaLoaiHinhThue, NgayThue, TienDatCoc, NgayDuKienTra , MaHinhThucThanhToan, PhuThuCheckIn, PhuThuCheckOut, TongTienPhong, TongTienDichVu, TienTheNganHang, TienKhachDua, TienTraLai ,NgayTraPhong , NgayThanhToan, TrangThai, GhiChu) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String update_Sql = "UPDATE HoaDonChiTiet SET MaPhong = ?, MaHoaDon = ? , MaLoaiHinhThue = ?, NgayThue = ?, TienDatCoc = ?, NgayDuKienTra = ? , MaHinhThucThanhToan = ?, PhuThuCheckIn = ?, PhuThuCheckOut = ?, TongTienPhong = ?, TongTienDichVu = ?, TienTheNganHang = ?, TienKhachDua = ?, TienTraLai = ?, NgayTraPhong = ?, NgayThanhToan = ?, TrangThai = ?, GhiChu = ? WHERE MaHoaDonChiTiet = ?";
    String update_Version1 = "UPDATE HoaDonChiTiet SET MaLoaiHinhThue = ?, NgayThue = ?, NgayDuKienTra = ? WHERE MaHoaDonChiTiet = ?";
    String delete_Sql = "DELETE FROM HoaDonChiTiet WHERE MaHoaDonChiTiet = ?";
    String selectAll_Sql = "SELECT * FROM HoaDonChiTiet";
    String selectById_Sql = "SELECT * FROM HoaDonChiTiet WHERE MaHoaDonChiTiet = ?";
    String selectByMaPhong_Sql = "SELECT * FROM HoaDonChiTiet WHERE (TrangThai = 1 OR TrangThai = 2) and MaPhong = ? order by MaHoaDonChiTiet ASC";
    String selectByMaHoaDon_Sql = "SELECT * FROM HoaDonChiTiet WHERE (TrangThai = 1 OR TrangThai = 2) and MaHoaDon = ?";

    @Override
    public void addChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
            Connection.update(insert_Sql, cthd.getMaHoaDonChiTiet(), cthd.getMaPhong(), cthd.getMaHoaDon(), cthd.getMaLoaiHinhThue(), cthd.getNgayThue(), cthd.getTienDatCoc(), cthd.getNgayDuKienTra(), cthd.getMaHinhThucThanhToan(), cthd.getPhuThuCheckIn(), cthd.getPhuThuCheckOut(), cthd.getTongTienPhong(), cthd.getTongTienDichVu(), cthd.getTienTheNganHang(), cthd.getTienKhachDua(), cthd.getTienTraLai(), cthd.getNgayTraPhong(), cthd.getNgayThanhToan(), cthd.getTrangThai(), cthd.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
            Connection.update(update_Sql, cthd.getMaPhong(), cthd.getMaHoaDon(), cthd.getMaLoaiHinhThue(), cthd.getNgayThue(), cthd.getTienDatCoc(), cthd.getNgayDuKienTra(), cthd.getMaHinhThucThanhToan(), cthd.getPhuThuCheckIn(), cthd.getPhuThuCheckOut(), cthd.getTongTienPhong(), cthd.getTongTienDichVu(), cthd.getTienTheNganHang(), cthd.getTienKhachDua(), cthd.getTienTraLai(), cthd.getNgayTraPhong(), cthd.getNgayThanhToan(), cthd.getTrangThai(), cthd.getGhiChu(), cthd.getMaHoaDonChiTiet());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteChiTietHoaDon(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietHoaDon getListChiTietHoaDonByID(String key) {
        List<ChiTietHoaDon> list = this.getListChiTietHoaDonBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public ChiTietHoaDon checkTonTai(String key) {
        List<ChiTietHoaDon> list = this.getListChiTietHoaDonBySql(selectByMaHoaDon_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public ChiTietHoaDon getListChiTietHoaDonByMaPhong(String key) {
        List<ChiTietHoaDon> list = this.getListChiTietHoaDonBySql(selectByMaPhong_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietHoaDon> getListChiTietHoaDon() {
        return this.getListChiTietHoaDonBySql(selectAll_Sql);
    }

    @Override
    public List<ChiTietHoaDon> getListChiTietHoaDonBySql(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHoaDonChiTiet(rs.getString("MaHoaDonChiTiet"));
                cthd.setMaPhong(rs.getString("MaPhong"));
                cthd.setMaHoaDon(rs.getString("MaHoaDon"));
                cthd.setMaLoaiHinhThue(rs.getString("MaLoaiHinhThue"));
                cthd.setNgayThue(rs.getTimestamp("NgayThue"));
                cthd.setTienDatCoc(rs.getInt("TienDatCoc"));
                cthd.setNgayDuKienTra(rs.getTimestamp("NgayDuKienTra"));
                cthd.setMaHinhThucThanhToan(rs.getString("MaHinhThucThanhToan"));
                cthd.setPhuThuCheckIn(rs.getInt("PhuThuCheckIn"));
                cthd.setPhuThuCheckOut(rs.getInt("PhuThuCheckOut"));
                cthd.setTongTienPhong(rs.getInt("TongTienPhong"));
                cthd.setTongTienDichVu(rs.getInt("TongTienDichVu"));
                cthd.setTienTheNganHang(rs.getInt("TienTheNganHang"));
                cthd.setTienKhachDua(rs.getInt("TienKhachDua"));
                cthd.setTienTraLai(rs.getInt("TienTraLai"));
                cthd.setNgayTraPhong(rs.getTimestamp("NgayTraPhong"));
                cthd.setNgayThanhToan(rs.getTimestamp("NgayThanhToan"));
                cthd.setTrangThai(rs.getInt("TrangThai"));
                list.add(cthd);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMaHDCTAuto() {
        try {
            ResultSet rs = Connection.query("{CALL sp_HoaDonChiTietAuto}");
            String maHD = "";
            while (rs.next()) {
                maHD = rs.getString("HoaDonChiTietAuto");
            }
            rs.getStatement().getConnection().close();
            return maHD;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateChiTietHoaDon_Version1(ChiTietHoaDon cthd) {
        try {
            Connection.update(update_Version1, cthd.getMaLoaiHinhThue(), cthd.getNgayThue(), cthd.getNgayDuKienTra(), cthd.getMaHoaDonChiTiet());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
