package DAL.Services;

import BUS.Model.QuanLyAllDichVu;
import DAL.DatabaseContext.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DAL.IServices.IQuanLyAllDichVuServices;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QuanLyAllDichVuServices implements IQuanLyAllDichVuServices {

    String selectAll = "SELECT MaDichVu,TenLoaiDichVu,TenDichVu,DonGia,DichVu.GhiChu FROM LoaiDichVu join DichVu on LoaiDichVu.MaLoaiDichVu = DichVu.MaLoaiDichVu";

    @Override
    public List<QuanLyAllDichVu> getListAllDichVu() {
        return this.getListAllDichVuBySql(selectAll);
    }

    @Override
    public List<QuanLyAllDichVu> getListAllDichVuBySql(String sql, Object... args) {
        List<QuanLyAllDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                QuanLyAllDichVu dv = new QuanLyAllDichVu();
                dv.setMaDichVu(rs.getString("MaDichVu"));
                dv.setTenLoaiDichVu(rs.getString("TenLoaiDichVu"));
                dv.setTenDichVu(rs.getString("TenDichVu"));
                dv.setDonGia(rs.getInt("DonGia"));
                dv.setGhiChu(rs.getString("GhiChu"));
                list.add(dv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
