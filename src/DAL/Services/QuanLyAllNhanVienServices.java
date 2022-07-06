package DAL.Services;

import BUS.Model.QuanLyAllNhanVien;
import DAL.DatabaseContext.Connection;
import DAL.IServices.IQuanLyAllNhanVienServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QuanLyAllNhanVienServices implements IQuanLyAllNhanVienServices {

    String selectAll = "SELECT MaNhanVien,TenNhanVien,MatKhau,TenQuyen,Email,GhiChu FROM Quyen join NhanVien ON Quyen.MaQuyen = NhanVien.MaQuyen";

    @Override
    public List<QuanLyAllNhanVien> getListAllNhanVien() {
        return this.getListAllNhanVienBySql(selectAll);
    }

    @Override
    public List<QuanLyAllNhanVien> getListAllNhanVienBySql(String sql, Object... args) {
        List<QuanLyAllNhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                QuanLyAllNhanVien nv = new QuanLyAllNhanVien();
                nv.setMaNhanVien(rs.getString("MaNhanVien"));
                nv.setTennv(rs.getString("TenNhanVien"));
                nv.setMaKhau(rs.getString("MatKhau"));
                nv.setTenQuyen(rs.getString("TenQuyen"));
                nv.setEmail(rs.getString("Email"));
                nv.setGhiChu(rs.getString("GhiChu"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
