package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.GiaoCa;
import DAL.IServices.IGiaoCaServices;
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
public class GiaoCaServices implements IGiaoCaServices {

    String insert_Sql = "INSERT INTO GiaoCa(MaGiaoCa,MaNhanVien,TienDauCaNhan, TongTienThe, TongTienMat,TienPhatsinh,TienChenhLech,TongDoanhThuCa,SoTienThucGiao,"
            + "GioNhanCa,GioGiaoCa,GhiChu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    String updateStt_Sql = "UPDATE GiaoCa SET TongTienThe = 0,TongTienMat=0,TienDauCaNhan = 0 WHERE MaGiaoCa = ?";
    String convert_Sql = "UPDATE GiaoCa SET TienDauCaNhan = ?,TongTienThe = ?, TongTienMat = ?,TienPhatsinh =?, TienChenhLech = ? ,GhiChu = ? WHERE MaGiaoCa = ?";
    String update_tiendauca = "UPDATE GIAOCA SET TienDauCaNhan = ?";
    String selectAll_Sql = "SELECT * FROM GiaoCa";
    String selectById_Sql = "SELECT * FROM GiaoCa WHERE MaGiaoCa =?";

    @Override
    public void updateSttNhanVien(GiaoCa gc) {
        try {
            Connection.update(updateStt_Sql, gc.getManv());
        } catch (SQLException ex) {
            Logger.getLogger(GiaoCaServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void convert(GiaoCa gc) {
        try {
            Connection.update(convert_Sql, gc.getGhichu(), gc.getManv());

        } catch (SQLException ex) {
            Logger.getLogger(GiaoCaServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public GiaoCa getListGiaoCaByID(String key) {
        List<GiaoCa> list = this.getListGiaoCaBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GiaoCa> getListGiaoCa() {
        return this.getListGiaoCaBySql(selectAll_Sql);
    }

    @Override
    public List<GiaoCa> getListGiaoCaBySql(String sql, Object... args) {
        List<GiaoCa> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                GiaoCa gc = new GiaoCa();
                gc.setMagiaoca(rs.getString("MaGiaoCa"));
                gc.setManv(rs.getString("MaNhanVien"));
                gc.setTiendaucanhan(rs.getInt("TienDauCaNhan"));
                gc.setTongtienthe(rs.getInt("TongTienThe"));
                gc.setTongtienmat(rs.getInt("TongTienMat"));
                gc.setGionhanca(rs.getString("GioNhanCa"));
                gc.setGiogiaoca(rs.getString("GioGiaoCa"));
                gc.setTienphatsinh(rs.getInt("TienPhatsinh"));
                gc.setTienchenhlech(rs.getInt("TienChenhLech"));
                gc.setTongdoanhthuca(rs.getInt("TongDoanhThuCa"));
                gc.setSotienthucgiao(rs.getInt("SoTienThucGiao"));
                gc.setGhichu(rs.getString("GhiChu"));
                list.add(gc);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GiaoCa> selectbyKeyword(String keyword) {
        String sql = "SELECT *FROM GiaoCa WHERE MaNhanVien LIKE ?";
        return this.getListGiaoCaBySql(sql, "%" + keyword + "%");
    }

    @Override
    public void addGiaoCa(GiaoCa gc) {
        try {

            Connection.update(insert_Sql, gc.getMagiaoca(), gc.getManv(), gc.getTiendaucanhan(), gc.getTongtienthe(), gc.getTongtienmat(),
                    gc.getTienphatsinh(),gc.getTienchenhlech(),gc.getTongdoanhthuca(),gc.getSotienthucgiao(),gc.getGionhanca(),
                    gc.getGiogiaoca(), gc.getGhichu());
        } catch (SQLException ex) {
            Logger.getLogger(GiaoCaServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTiendauca(GiaoCa gc) {
        try {
            Connection.update(update_tiendauca, gc.getTiendaucanhan());
        } catch (SQLException ex) {
            Logger.getLogger(GiaoCaServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
