package DAL.IServices;

import DAL.Entities.NhanVien;
import java.util.List;

public interface INhanVienServices {

    public void addNhanVien(NhanVien nv);

    public void updateNhanVien(NhanVien nv);
    
    public void convert(NhanVien nv);

    public void deleteNhanVien(String key);

    public NhanVien getListNhanVienByID(String key);

    public List<NhanVien> getListNhanVien();

    public List<NhanVien> getListNhanVienBySql(String sql, Object... args);

    public List<NhanVien> selectbyKeyword(String keyword);
}
