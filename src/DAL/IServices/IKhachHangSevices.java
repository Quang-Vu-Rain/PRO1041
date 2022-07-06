package DAL.IServices;

import DAL.Entities.KhachHang;
import java.util.List;

public interface IKhachHangSevices {

    public void addKhachHang(KhachHang kh);

    public void updateKhachHang(KhachHang kh);

    public void deteleKhachHang(String key);

    public KhachHang getListKhachHangByID(String key);

    public List<KhachHang> getListKhachHang();

    public List<KhachHang> getListKhachHangBySql(String sql, Object... args);

    public List<KhachHang> selectbyKeyword(String keyword);

    public String getMaKHAuto();
}
