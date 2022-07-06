/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.Phong;
import DAL.Entities.Tang;
import DAL.IServices.ITangServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TangServices implements ITangServices {

    String insert_Sql = "INSERT INTO Tang VALUES(?, ?)";
    String update_Sql = "UPDATE Phong SET SoTang = ? WHERE MaTang = ?";
    String delete_Sql = "DELETE FROM Tang WHERE MaTang = ?";
    String selectAll_Sql = "SELECT * FROM Tang Order By SoTang ASC";
    String selectById_Sql = "SELECT * FROM Tang WHERE MaTang = ?";

    @Override
    public void addTang(Tang t) {
        try {
            Connection.update(insert_Sql, t.getMaTang(), t.getSoTang());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateTang(Tang t) {
        try {
            Connection.update(update_Sql, t.getSoTang(), t.getMaTang());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteTang(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Tang getListTangByID(String key) {
        List<Tang> list = this.getListTangBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Tang> getListTang() {
        return this.getListTangBySql(selectAll_Sql);
    }

    @Override
    public List<Tang> getListTangBySql(String sql, Object... args) {
        List<Tang> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                Tang t = new Tang();
                t.setMaTang(rs.getString("MaTang"));
                t.setSoTang(rs.getInt("SoTang"));
                list.add(t);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
