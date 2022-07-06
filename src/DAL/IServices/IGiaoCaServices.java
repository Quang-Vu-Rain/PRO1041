package DAL.IServices;

import DAL.Entities.GiaoCa;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IGiaoCaServices {
    
    public void addGiaoCa(GiaoCa gc);

    public void updateSttNhanVien(GiaoCa gc);
    
    public void setTiendauca(GiaoCa gc);

    public void convert(GiaoCa gc);

    public GiaoCa getListGiaoCaByID(String key);

    public List<GiaoCa> getListGiaoCa();

    public List<GiaoCa> getListGiaoCaBySql(String sql, Object... args);

    public List<GiaoCa> selectbyKeyword(String keyword);
}
