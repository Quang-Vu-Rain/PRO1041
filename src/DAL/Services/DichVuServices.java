/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.DichVu;
import DAL.Entities.DichVu;
import DAL.Entities.DichVu;
import DAL.IServices.IDichVuServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class DichVuServices implements IDichVuServices {

    String insert_Sql = "INSERT INTO DichVu(MaDichVu, MaLoaiDichVu, TenDichVu, DonGia, GhiChu) VALUES(?, ?, ?, ?, ?)";
    String update_Sql = "UPDATE DichVu SET MaLoaiDichVu =?, TenDichVu = ?, DonGia = ?, GhiChu = ? WHERE MaDichVu = ?";
    String delete_Sql = "DELETE FROM DichVu WHERE MaDichVu = ?";
    String selectAll_Sql = "SELECT * FROM DichVu";
    String selectById_Sql = "SELECT * FROM DichVu WHERE MaDichVu = ?";
    String selectByMaLoaiDichVu_Sql = "SELECT * FROM DichVu WHERE MaLoaiDichVu = ?";
    String selectByTenDichVu_Sql = "select * from DichVu where TenDichVu like ?";

    @Override
    public void addDichVu(DichVu lp) {
        try {
            Connection.update(insert_Sql, lp.getMaDichVu(), lp.getMaLoaiDichVu(), lp.getTenDichVu(), lp.getDonGia(), lp.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDichVu(DichVu lp) {
        try {
            Connection.update(update_Sql, lp.getMaLoaiDichVu(), lp.getTenDichVu(), lp.getDonGia(), lp.getGhiChu(), lp.getMaDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(DichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteDichVu(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(DichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DichVu getListDichVuByID(String key) {
        List<DichVu> list = this.getListDichVuBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DichVu> getListDichVu() {
        return this.getListDichVuBySql(selectAll_Sql);
    }

    @Override
    public List<DichVu> getListDichVuByMaLoaiDichVu(String key) {
        return this.getListDichVuBySql(selectByMaLoaiDichVu_Sql, key);
    }

    @Override
    public List<DichVu> getListDichVuByTenDichVu(String key) {
        return this.getListDichVuBySql(selectByTenDichVu_Sql, "%" + key + "%");
    }

    @Override
    public List<DichVu> getListDichVuBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                DichVu lp = new DichVu();
                lp.setMaDichVu(rs.getString("MaDichVu"));
                lp.setMaLoaiDichVu(rs.getString("MaLoaiDichVu"));
                lp.setTenDichVu(rs.getString("TenDichVu"));
                lp.setDonGia(rs.getInt("DonGia"));
                lp.setGhiChu(rs.getString("GhiChu"));
                list.add(lp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DichVu> selectbyKeyword(String keyword) {
        String sql = "SELECT *FROM DichVu WHERE MaDichVu LIKE ?";
        return this.getListDichVuBySql(sql, "%" + keyword + "%");
    }

}
