/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.DichVu;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface IDichVuServices {

    public void addDichVu(DichVu lp);

    public void updateDichVu(DichVu lp);

    public void deleteDichVu(String key);

    public DichVu getListDichVuByID(String key);

    public List<DichVu> getListDichVu();

    public List<DichVu> getListDichVuBySql(String sql, Object... args);

    public List<DichVu> selectbyKeyword(String keyword);

    public List<DichVu> getListDichVuByMaLoaiDichVu(String key);

    public List<DichVu> getListDichVuByTenDichVu(String key);

}
