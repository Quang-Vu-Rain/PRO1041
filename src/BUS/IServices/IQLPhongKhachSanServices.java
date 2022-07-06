package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IQLPhongKhachSanServices {

    public void fillToTablePhong(JTable tb);

    public void fillToComboBoxTang(JComboBox cbo);

    public void fillToComboBoxLoaiPhong(JComboBox cbo);

    public void themPhong(JComboBox cboTang, JComboBox cboPhong, JTextField maPhong, JComboBox trangThai, JTextArea ghiChu);

    public void suaphong(JComboBox cboTang, JComboBox cboPhong, JTextField maPhong, JComboBox trangThai, JTextArea ghiChu);
}
