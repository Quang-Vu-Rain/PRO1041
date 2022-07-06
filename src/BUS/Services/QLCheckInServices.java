package BUS.Services;

import BUS.IServices.IQLCheckInServices;
import BUS.Utils.XDate;
import DAL.Entities.ChiTietHoaDon;
import DAL.Entities.HoaDon;
import DAL.Entities.KhachHang;
import DAL.Entities.LoaiHinhThue;
import DAL.IServices.IChiTietHoaDonServices;
import DAL.IServices.IHoaDonServices;
import DAL.IServices.IKhachHangSevices;
import DAL.IServices.ILoaiHinhThueServices;
import DAL.IServices.IPhongServices;
import DAL.Services.ChiTietHoaDonServices;
import DAL.Services.HoaDonServices;
import DAL.Services.KhachHangServices;
import DAL.Services.LoaiHinhThueServices;
import DAL.Services.PhongServices;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class QLCheckInServices implements IQLCheckInServices {

    IKhachHangSevices _iKhachHang = new KhachHangServices();
    ILoaiHinhThueServices _iLoaiHinhThue = new LoaiHinhThueServices();
    IHoaDonServices _iHoaDon = new HoaDonServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();
    IPhongServices _iPhong = new PhongServices();

    @Override
    public void fillKhachHang(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<KhachHang> list = _iKhachHang.getListKhachHang();
        for (KhachHang kh : list) {
            model.addElement(kh);
        }
    }

    @Override
    public void fillLoaiHinhThue(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<LoaiHinhThue> list = _iLoaiHinhThue.getListLoaiHinhThue();
        for (LoaiHinhThue lh : list) {
            model.addElement(lh);
        }
    }

    @Override
    public void thuePhong(JComboBox cboKhachHang, JComboBox cboLoaiHinhThue, JTextField ngayThue, JTextField ngayDuKienTra, JTextField soNguoi, String maPhong) {
        KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();

        HoaDon hdCheck = _iHoaDon.getListHoaDonByMaKH(kh.getMaKhachHang());
        if (hdCheck != null) {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            String maHDCT = _iChiTietHoaDon.getMaHDCTAuto();
            cthd.setMaHoaDonChiTiet(maHDCT);
            cthd.setMaHoaDon(hdCheck.getMaHoaDon());
            cthd.setMaPhong(maPhong);
            LoaiHinhThue lht = (LoaiHinhThue) cboLoaiHinhThue.getSelectedItem();
            cthd.setMaLoaiHinhThue(lht.getMaLoaiHinhThue());
            cthd.setNgayThue(XDate.toDate(ngayThue.getText(), "dd-MM-yyyy"));
            cthd.setNgayDuKienTra(XDate.toDate(ngayDuKienTra.getText(), "dd-MM-yyyy"));
            cthd.setTrangThai(1);
            _iChiTietHoaDon.addChiTietHoaDon(cthd);
            _iPhong.updateTrangThai(2, maPhong);
        } else {
            HoaDon hd = new HoaDon();
            String maHD = _iHoaDon.getMaHDAuto();
            hd.setMaHoaDon(maHD);
            hd.setMaKhachHang(kh.getMaKhachHang());
            LoaiHinhThue lht = (LoaiHinhThue) cboLoaiHinhThue.getSelectedItem();
            hd.setSoNguoi(Integer.parseInt(soNguoi.getText()));
            hd.setMaNhanVien("NV001");
            hd.setTrangThai(true);
            _iHoaDon.addHoaDon(hd);
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            String maHDCT = _iChiTietHoaDon.getMaHDCTAuto();
            cthd.setMaHoaDonChiTiet(maHDCT);
            cthd.setMaHoaDon(maHD);
            cthd.setMaPhong(maPhong);
            cthd.setMaLoaiHinhThue(lht.getMaLoaiHinhThue());
            cthd.setNgayThue(XDate.toDate(ngayThue.getText(), "dd-MM-yyyy"));
            cthd.setNgayDuKienTra(XDate.toDate(ngayDuKienTra.getText(), "dd-MM-yyyy"));
            cthd.setTrangThai(1);
            _iChiTietHoaDon.addChiTietHoaDon(cthd);
            _iPhong.updateTrangThai(2, maPhong);
        }
    }

}
