package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.IServices.IThongKeServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeServices implements IThongKeServices {

    @Override
    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Object[]> getDoanhThu() {
        String sql = "{CALL sp_DoanhThuTong}";
        String[] cols = {"SoLuongHoaDonThanhToan", "TongTienPhong", "TrungBinhTienPhong", "TongTienDichVu", "TrungBinhTienDichVu", "PhuThu", "TongTien", "HoaDonThapNhat", "HoaDonCaoNhat", "NgayThanhToan"};
        return this.getListOfArray(sql, cols);
    }

    @Override
    public List<Object[]> getDichVu() {
        String sql = "{CALL sp_TKDichVu}";
        String[] cols = {"TenDichVu", "TenLoaiDichVu", "SoLuong", "TongTien"};
        return this.getListOfArray(sql, cols);
    }

    @Override
    public List<Object[]> getDoanhThuTheoNgay(Date ngay) {
        String sql = "{CALL sp_DoanhThuTheoNgay(?)}";
        String[] cols = {"SoLuongHoaDonThanhToan", "TongTienPhong", "TrungBinhTienPhong", "TongTienDichVu", "TrungBinhTienDichVu", "PhuThu", "TongTien", "HoaDonThapNhat", "HoaDonCaoNhat", "NgayThanhToan"};
        return this.getListOfArray(sql, cols, ngay);
    }

    @Override
    public List<Object[]> getDoanhThuTheoKhoangNgay(Date ngayBatDau, Date ngayKetThuc) {
        String sql = "{CALL sp_DoanhThuTheoKhoangNgay(?, ?)}";
        String[] cols = {"SoLuongHoaDonThanhToan", "TongTienPhong", "TrungBinhTienPhong", "TongTienDichVu", "TrungBinhTienDichVu", "PhuThu", "TongTien", "HoaDonThapNhat", "HoaDonCaoNhat", "NgayThanhToan"};
        return this.getListOfArray(sql, cols, ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<Object[]> getDoanhThuTheoThang(String nam) {
        String sql = "{CALL sp_DoanhThuTheoThang(?)}";
        String[] cols = {"SoLuongHoaDonThanhToan", "TongTienPhong", "TrungBinhTienPhong", "TongTienDichVu", "TrungBinhTienDichVu", "PhuThu", "TongTien", "HoaDonThapNhat", "HoaDonCaoNhat", "ThoiGianThanhToan"};
        return this.getListOfArray(sql, cols, nam);
    }

    @Override
    public List<Object[]> getDoanhThuTheoNam() {
        String sql = "{CALL sp_DoanhThuTheoNam}";
        String[] cols = {"SoLuongHoaDonThanhToan", "TongTienPhong", "TrungBinhTienPhong", "TongTienDichVu", "TrungBinhTienDichVu", "PhuThu", "TongTien", "HoaDonThapNhat", "HoaDonCaoNhat", "ThoiGianThanhToan"};
        return this.getListOfArray(sql, cols);
    }
}
