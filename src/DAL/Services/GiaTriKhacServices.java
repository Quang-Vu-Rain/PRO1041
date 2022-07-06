/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.GiaTriKhac;
import DAL.IServices.IGiaTriKhacServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GiaTriKhacServices implements IGiaTriKhacServices {

    String selectAll_Sql = "SELECT * FROM GiaTriKhac";
    String selectTGChckIn_Out_Sql = "SELECT * FROM GiaTriKhac where MaGiaTri = 'CheckTG'";
    String update = "UPDATE GiaTriKhac SET ThoiGianCheckIn =?, ThoiGianCheckOut =?, GiaTriCheckIn =?, GiaTriCheckOut =? WHERE MaGiaTri = 'CheckTG'";

    @Override
    public void addGiaTriKhac(GiaTriKhac gtk) {

    }

    @Override
    public void updateGiaTriKhac(GiaTriKhac gtk) {
        try {
            Connection.update(update, gtk.getThoiGianCheckIn(), gtk.getThoiGianCheckOut(), gtk.getGiaTriCheckIn(), gtk.getGiaTriCheckOut());
        } catch (SQLException ex) {
            Logger.getLogger(GiaTriKhacServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteGiaTriKhac(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GiaTriKhac getListGiaTriKhacByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GiaTriKhac> getListGiaTriKhac() {
        return this.getListGiaTriKhacBySql(selectAll_Sql);
    }

    @Override
    public GiaTriKhac getThoiGianCheckIn() {
        List<GiaTriKhac> list = this.getListGiaTriKhacBySql(selectTGChckIn_Out_Sql);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GiaTriKhac> getListGiaTriKhacBySql(String sql, Object... args) {
        List<GiaTriKhac> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                GiaTriKhac gtk = new GiaTriKhac();
                gtk.setMaGiaTri(rs.getString("MaGiaTri"));
                gtk.setThoiGianCheckIn(rs.getTime("ThoiGianCheckIn"));
                gtk.setThoiGianCheckOut(rs.getTime("ThoiGianCheckOut"));
                gtk.setGiaTriCheckIn(rs.getInt("GiaTriCheckIn"));
                gtk.setGiaTriCheckOut(rs.getInt("GiaTriCheckOut"));
                gtk.setMoTa(rs.getString("MoTa"));
                list.add(gtk);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
