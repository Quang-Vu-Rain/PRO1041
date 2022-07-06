package DAL.IServices;

import BUS.Model.QuanLyPhongKhachSan;
import java.util.List;

public interface IQuanLyPhongKhachSanServices {

    public QuanLyPhongKhachSan getListPhongByID(String key);

    public List<QuanLyPhongKhachSan> getListPhong(int tang);

    public List<QuanLyPhongKhachSan> getListPhongTrangThai(int trangThai);

    public List<QuanLyPhongKhachSan> getListPhongTang_TrangThai(int tang, int trangThai);

    public List<QuanLyPhongKhachSan> getListPhongBySql(String sql, Object... args);
}
