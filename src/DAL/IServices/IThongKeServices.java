package DAL.IServices;

import java.util.Date;
import java.util.List;

public interface IThongKeServices {

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args);

    public List<Object[]> getDoanhThu();
    public List<Object[]> getDichVu();
    public List<Object[]> getDoanhThuTheoNgay(Date ngay);
    public List<Object[]> getDoanhThuTheoKhoangNgay(Date ngayBatDau, Date ngayKetThuc);
    public List<Object[]> getDoanhThuTheoThang(String nam);
    public List<Object[]> getDoanhThuTheoNam();
}
