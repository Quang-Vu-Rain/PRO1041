/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.LoaiDichVu;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ILoaiDichVuServices {
      public void addLoaiDichVu(LoaiDichVu lp);

    public void updateLoaiDichVu(LoaiDichVu lp);

    public void deleteLoaiDichVu(String key);

    public LoaiDichVu getListLoaiDichVuByID(String key);

    public List<LoaiDichVu> getListLoaiDichVu();

    public List<LoaiDichVu> getListLoaiDichVuBySql(String sql, Object... args);
    
}
