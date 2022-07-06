package BUS.Services;

import BUS.IServices.IQLLoaiDichVuServices;
import DAL.Entities.KhachHang;
import DAL.Entities.LoaiDichVu;
import DAL.IServices.ILoaiDichVuServices;
import DAL.Services.LoaiDichVuServices;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLLoaiDichVuServices implements IQLLoaiDichVuServices {

    ILoaiDichVuServices _lstLoaiDV = new LoaiDichVuServices();

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<LoaiDichVu> list = _lstLoaiDV.getListLoaiDichVu();
            for (LoaiDichVu ldv : list) {
                Object[] row = {ldv.getMaLoaiDichVu(), ldv.getTenLoaiDichVu(), ldv.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(JTextField maLoaiDichVu, JTextField tenLoaiDichVu, JTextArea ghiChu) {
       LoaiDichVu ldv = new LoaiDichVu();
       ldv.setMaLoaiDichVu(maLoaiDichVu.getText().toString());
       ldv.setTenLoaiDichVu(tenLoaiDichVu.getText().toString());
       ldv.setGhiChu(ghiChu.getText().toString());
       _lstLoaiDV.addLoaiDichVu(ldv);
    }

    @Override
    public void edit(JTextField maLoaiDichVu, JTextField tenLoaiDichVu, JTextArea ghiChu) {
       LoaiDichVu ldv = new LoaiDichVu();
       ldv.setMaLoaiDichVu(maLoaiDichVu.getText().toString());
       ldv.setTenLoaiDichVu(tenLoaiDichVu.getText().toString());
       ldv.setGhiChu(ghiChu.getText().toString());
       _lstLoaiDV.updateLoaiDichVu(ldv);
    }

    @Override
    public void delete(JTextField maLoaiDichVu) {
       _lstLoaiDV.deleteLoaiDichVu(maLoaiDichVu.getText().toString());
    }

}
