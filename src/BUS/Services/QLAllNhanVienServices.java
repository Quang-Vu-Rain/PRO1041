package BUS.Services;

import BUS.IServices.IQLAllNhanVienServices;
import BUS.Model.QuanLyAllDichVu;
import BUS.Model.QuanLyAllNhanVien;
import DAL.IServices.IQuanLyAllNhanVienServices;
import DAL.Services.QuanLyAllNhanVienServices;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLAllNhanVienServices implements IQLAllNhanVienServices {
    
    IQuanLyAllNhanVienServices _list = new QuanLyAllNhanVienServices();

    @Override
    public void fillToTableMaQuyen(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            //  DecimalFormat df = new DecimalFormat("###,###.##");
          //  NumberFormat cur = NumberFormat.getInstance();
            List<QuanLyAllNhanVien> list = _list.getListAllNhanVien();
            for (QuanLyAllNhanVien nv : list) {
                Object[] row = {
                    nv.getMaNhanVien(), nv.getTennv(), nv.getMaKhau(), nv.getTenQuyen(), nv.getEmail(), nv.getGhiChu()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
}
