package DAL.IServices;

import DAL.Entities.LoaiPhong;
import java.util.List;

public interface ILoaiPhongServices {

    public void addLoaiPhong(LoaiPhong lp);

    public void updateLoaiPhong(LoaiPhong lp);

    public void deleteLoaiPhong(String key);

    public LoaiPhong getListLoaiPhongByID(String key);

    public List<LoaiPhong> getListLoaiPhong();

    public List<LoaiPhong> getListLoaiPhongBySql(String sql, Object... args);
}
