/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.IServices;

import DAL.Entities.Tang;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface ITangServices {

    public void addTang(Tang t);

    public void updateTang(Tang t);

    public void deleteTang(String key);

    public Tang getListTangByID(String key);

    public List<Tang> getListTang();

    public List<Tang> getListTangBySql(String sql, Object... args);
}
