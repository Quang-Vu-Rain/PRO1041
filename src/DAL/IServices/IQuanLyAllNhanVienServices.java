
package DAL.IServices;

import BUS.Model.QuanLyAllNhanVien;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQuanLyAllNhanVienServices {
     public List<QuanLyAllNhanVien> getListAllNhanVien();
    
    public List<QuanLyAllNhanVien> getListAllNhanVienBySql(String sql, Object... args);   
}
