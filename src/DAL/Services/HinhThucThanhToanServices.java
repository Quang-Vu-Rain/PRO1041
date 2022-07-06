package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.HinhThucThanhToan;
import DAL.IServices.IHinhThucThanhToanServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HinhThucThanhToanServices implements IHinhThucThanhToanServices {

    String selectAll_Sql = "SELECT * FROM HinhThucThanhToan";
    String selectById_Sql = "SELECT * FROM HinhThucThanhToan WHERE MaHinhThucThanhToan = ?";

    @Override
    public void addHinhThucThanhToan(HinhThucThanhToan httt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateHinhThucThanhToan(HinhThucThanhToan httt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHinhThucThanhToan(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HinhThucThanhToan getListHinhThucThanhToanByID(String key) {
        List<HinhThucThanhToan> list = this.getListHinhThucThanhToanBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HinhThucThanhToan> getListHinhThucThanhToan() {
        return this.getListHinhThucThanhToanBySql(selectAll_Sql);
    }

    @Override
    public List<HinhThucThanhToan> getListHinhThucThanhToanBySql(String sql, Object... args) {
        List<HinhThucThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                HinhThucThanhToan httt = new HinhThucThanhToan();
                httt.setMaHinhThucThanhToan(rs.getString("MaHinhThucThanhToan"));
                httt.setTenHinhThucThanhToan(rs.getString("TenHinhThucThanhToan"));
                list.add(httt);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
