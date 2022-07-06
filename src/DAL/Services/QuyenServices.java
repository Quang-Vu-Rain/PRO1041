/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.Quyen;
import DAL.IServices.IQuyenServices;
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
public class QuyenServices implements IQuyenServices {

    String insert_Sql = "INSERT INTO Quyen VALUES(?, ?)";
    String update_Sql = "UPDATE Quyen SET TenQuyen = ? WHERE MaQuyen = ?";
    String delete_Sql = "DELETE FROM Quyen WHERE MaQuyen = ?";
    String selectAll_Sql = "SELECT * FROM Quyen";
    String selectById_Sql = "SELECT * FROM Quyen WHERE MaQuyen = ?";

    @Override
    public void addQuyen(Quyen q) {
        try {
            Connection.update(insert_Sql, q.getMaQuyen(), q.getTenQuyen());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateQuyen(Quyen q) {
        try {
            Connection.update(update_Sql, q.getTenQuyen(), q.getMaQuyen());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteQuyen(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Quyen getListTangByID(String key) {
        List<Quyen> list = this.getListQuyenBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Quyen> getListQuyen() {
        return this.getListQuyenBySql(selectAll_Sql);
    }

    @Override
    public List<Quyen> getListQuyenBySql(String sql, Object... args) {
        List<Quyen> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                Quyen q = new Quyen();
                q.setMaQuyen(rs.getString("MaQuyen"));
                q.setTenQuyen(rs.getString("TenQuyen"));
                list.add(q);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
