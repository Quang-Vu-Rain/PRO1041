package BUS.Services;

import BUS.Model.QuanLyAllDichVu;
import BUS.Model.QuanLyPhongKhachSan;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BUS.IServices.IQLAllDichVuServices;
import DAL.IServices.IQuanLyAllDichVuServices;
import DAL.Services.QuanLyAllDichVuServices;
import java.text.NumberFormat;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLAllDichVuServices implements IQLAllDichVuServices {

    IQuanLyAllDichVuServices _list = new QuanLyAllDichVuServices();

    @Override
    public void fillToTableLoaiDichVu(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            // NumberFormat cur = NumberFormat.getInstance();
            List<QuanLyAllDichVu> list = _list.getListAllDichVu();
            for (QuanLyAllDichVu dv : list) {
                Object[] row = {
                    dv.getMaDichVu(), dv.getTenLoaiDichVu(), dv.getTenDichVu(), dv.getDonGia(), dv.getGhiChu()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
