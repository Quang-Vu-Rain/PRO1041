/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.Phong;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IPhongServices {

    public void addPhong(Phong p);

    public void updatePhong(Phong p);

    public void updateTrangThai(int trangThai, String maPhong);

    public void deletePhong(String key);

    public Phong getListPhongByID(String key);

    public List<Phong> getListPhong();

    public List<Phong> getListPhongBySql(String sql, Object... args);

    public String getMaPhongAuto(String kyHieu);

    public Phong checkPhong(String key);
}
