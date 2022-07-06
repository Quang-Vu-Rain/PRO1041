

package BUS.Services;

import BUS.IServices.IQLKhachHangServices;
import DAL.Entities.KhachHang;
import DAL.IServices.IKhachHangSevices;
import DAL.Services.KhachHangServices;
import java.util.List;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLKhachHangServices implements IQLKhachHangServices{
    IKhachHangSevices _listKhach = new KhachHangServices();

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = _listKhach.getListKhachHang();
            for (KhachHang kh : list) {
                Object[] row = {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getTuoi(),kh.isGioiTinh()?"Nam":"Nữ",kh.getSoDienThoai(),kh.getSoCCCD(),kh.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add(JTextField maKhachHang, JTextField tenKhachHang, JTextField tuoiKhachHang, JRadioButton gioiTinh, JTextField sdt, JTextField cccd, JTextArea ghiChu) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang.getText().toString());
        kh.setTenKhachHang(tenKhachHang.getText().toString());
        kh.setTuoi(Integer.parseInt(tuoiKhachHang.getText()));
        kh.setGioiTinh(gioiTinh.isSelected());
        kh.setSoDienThoai(sdt.getText().toString());
        kh.setSoCCCD(cccd.getText().toString());
        kh.setGhiChu(ghiChu.getText().toString());
        _listKhach.addKhachHang(kh);
    }

    @Override
    public void edit(JTextField maKhachHang, JTextField tenKhachHang, JTextField tuoiKhachHang, JRadioButton gioiTinh, JTextField sdt, JTextField cccd, JTextArea ghiChu) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(maKhachHang.getText().toString());
        kh.setTenKhachHang(tenKhachHang.getText().toString());
        kh.setTuoi(Integer.parseInt(tuoiKhachHang.getText()));
        kh.setGioiTinh(gioiTinh.isSelected());
        kh.setSoDienThoai(sdt.getText().toString());
        kh.setSoCCCD(cccd.getText().toString());
        kh.setGhiChu(ghiChu.getText().toString());
        _listKhach.updateKhachHang(kh);
    }

    @Override
    public void delete(JTextField maKhachHang) {
        _listKhach.deteleKhachHang(maKhachHang.getText().toString());
    }

    @Override
    public void filltoSearch(JTable tb, JTextField maNhanVien) {
                DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = _listKhach.selectbyKeyword(maNhanVien.getText().toString());
            for (KhachHang kh : list) {
                Object[] row = {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getTuoi(),kh.isGioiTinh()?"Nam":"Nữ",kh.getSoDienThoai(),kh.getSoCCCD(),kh.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
   

}
