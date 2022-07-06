package DAL.IServices;

import DAL.Entities.LoaiHinhThue;
import java.util.List;

public interface ILoaiHinhThueServices {

    public void addLoaiHinhThue(LoaiHinhThue lht);

    public void updateLoaiHinhThue(LoaiHinhThue lht);

    public void deleteLoaiHinhThue(String key);

    public LoaiHinhThue getListLoaiHinhThueByID(String key);

    public List<LoaiHinhThue> getListLoaiHinhThue();

    public List<LoaiHinhThue> getListLoaiHinhThueBySql(String sql, Object... args);
}
