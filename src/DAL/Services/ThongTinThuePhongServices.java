/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Services;

import BUS.Model.ThongTinThuePhong;
import DAL.DatabaseContext.Connection;
import DAL.IServices.IThongTinThuePhongServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ThongTinThuePhongServices implements IThongTinThuePhongServices {

    String selectByMaHoaDonChiTiet_Sql = "select MaHoaDonChiTiet, HoaDonChiTiet.MaPhong, NgayThue, NgayDuKienTra, NgayTraPhong, TienDatCoc, TenLoaiHinhThue, GiaTheoGio, GiaTheoNgay, TenKhachHang, HoaDonChiTiet.TrangThai from HoaDonChiTiet\n"
            + "join LoaiHinhThue on HoaDonChiTiet.MaLoaiHinhThue = LoaiHinhThue.MaLoaiHinhThue\n"
            + "join Phong on HoaDonChiTiet.MaPhong = Phong.MaPhong\n"
            + "join LoaiPhong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong\n"
            + "join HoaDon on HoaDon.MaHoaDon = HoaDonChiTiet.MaHoaDon\n"
            + "join KhachHang on HoaDon.MaKhachHang = KhachHang.MaKhachHang\n"
            + "where (HoaDonChiTiet.TrangThai = 1 OR HoaDonChiTiet.TrangThai = 2) and HoaDonChiTiet.MaPhong = ? order by MaHoaDonChiTiet ASC";

    @Override
    public ThongTinThuePhong getListThongTinThuePhongByMaHoaDonChiTiet(String key) {
        List<ThongTinThuePhong> list = this.getListThongTinThuePhong(selectByMaHoaDonChiTiet_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThongTinThuePhong> getListThongTinThuePhongAll(String key) {
        return this.getListThongTinThuePhong(selectByMaHoaDonChiTiet_Sql, key);
    }

    @Override
    public List<ThongTinThuePhong> getListThongTinThuePhong(String sql, Object... args) {
        List<ThongTinThuePhong> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                ThongTinThuePhong tttp = new ThongTinThuePhong();
                tttp.setMaHoaDonChiTiet(rs.getString("MaHoaDonChiTiet"));
                tttp.setMaPhong(rs.getString("MaPhong"));
                tttp.setTenKhachHang(rs.getString("TenKhachHang"));
                tttp.setTenLoaiHinhThue(rs.getString("TenLoaiHinhThue"));
                tttp.setTienDatCoc(rs.getInt("TienDatCoc"));
                tttp.setGiaTheoGio(rs.getInt("GiaTheoGio"));
                tttp.setGiaTheoNgay(rs.getInt("GiaTheoNgay"));
                tttp.setNgayThue(rs.getTimestamp("NgayThue"));
                tttp.setNgayTraDuKien(rs.getTimestamp("NgayDuKienTra"));
                tttp.setNgayTraPhong(rs.getTimestamp("NgayTraPhong"));
                tttp.setTrangThai(rs.getInt("TrangThai"));
                list.add(tttp);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
