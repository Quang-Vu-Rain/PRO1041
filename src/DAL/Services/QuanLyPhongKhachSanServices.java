package DAL.Services;

import BUS.Model.QuanLyPhongKhachSan;
import DAL.DatabaseContext.Connection;
import DAL.IServices.IQuanLyPhongKhachSanServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyPhongKhachSanServices implements IQuanLyPhongKhachSanServices {

    String selectAll_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang where (TrangThai = 1 or TrangThai = 2 or TrangThai = 3) and SoTang = ?";
    String selectById_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang WHERE MaPhong = ?";
    String selectTang_TrangThai_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang where SoTang = ? and TrangThai = ?";
    String selectTrangThai_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang where TrangThai = ?";

    @Override
    public QuanLyPhongKhachSan getListPhongByID(String key) {
        List<QuanLyPhongKhachSan> list = this.getListPhongBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhong(int tang) {
        return this.getListPhongBySql(selectAll_Sql, tang);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhongTang_TrangThai(int tang, int trangThai) {
        return this.getListPhongBySql(selectTang_TrangThai_Sql, tang, trangThai);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhongTrangThai(int trangThai) {
        return this.getListPhongBySql(selectTrangThai_Sql, trangThai);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhongBySql(String sql, Object... args) {
        List<QuanLyPhongKhachSan> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                QuanLyPhongKhachSan p = new QuanLyPhongKhachSan();
                p.setMaPhong(rs.getString("MaPhong"));
                p.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                p.setSoTang(rs.getInt("SoTang"));
                p.setGiaTheoGio(rs.getInt("GiaTheoGio"));
                p.setGiaTheoNgay(rs.getInt("GiaTheoNgay"));
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

}
