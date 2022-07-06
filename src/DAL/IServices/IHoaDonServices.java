/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.HoaDon;
import java.util.List;

/**
 *
 * @author Cu Gau
 */
public interface IHoaDonServices {

    public void addHoaDon(HoaDon hd);

    public void updateHoaDon(HoaDon hd);

    public void updateTrangThai(HoaDon hd);

    public void deleteHoaDon(String key);

    public HoaDon getListHoaDonByID(String key);

    public List<HoaDon> getListHoaDon();

    public List<HoaDon> getListHoaDonBySql(String sql, Object... args);

    public String getMaHDAuto();

    public HoaDon getListHoaDonByMaKH(String key);
}
