/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author Cu Gau
 */
public interface IChiTietHoaDonServices {

    public void addChiTietHoaDon(ChiTietHoaDon cthd);

    public void updateChiTietHoaDon(ChiTietHoaDon cthd);

    public void updateChiTietHoaDon_Version1(ChiTietHoaDon cthd);

    public void deleteChiTietHoaDon(String key);

    public ChiTietHoaDon getListChiTietHoaDonByID(String key);

    public List<ChiTietHoaDon> getListChiTietHoaDon();

    public List<ChiTietHoaDon> getListChiTietHoaDonBySql(String sql, Object... args);

    public ChiTietHoaDon getListChiTietHoaDonByMaPhong(String key);

    public String getMaHDCTAuto();

    public ChiTietHoaDon checkTonTai(String key);
}
