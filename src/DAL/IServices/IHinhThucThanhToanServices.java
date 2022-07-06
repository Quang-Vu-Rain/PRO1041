package DAL.IServices;

import DAL.Entities.HinhThucThanhToan;
import java.util.List;

public interface IHinhThucThanhToanServices {

    public void addHinhThucThanhToan(HinhThucThanhToan httt);

    public void updateHinhThucThanhToan(HinhThucThanhToan httt);

    public void deleteHinhThucThanhToan(String key);

    public HinhThucThanhToan getListHinhThucThanhToanByID(String key);

    public List<HinhThucThanhToan> getListHinhThucThanhToan();

    public List<HinhThucThanhToan> getListHinhThucThanhToanBySql(String sql, Object... args);
}
