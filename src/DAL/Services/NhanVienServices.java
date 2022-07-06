package DAL.Services;

import DAL.Entities.NhanVien;
import DAL.IServices.INhanVienServices;
import DAL.DatabaseContext.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienServices implements INhanVienServices {

    String insert_Sql = "INSERT INTO NhanVien(MaNhanVien,TenNhanVien, MatKhau, MaQuyen,Email,GhiChu) VALUES (?,?,?,?,?,?)";
    String update_Sql = "UPDATE NhanVien SET TenNhanVien = ?, MatKhau = ? , MaQuyen = ?,Email = ?,GhiChu = ? WHERE MaNhanVien = ?";

    String convert_Sql = "UPDATE GiaoCa SET TienDauCaNhan = ?,TongTienThe = ?, TongTienMat = ? ,GhiChu = ? WHERE MaGiaoCa = ?";
    String delete_Sql = "DELETE FROM NhanVien WHERE MaNhanVien =?";
    String selectAll_Sql = "SELECT * FROM NhanVien";
    String selectById_Sql = "SELECT * FROM NhanVien WHERE MaNhanVien =?";

    @Override
    public void addNhanVien(NhanVien nv) {
        try {

            Connection.update(insert_Sql, nv.getMaNhanVien(), nv.getTennv(), nv.getMaKhau(), nv.getMaQuyen(), nv.getEmail(), nv.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateNhanVien(NhanVien nv) {
        try {
            Connection.update(update_Sql, nv.getTennv(), nv.getMaKhau(), nv.getMaQuyen(), nv.getEmail(), nv.getGhiChu(), nv.getMaNhanVien());

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void deleteNhanVien(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public NhanVien getListNhanVienByID(String key) {
        List<NhanVien> list = this.getListNhanVienBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> getListNhanVien() {
        return this.getListNhanVienBySql(selectAll_Sql);
    }

    @Override
    public List<NhanVien> getListNhanVienBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("MaNhanVien"));
                nv.setTennv(rs.getString("TenNhanVien"));
                nv.setMaKhau(rs.getString("MatKhau"));
                nv.setMaQuyen(rs.getString("MaQuyen"));
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

    @Override
    public List<NhanVien> selectbyKeyword(String keyword) {
        String sql = "SELECT *FROM NhanVien WHERE MaNhanVien LIKE ?";
        return this.getListNhanVienBySql(sql, "%" + keyword + "%");
    }

    @Override
    public void convert(NhanVien nv) {
        try {
            Connection.update(convert_Sql, nv.getGhiChu(), nv.getMaNhanVien());

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
