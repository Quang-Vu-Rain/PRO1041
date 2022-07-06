package BUS.Services;

import BUS.IServices.IQLDichVuPhongServices;
import DAL.Entities.ChiTietDichVu;
import DAL.Entities.ChiTietHoaDon;
import DAL.Entities.DichVu;
import DAL.Entities.LoaiDichVu;
import DAL.IServices.IChiTietDichVuServices;
import DAL.IServices.IChiTietHoaDonServices;
import DAL.IServices.IDichVuServices;
import DAL.IServices.ILoaiDichVuServices;
import DAL.Services.ChiTietDichVuServices;
import DAL.Services.ChiTietHoaDonServices;
import DAL.Services.DichVuServices;
import DAL.Services.LoaiDichVuServices;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QLDichVuPhongServices implements IQLDichVuPhongServices {

    ILoaiDichVuServices _iLoaiDichVu = new LoaiDichVuServices();
    IDichVuServices _iDichVu = new DichVuServices();
    IChiTietDichVuServices _iChiTietDichVu = new ChiTietDichVuServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();

    @Override
    public void fillLoaiDichVu(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<LoaiDichVu> list = _iLoaiDichVu.getListLoaiDichVu();
        for (LoaiDichVu ldv : list) {
            model.addElement(ldv);
        }
    }

    @Override
    public void fillDichVuPhong(JTable tb, String maPhong) {
        ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByMaPhong(maPhong);
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietDichVu> list = _iChiTietDichVu.getListChiTietDichVuByMaHoaDonChiTiet(cthd.getMaHoaDonChiTiet());
            for (ChiTietDichVu ctdv : list) {
                Object[] row = {ctdv};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillDichVu(JPanel pn, String maLoaiDichVu) {
        List<DichVu> _listDichVu = _iDichVu.getListDichVu();
        pn.removeAll();
        pn.updateUI();
        int _soLuong = 0;
        for (DichVu dv : _listDichVu) {
            if (dv.getMaLoaiDichVu().equals(maLoaiDichVu)) {
                _soLuong++;
            }
        }
        JButton[] btn = new JButton[_soLuong];
        for (DichVu dv : _listDichVu) {
            int i = 0;
            if (dv.getMaLoaiDichVu().equals(maLoaiDichVu)) {
                btn[i] = new javax.swing.JButton(dv.getTenDichVu());
                btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
                pn.add(btn[i]);
                pn.updateUI();
            }
            i++;
        }
    }

}
