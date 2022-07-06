
package DAL.IServices;

import BUS.Model.ThongTinThuePhong;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IThongTinThuePhongServices {
    public ThongTinThuePhong getListThongTinThuePhongByMaHoaDonChiTiet(String key);
    public List<ThongTinThuePhong> getListThongTinThuePhong(String sql, Object... args);
    public List<ThongTinThuePhong> getListThongTinThuePhongAll(String key);
}
