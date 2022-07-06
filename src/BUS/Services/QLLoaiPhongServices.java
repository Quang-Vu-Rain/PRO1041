package BUS.Services;

import DAL.Entities.LoaiPhong;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BUS.IServices.IQLLoaiPhongServices;
import DAL.IServices.ILoaiPhongServices;
import DAL.Services.LoaiPhongServices;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QLLoaiPhongServices implements IQLLoaiPhongServices {

    ILoaiPhongServices _loaiPhong = new LoaiPhongServices();

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<LoaiPhong> list = _loaiPhong.getListLoaiPhong();
            for (LoaiPhong lp : list) {
                Object[] row = {lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getGiaTheoGio(), lp.getGiaTheoNgay()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void add(JTextField maLoaiPhong, JTextField tenLoaiPhong, JTextField giaTheoGio, JTextField giaTheoNgay) {
        LoaiPhong lp = new LoaiPhong();
        lp.setTenLoaiPhong(tenLoaiPhong.getText().toString());
        lp.setMaLoaiPhong(maLoaiPhong.getText().toString());
        lp.setGiaTheoGio(Integer.valueOf(giaTheoGio.getText().toString()));
        lp.setGiaTheoNgay(Integer.valueOf(giaTheoNgay.getText().toString()));
        _loaiPhong.addLoaiPhong(lp);
    }

    @Override
    public void edit(JTextField maLoaiPhong, JTextField tenLoaiPhong, JTextField giaTheoGio, JTextField giaTheoNgay) {
        LoaiPhong lp = new LoaiPhong();
        lp.setTenLoaiPhong(tenLoaiPhong.getText().toString());
        lp.setMaLoaiPhong(maLoaiPhong.getText().toString());
        lp.setGiaTheoGio(Integer.valueOf(giaTheoGio.getText().toString()));
        lp.setGiaTheoNgay(Integer.valueOf(giaTheoNgay.getText().toString()));
        _loaiPhong.updateLoaiPhong(lp);
    }

    @Override
    public void delete(JTextField maLoaiPhong) {
        _loaiPhong.deleteLoaiPhong(maLoaiPhong.getText().toString());
    }

}
