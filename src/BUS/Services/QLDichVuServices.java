package BUS.Services;

import BUS.IServices.IQLDichVuServices;
import DAL.Entities.DichVu;
import DAL.Entities.KhachHang;
import DAL.Entities.LoaiDichVu;
import DAL.IServices.IDichVuServices;
import DAL.IServices.ILoaiDichVuServices;
import DAL.Services.DichVuServices;
import DAL.Services.LoaiDichVuServices;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLDichVuServices implements IQLDichVuServices {

    IDichVuServices _listDichVu = new DichVuServices();
    ILoaiDichVuServices _listLoaiDichVu = new LoaiDichVuServices();

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<DichVu> list = _listDichVu.getListDichVu();
            for (DichVu dv : list) {
                Object[] row = {dv.getMaDichVu(), dv.getMaLoaiDichVu(), dv.getTenDichVu(), dv.getDonGia(), dv.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(JTextField maDichVu, JComboBox maLoaiDichVu, JTextField tenDichVu, JTextField donGia, JTextArea ghiChu) {
        DichVu dv = new DichVu();
        LoaiDichVu ldv = (LoaiDichVu) maLoaiDichVu.getSelectedItem();
        dv.setMaDichVu(maDichVu.getText().toString());
        List<LoaiDichVu> list = _listLoaiDichVu.getListLoaiDichVu();
        for (int i = 0; i < list.size(); i++) {
            if (maLoaiDichVu.getModel().getSelectedItem().toString().equals(list.get(i).getTenLoaiDichVu())) {
                dv.setMaLoaiDichVu(list.get(i).getMaLoaiDichVu());
            }
        }
        dv.setTenDichVu(tenDichVu.getText().toString());
        dv.setDonGia(Integer.parseInt(donGia.getText().toString()));
        dv.setGhiChu(ghiChu.getText().toString());
        _listDichVu.addDichVu(dv);

    }

    @Override
    public void edit(JComboBox tenLoaiDichVu, JTextField tenDichVu, JTextField donGia, JTextArea ghiChu, JTextField maDichVu) {
        DichVu dv = new DichVu();
        List<LoaiDichVu> list = _listLoaiDichVu.getListLoaiDichVu();
        for (int i = 0; i < list.size(); i++) {
            if (tenLoaiDichVu.getModel().getSelectedItem().toString().equals(list.get(i).getTenLoaiDichVu())) {
                dv.setMaLoaiDichVu(list.get(i).getMaLoaiDichVu());
            }
        }
        dv.setMaDichVu(maDichVu.getText().toString());
        dv.setTenDichVu(tenDichVu.getText().toString());
        dv.setDonGia(Integer.parseInt(donGia.getText().toString()));
        dv.setGhiChu(ghiChu.getText().toString());
        _listDichVu.updateDichVu(dv);
    }

    @Override
    public void delete(JTextField maDichVu) {
        _listDichVu.deleteDichVu(maDichVu.getText().toString());
    }

    @Override
    public void filltoCombo(JComboBox idloai) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) idloai.getModel();
        model.removeAllElements();
        List<LoaiDichVu> list = _listLoaiDichVu.getListLoaiDichVu();
        for (LoaiDichVu ldv : list) {
            model.addElement(ldv);
        }
    }

    @Override
    public void filltoSearch(JTable tb, JTextField maDichVu) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<DichVu> list = _listDichVu.selectbyKeyword(maDichVu.getText().toString());
            for (DichVu dv : list) {
                Object[] row = {dv.getMaDichVu(), dv.getMaLoaiDichVu(), dv.getTenDichVu(), dv.getDonGia(), dv.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
