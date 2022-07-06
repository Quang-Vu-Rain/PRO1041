/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAL.IServices;

import BUS.Model.DichVu_Phong;
import DAL.Entities.ChiTietDichVu;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IDichVu_PhongServices {

    public void addChiTietDichVu(ChiTietDichVu ctdv);

    public void updateChiTietDichVu(ChiTietDichVu ctdv);

    public void deleteChiTietDichVu(String key);

    public ChiTietDichVu getListChiTietDichVuByID(String key);

    public List<DichVu_Phong> getListChiTietDichVu(String maHDCT);

    public List<DichVu_Phong> getListChiTietDichVuBySql(String sql, Object... args);

    public List<DichVu_Phong> getListChiTietDichVuByMaHoaDonChiTiet(String key);
}
