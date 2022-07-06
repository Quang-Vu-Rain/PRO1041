package BUS.Services;

import BUS.IServices.IQLTangServices;
import DAL.Entities.Tang;
import DAL.IServices.ITangServices;
import DAL.Services.TangServices;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLTangServices implements IQLTangServices {

    ITangServices _tang = new TangServices();

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<Tang> list = _tang.getListTang();
            for (Tang tang : list) {
                Object[] row = {tang.getMaTang(), tang.getSoTang()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(JTextField maTang, JTextField soTang) {
        Tang tang = new Tang();
        tang.setMaTang(maTang.getText());
        tang.setSoTang(Integer.valueOf(soTang.getText()));
        _tang.addTang(tang);
    }

    @Override
    public void edit(JTextField maTang, JTextField soTang) {
        Tang tang = new Tang();
        tang.setMaTang(maTang.getText());
        tang.setSoTang(Integer.valueOf(soTang.getText()));
        _tang.updateTang(tang);
    }

    @Override
    public void delete(JTextField maTang) {
        _tang.deleteTang(maTang.getText().toString());
    }

}
