/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.ChiTietDichVu;
import java.util.List;

/**
 *
 * @author Cu Gau
 */
public interface IChiTietDichVuServices {

    public void addChiTietDichVu(ChiTietDichVu ctdv);

    public void updateChiTietDichVu(ChiTietDichVu ctdv);

    public void deleteChiTietDichVu(String key);

    public ChiTietDichVu getListChiTietDichVuByID(String key);

    public List<ChiTietDichVu> getListChiTietDichVu();

    public List<ChiTietDichVu> getListChiTietDichVuBySql(String sql, Object... args);

    public List<ChiTietDichVu> getListChiTietDichVuByMaHoaDonChiTiet(String key);

    public String getMaCTDVAuto();

    public ChiTietDichVu checkDichVu(String maHDCT, String maLoaiDichVu);

    public void updateSoLuong(ChiTietDichVu ctdv);
}
