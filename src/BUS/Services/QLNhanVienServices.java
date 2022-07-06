package BUS.Services;

import BUS.IServices.IQLNhanVienServices;
import DAL.Entities.KhachHang;
import DAL.Entities.NhanVien;
import DAL.Entities.Quyen;
import DAL.IServices.INhanVienServices;
import DAL.IServices.IQuyenServices;
import DAL.Services.KhachHangServices;
import DAL.Services.NhanVienServices;
import DAL.Services.QuyenServices;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLNhanVienServices implements IQLNhanVienServices {

    INhanVienServices _listNhanVien = new NhanVienServices();
    IQuyenServices _iQuyen = new QuyenServices();
    ImageIcon iconTick = new ImageIcon("src\\PL\\Icon\\Tick.png");
    ImageIcon iconTrash = new ImageIcon("src\\PL\\Icon\\Trash.png");
    ImageIcon iconError = new ImageIcon("src\\PL\\Icon\\Problem.png");

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            //  DecimalFormat df = new DecimalFormat("###,###.##VND");
            List<NhanVien> list = _listNhanVien.getListNhanVien();
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNhanVien(), nv.getTennv(), nv.getMaKhau(), nv.getMaQuyen(), nv.getEmail(), nv.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(JTextField maNhanVien, JTextField tennv, JPasswordField matKhau, JComboBox quyen, JTextField email, JTextArea ghiChu) {
        NhanVien nv = new NhanVien();
        Quyen q = (Quyen) quyen.getSelectedItem();
        nv.setMaNhanVien(maNhanVien.getText().toString());
        nv.setTennv(tennv.getText().toString());
        nv.setMaKhau(matKhau.getText().toString());
        nv.setMaQuyen(q.getMaQuyen());
        nv.setEmail(email.getText().toString());
        nv.setGhiChu(ghiChu.getText().toString());
        _listNhanVien.addNhanVien(nv);
    }

    @Override
    public void edit(JTextField maNhanVien, JTextField tennv, JPasswordField matKhau, JComboBox quyen, JTextField email,JTextArea ghiChu) {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(maNhanVien.getText().toString());
        nv.setTennv(tennv.getText().toString());
        nv.setMaKhau(matKhau.getText().toString());
        List<Quyen> list = _iQuyen.getListQuyen();
        for (int i = 0; i < list.size(); i++) {
            if (quyen.getModel().getSelectedItem().toString().equals(list.get(i).getTenQuyen())) {
                nv.setMaQuyen(list.get(i).getMaQuyen());
            }
        }
        nv.setEmail(email.getText().toString());
        nv.setGhiChu(ghiChu.getText().toString());
        _listNhanVien.updateNhanVien(nv);
    }

    @Override
    public void delete(JTextField maNhanVien) {
        _listNhanVien.deleteNhanVien(maNhanVien.getText().toString());
    }

    @Override
    public void fillToCombo(JComboBox quyen) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) quyen.getModel();
        model.removeAllElements();
        List<Quyen> list = _iQuyen.getListQuyen();
        for (Quyen q : list) {
            model.addElement(q);
        }
    }

    @Override
    public void filltoSearch(JTable tb, JTextField maNhanVien) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = _listNhanVien.selectbyKeyword(maNhanVien.getText().toString());
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNhanVien(), nv.getTennv(), nv.getMaKhau(), nv.getMaQuyen(), nv.getEmail(),nv.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void filltoComboNv(JComboBox nv) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) nv.getModel();
        model.removeAllElements();
        List<NhanVien> list = _listNhanVien.getListNhanVien();
        for (NhanVien q : list) {
            model.addElement(q);
        }
    }
    
        @Override
    public void convert2(JTextField matKhau,JTextArea ghiChu, JTextField maNguoiNhan) {
        NhanVien nv = new NhanVien();
        nv.setGhiChu(ghiChu.getText().toString());

        List<NhanVien> list = _listNhanVien.getListNhanVien();
        for (int i = 0; i < list.size(); i++) {
            if ((!matKhau.getText().toString().equals(list.get(i).getMaKhau()))) {
                JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu, vui lòng nhập lại !", "Thông báo", 0, iconError);
                return;
            } else {
                nv.setMaNhanVien(maNguoiNhan.getText().toString());
            }
        }
        _listNhanVien.convert(nv);
    }


}
