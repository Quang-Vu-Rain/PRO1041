
package DAL.IServices;

import DAL.Entities.Quyen;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQuyenServices {
    public void addQuyen(Quyen q);

    public void updateQuyen(Quyen t);

    public void deleteQuyen(String key);

    public Quyen getListTangByID(String key);

    public List<Quyen> getListQuyen();

    public List<Quyen> getListQuyenBySql(String sql, Object... args);
}
