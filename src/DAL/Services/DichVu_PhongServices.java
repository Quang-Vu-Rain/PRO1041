/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Services;

import BUS.Model.DichVu_Phong;
import DAL.DatabaseContext.Connection;
import DAL.Entities.ChiTietDichVu;
import DAL.IServices.IDichVu_PhongServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DichVu_PhongServices implements IDichVu_PhongServices {

    String insert_Sql = "";
    String update_Sql = "";
    String delete_Sql = "";
    String selectAll_Sql = "select MaChiTietDichVu, MaPhong, TenLoaiDichVu, TenDichVu, DonGia, SoLuong from HoaDonChiTiet \n"
            + "join ChiTietDichVu on HoaDonChiTiet.MaHoaDonChiTiet = ChiTietDichVu.MaHoaDonChiTiet \n"
            + "join DichVu on ChiTietDichVu.MaDichVu = DichVu.MaDichVu \n"
            + "join LoaiDichVu on DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu \n"
            + "where HoaDonChiTiet.MaHoaDonChiTiet = ?";
    String selectById_Sql = "SELECT * FROM ChiTietDichVu WHERE MaChiTietDichVu = ?";

    @Override
    public void addChiTietDichVu(ChiTietDichVu ctdv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateChiTietDichVu(ChiTietDichVu ctdv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteChiTietDichVu(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChiTietDichVu getListChiTietDichVuByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DichVu_Phong> getListChiTietDichVu(String maHDCT) {
        return this.getListChiTietDichVuBySql(selectAll_Sql, maHDCT);
    }

    @Override
    public List<DichVu_Phong> getListChiTietDichVuBySql(String sql, Object... args) {
        List<DichVu_Phong> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                DichVu_Phong dvp = new DichVu_Phong();
                dvp.setMaChiTietDichVu(rs.getString("MaChiTietDichVu"));
                dvp.setMaPhong(rs.getString("MaPhong"));
                dvp.setTenLoaiDichVu(rs.getString("TenLoaiDichVu"));
                dvp.setTenDichVu(rs.getString("TenDichVu"));
                dvp.setSoLuong(rs.getInt("SoLuong"));
                dvp.setDonGia(rs.getInt("DonGia"));
                list.add(dvp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DichVu_Phong> getListChiTietDichVuByMaHoaDonChiTiet(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
