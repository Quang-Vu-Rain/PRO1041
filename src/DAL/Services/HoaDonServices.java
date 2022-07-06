/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.HoaDon;
import DAL.IServices.IHoaDonServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cu Gau
 */
public class HoaDonServices implements IHoaDonServices {

    String insert_Sql = "INSERT INTO HoaDon(MaHoaDon, MaKhachHang, SoNguoi,MaNhanVien, TrangThai) VALUES(?,?,?,?,?) ";
    String update_Sql = "UPDATE HoaDon SET MaKhachHang = ?, SoNguoi = ?,MaNhanVien = ?, TrangThai = ? WHERE MaHoaDon = ?";
    String delete_Sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
    String selectAll_Sql = "SELECT * FROM HoaDon";
    String selectById_Sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
    String selectByMaKH_Sql = "SELECT * FROM HoaDon WHERE TrangThai = 1 and MaKhachHang = ?";
    String updateTrangThai = "UPDATE HoaDon SET TrangThai = ? WHERE MaHoaDon = ?";

    @Override
    public void addHoaDon(HoaDon hd) {
        try {
            Connection.update(insert_Sql, hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getSoNguoi(), hd.getMaNhanVien(), hd.isTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateHoaDon(HoaDon hd) {
        try {
            Connection.update(update_Sql, hd.getMaKhachHang(), hd.getSoNguoi(), hd.getMaNhanVien(), hd.isTrangThai(), hd.getMaHoaDon());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateTrangThai(HoaDon hd) {
        try {
            Connection.update(updateTrangThai, hd.isTrangThai(), hd.getMaHoaDon());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteHoaDon(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HoaDon getListHoaDonByID(String key) {
        List<HoaDon> list = this.getListHoaDonBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public HoaDon getListHoaDonByMaKH(String key) {
        List<HoaDon> list = this.getListHoaDonBySql(selectByMaKH_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> getListHoaDon() {
        return this.getListHoaDonBySql(selectAll_Sql);
    }

    @Override
    public List<HoaDon> getListHoaDonBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                hd.setSoNguoi(rs.getInt("SoNguoi"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMaHDAuto() {
        try {
            ResultSet rs = Connection.query("{CALL sp_HoaDonAuto}");
            String maHD = "";
            while (rs.next()) {
                maHD = rs.getString("HoaDonAuto");
            }
            rs.getStatement().getConnection().close();
            return maHD;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
