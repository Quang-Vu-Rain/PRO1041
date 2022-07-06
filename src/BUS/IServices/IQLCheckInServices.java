package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public interface IQLCheckInServices {

    public void fillKhachHang(JComboBox cbo);

    public void fillLoaiHinhThue(JComboBox cbo);

    public void thuePhong(JComboBox cboKhachHang, JComboBox cboLoaiHinhThue, JTextField ngayThue, JTextField ngayDuKienTra, JTextField soNguoi, String maPhong);
}
