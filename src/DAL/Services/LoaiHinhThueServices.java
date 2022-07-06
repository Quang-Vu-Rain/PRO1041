package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.LoaiHinhThue;
import DAL.IServices.ILoaiHinhThueServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaiHinhThueServices implements ILoaiHinhThueServices {

    String insert_Sql = "INSERT INTO LoaiHinhThue(MaLoaiHinhThue, TenLoaiHinhThue) VALUES(?, ?)";
    String update_Sql = "UPDATE LoaiHinhThue SET TenLoaiHinhThue =? WHERE MaLoaiHinhThue=? ";
    String delete_Sql = "DELETE FROM LoaiHinhThue WHERE MaLoaiHinhThue = ?";
    String selectAll_Sql = "SELECT * FROM LoaiHinhThue";
    String selectById_Sql = "SELECT * FROM LoaiHinhThue WHERE MaLoaiHinhThue = ?";

    @Override
    public void addLoaiHinhThue(LoaiHinhThue lht) {
        try {
            Connection.update(insert_Sql, lht.getMaLoaiHinhThue(), lht.getTenLoaiHinhThue());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHinhThueServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateLoaiHinhThue(LoaiHinhThue lht) {
        try {
            Connection.update(insert_Sql, lht.getTenLoaiHinhThue(), lht.getMaLoaiHinhThue());
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHinhThueServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteLoaiHinhThue(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHinhThueServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LoaiHinhThue getListLoaiHinhThueByID(String key) {
        List<LoaiHinhThue> list = this.getListLoaiHinhThueBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiHinhThue> getListLoaiHinhThue() {
        return this.getListLoaiHinhThueBySql(selectAll_Sql);
    }

    @Override
    public List<LoaiHinhThue> getListLoaiHinhThueBySql(String sql, Object... args) {
        List<LoaiHinhThue> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                LoaiHinhThue lht = new LoaiHinhThue();
                lht.setMaLoaiHinhThue(rs.getString("MaLoaiHinhThue"));
                lht.setTenLoaiHinhThue(rs.getString("TenLoaiHinhThue"));
                list.add(lht);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
