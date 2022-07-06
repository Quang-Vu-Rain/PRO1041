package BUS.Services;

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
import BUS.IServices.IChiTietThuePhongServices;
import BUS.Model.DichVu_Phong;
import BUS.Model.ThongTinThuePhong;
import BUS.Utils.XDate;
import DAL.Entities.HoaDon;
import DAL.Entities.KhachHang;
import DAL.IServices.IDichVu_PhongServices;
import DAL.IServices.IHoaDonServices;
import DAL.IServices.IKhachHangSevices;
import DAL.IServices.IThongTinThuePhongServices;
import DAL.Services.DichVu_PhongServices;
import DAL.Services.HoaDonServices;
import DAL.Services.KhachHangServices;
import DAL.Services.ThongTinThuePhongServices;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChiTietThuePhongServices implements IChiTietThuePhongServices {

    ILoaiDichVuServices _iLoaiDichVu = new LoaiDichVuServices();
    IDichVuServices _iDichVu = new DichVuServices();
    IChiTietDichVuServices _iChiTietDichVu = new ChiTietDichVuServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();
    IDichVu_PhongServices _iDichVu_Phong = new DichVu_PhongServices();
    IHoaDonServices _iHoaDon = new HoaDonServices();
    IKhachHangSevices _iKhachHang = new KhachHangServices();
    IThongTinThuePhongServices _iThongTinThuePhong = new ThongTinThuePhongServices();

    @Override
    public void fillLoaiDichVu(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<LoaiDichVu> list = _iLoaiDichVu.getListLoaiDichVu();
//        model.addElement("Tất Cả");
        for (LoaiDichVu ldv : list) {
            model.addElement(ldv);
        }
    }

    @Override
    public void fillDichVuPhong(JTable tb, String maPhong, JLabel lbl, JLabel tongTienThanhToan, JLabel tongTienPhong) {
        ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByMaPhong(maPhong);
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<DichVu_Phong> list = _iDichVu_Phong.getListChiTietDichVu(cthd.getMaHoaDonChiTiet());
            int tienDichVu = 0;
            for (DichVu_Phong dvp : list) {
                Object[] row = {dvp.getMaPhong(), dvp.getTenDichVu(), dvp.getDonGia(), dvp.getSoLuong(), (dvp.getDonGia() * dvp.getSoLuong())};
                tienDichVu = tienDichVu + (dvp.getDonGia() * dvp.getSoLuong());
                model.addRow(row);
            }
            lbl.setText(tienDichVu + "");
            tongTien(lbl, tongTienPhong, tongTienThanhToan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillDichVu(JPanel pn, String maLoaiDichVu, String maPhong, JTable tb, JLabel lbl, JLabel tongTienThanhToan, JLabel tongTienPhong) {
        List<DichVu> _listDichVu = _iDichVu.getListDichVu();
        pn.removeAll();
        pn.updateUI();
        int _soLuong = 0;
        for (DichVu dv : _listDichVu) {
            if (dv.getMaLoaiDichVu().equals(maLoaiDichVu)) {
                _soLuong++;
            }
        }
        if (_soLuong % 2 == 0) {
            pn.setLayout(new GridLayout(_soLuong / 2, 4, 5, 5));
        } else {
            pn.setLayout(new GridLayout(_soLuong / 2 + 1, 4, 5, 5));
        }
        JButton[] btn = new JButton[_soLuong];
        for (DichVu dv : _listDichVu) {
            int i = 0;
            if (dv.getMaLoaiDichVu().equals(maLoaiDichVu)) {
                btn[i] = new javax.swing.JButton(dv.getTenDichVu());
                btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
                pn.add(btn[i]);
                pn.updateUI();
                btn[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByMaPhong(maPhong);
                        ChiTietDichVu ctdv = new ChiTietDichVu();
                        ctdv.setMaChiTietDichVu(_iChiTietDichVu.getMaCTDVAuto());
                        ctdv.setMaDichVu(dv.getMaDichVu());
                        ctdv.setMaHoaDonChiTiet(cthd.getMaHoaDonChiTiet());
                        ctdv.setSoLuong(1);
                        _iChiTietDichVu.addChiTietDichVu(ctdv);
                        fillDichVuPhong(tb, maPhong, lbl, tongTienThanhToan, tongTienPhong);
                    }
                });
            }
            i++;
        };
//        DefaultTableModel model = (DefaultTableModel) tb.getModel();
//        model.setRowCount(0);
//        try {
//            List<DichVu> list = _iDichVu.getListDichVu();
//            for (DichVu dv : list) {
//                if (maLoaiDichVu.equals(dv.getMaLoaiDichVu())) {
//                    Object[] row = {dv.getTenDichVu(), dv.getDonGia()};
//                    model.addRow(row);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void chiTietThuePhong(String maPhong, JLabel maHDCT, JLabel khachHang, JLabel loaiHinhThue, JLabel ngayBatDau, JLabel duKienTra, JLabel soNgay, JLabel tienPhong, JLabel tongTienPhong) {
        ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByMaPhong(maPhong);
        ThongTinThuePhong tttp = _iThongTinThuePhong.getListThongTinThuePhongByMaHoaDonChiTiet(cthd.getMaHoaDonChiTiet());
        JOptionPane.showMessageDialog(null, tttp);
        maHDCT.setText(tttp.getMaHoaDonChiTiet());
        khachHang.setText(tttp.getTenKhachHang());
        loaiHinhThue.setText(tttp.getTenLoaiHinhThue());
        ngayBatDau.setText(XDate.toString(tttp.getNgayThue(), "dd-MM-yyyy"));
        duKienTra.setText(XDate.toString(tttp.getNgayTraDuKien(), "dd-MM-yyyy"));
        long soNgayThue = (tttp.getNgayTraDuKien().getTime() - tttp.getNgayThue().getTime()) / (24 * 3600 * 1000);
        soNgay.setText(soNgayThue + " Ngày");
        long tienThuePhong = soNgayThue * tttp.getGiaTheoNgay();
        tienPhong.setText(tienThuePhong + "");
        tongTienPhong.setText(tienThuePhong + "");
    }

    @Override
    public void tongTien(JLabel tienDichVu, JLabel tienPhong, JLabel tongTienThanhToan) {
        int tienThanhToan = Integer.parseInt(tienDichVu.getText()) + Integer.parseInt(tienPhong.getText());
        tongTienThanhToan.setText(tienThanhToan + "");
    }

}
