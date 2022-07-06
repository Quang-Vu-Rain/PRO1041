package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public interface IChiTietThuePhongServices {

    public void fillLoaiDichVu(JComboBox cbo);
    
    public void fillDichVu(JPanel pn, String maLoaiDichVu, String maPhong, JTable tb, JLabel lbl, JLabel tongTienThanhToan, JLabel tongTienPhong);

    public void fillDichVuPhong(JTable tb, String maPhong, JLabel lbl, JLabel tongTienThanhToan, JLabel tongTienPhong);
    
    public void chiTietThuePhong(String maPhong, JLabel maHDCT, JLabel khachHang, JLabel loaiHinhThue, JLabel ngayBatDau, JLabel duKienTra, JLabel soNgay, JLabel tienPhong, JLabel tongTienPhong);
    public void tongTien(JLabel tienDichVu, JLabel tienPhong, JLabel tongTienThanhToan);
}
