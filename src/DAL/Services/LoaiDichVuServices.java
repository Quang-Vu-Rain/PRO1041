/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.LoaiDichVu;
import DAL.Entities.LoaiDichVu;
import DAL.Entities.LoaiDichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.IServices.ILoaiDichVuServices;

/**
 *
 * @author ACER
 */
public class LoaiDichVuServices implements ILoaiDichVuServices {

    String insert_Sql = "INSERT INTO LoaiDichVu( MaLoaiDichVu, TenLoaiDichVu, GhiChu) VALUES(?, ?, ?)";
    String update_Sql = "UPDATE LoaiDichVu SET TenLoaiDichVu = ?, GhiChu = ? WHERE MaLoaiDichVu = ?";
    String delete_Sql = "DELETE FROM LoaiDichVu WHERE MaLoaiDichVu = ?";
    String selectAll_Sql = "SELECT * FROM LoaiDichVu";
    String selectById_Sql = "SELECT * FROM LoaiDichVu WHERE MaLoaiDichVu = ?";

    @Override
    public void addLoaiDichVu(LoaiDichVu lp) {
        try {
            Connection.update(insert_Sql, lp.getMaLoaiDichVu(), lp.getTenLoaiDichVu(), lp.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateLoaiDichVu(LoaiDichVu lp) {
        try {
            Connection.update(update_Sql, lp.getTenLoaiDichVu(), lp.getGhiChu(),lp.getMaLoaiDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteLoaiDichVu(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LoaiDichVu getListLoaiDichVuByID(String key) {
        List<LoaiDichVu> list = this.getListLoaiDichVuBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiDichVu> getListLoaiDichVu() {
        return this.getListLoaiDichVuBySql(selectAll_Sql);
    }

    @Override
    public List<LoaiDichVu> getListLoaiDichVuBySql(String sql, Object... args) {
        List<LoaiDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                LoaiDichVu lp = new LoaiDichVu();
                lp.setMaLoaiDichVu(rs.getString("MaLoaiDichVu"));
                lp.setTenLoaiDichVu(rs.getString("TenLoaiDichVu"));
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

}
