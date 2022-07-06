package DAL.IServices;

import DAL.Entities.GiaTriKhac;
import java.util.List;

public interface IGiaTriKhacServices {

    public void addGiaTriKhac(GiaTriKhac gtk);

    public void updateGiaTriKhac(GiaTriKhac gtk);

    public void deleteGiaTriKhac(String key);

    public GiaTriKhac getListGiaTriKhacByID(String key);

    public List<GiaTriKhac> getListGiaTriKhac();

    public List<GiaTriKhac> getListGiaTriKhacBySql(String sql, Object... args);

    public GiaTriKhac getThoiGianCheckIn();
}
