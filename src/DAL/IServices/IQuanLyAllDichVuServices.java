
package DAL.IServices;

import BUS.Model.QuanLyAllDichVu;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQuanLyAllDichVuServices {
    public List<QuanLyAllDichVu> getListAllDichVu();
    
    public List<QuanLyAllDichVu> getListAllDichVuBySql(String sql, Object... args);
}
