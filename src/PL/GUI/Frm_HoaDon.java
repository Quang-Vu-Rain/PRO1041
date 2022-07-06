/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.IServices.IChiTietThuePhongServices;
import BUS.Model.DichVu_Phong;
import BUS.Model.ThongTinThuePhong;
import BUS.Services.ChiTietThuePhongServices;
import BUS.Utils.MsgBox;
import BUS.Utils.XDate;
import DAL.Entities.ChiTietDichVu;
import DAL.Entities.ChiTietHoaDon;
import DAL.Entities.DichVu;
import DAL.Entities.GiaTriKhac;
import DAL.Entities.HinhThucThanhToan;
import DAL.Entities.HoaDon;
import DAL.Entities.LoaiDichVu;
import DAL.IServices.IChiTietDichVuServices;
import DAL.IServices.IChiTietHoaDonServices;
import DAL.IServices.IDichVuServices;
import DAL.IServices.IDichVu_PhongServices;
import DAL.IServices.IGiaTriKhacServices;
import DAL.IServices.IHinhThucThanhToanServices;
import DAL.IServices.IHoaDonServices;
import DAL.IServices.IKhachHangSevices;
import DAL.IServices.ILoaiDichVuServices;
import DAL.IServices.ILoaiHinhThueServices;
import DAL.IServices.ILoaiPhongServices;
import DAL.IServices.IPhongServices;
import DAL.IServices.IThongTinThuePhongServices;
import DAL.Services.ChiTietDichVuServices;
import DAL.Services.ChiTietHoaDonServices;
import DAL.Services.DichVuServices;
import DAL.Services.DichVu_PhongServices;
import DAL.Services.GiaTriKhacServices;
import DAL.Services.HinhThucThanhToanServices;
import DAL.Services.HoaDonServices;
import DAL.Services.KhachHangServices;
import DAL.Services.LoaiDichVuServices;
import DAL.Services.LoaiHinhThueServices;
import DAL.Services.LoaiPhongServices;
import DAL.Services.PhongServices;
import DAL.Services.ThongTinThuePhongServices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class Frm_HoaDon extends javax.swing.JFrame {

    private Frm_HoTelPhuongTo hotelPhuongTo;

    IChiTietThuePhongServices _iChiTietThuePhong = new ChiTietThuePhongServices();
    IHinhThucThanhToanServices _iHinhThucThanhToan = new HinhThucThanhToanServices();
    ILoaiDichVuServices _iLoaiDichVu = new LoaiDichVuServices();
    IDichVuServices _iDichVu = new DichVuServices();
    IChiTietDichVuServices _iChiTietDichVu = new ChiTietDichVuServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();
    IDichVu_PhongServices _iDichVu_Phong = new DichVu_PhongServices();
    IHoaDonServices _iHoaDon = new HoaDonServices();
    IKhachHangSevices _iKhachHang = new KhachHangServices();
    IThongTinThuePhongServices _iThongTinThuePhong = new ThongTinThuePhongServices();
    IGiaTriKhacServices _iGiaTriKhac = new GiaTriKhacServices();
    ILoaiPhongServices _iLoaiPhong = new LoaiPhongServices();
    ILoaiHinhThueServices _iLoaiHinhThue = new LoaiHinhThueServices();
    IPhongServices _iPhong = new PhongServices();
    Date now = new Date();

    long tongTienThanhToan;
    long tongTienDichVu;
    long tongTienPhong;
    long tongPhuThuCheckIn;
    long tongPhuThuCheckOut;
    long[] checkIn;
    long[] checkOut;
    long[] tienPhong_Luu;
    String maPhongThue;
    Frame frm_HoaDon;

    public Frm_HoaDon(String maPhong, Frm_HoTelPhuongTo hotel) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        maPhongThue = maPhong;
        hotelPhuongTo = hotel;
        tblPhong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblPhong.getTableHeader().setOpaque(false);
        tblPhong.getTableHeader().setForeground(Color.WHITE);
        tblPhong.getTableHeader().setBackground(new Color(136, 116, 163));
        tblChiTietDichVu.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblChiTietDichVu.getTableHeader().setOpaque(false);
        tblChiTietDichVu.getTableHeader().setForeground(Color.WHITE);
        tblChiTietDichVu.getTableHeader().setBackground(new Color(136, 116, 163));
        fillToComboBoxHinhThucThanhToan();
        fillToComboBoxLoaiDichVu();
        fillToDichVuPhong();
        fillToDichVu();
        fillThongTin();
        frm_HoaDon = this;
    }

    public void fillThongTin() {
        try {
            ThongTinThuePhong tttp = _iThongTinThuePhong.getListThongTinThuePhongByMaHoaDonChiTiet(maPhongThue);
            lblPhong.setText("Phòng " + maPhongThue);
            lblKhachHang.setText(tttp.getTenKhachHang());
            lblGiaTheoNgay.setText(tttp.getGiaTheoNgay() + " (VNĐ)");
            lblGiaTheoGio.setText(tttp.getGiaTheoGio() + " (VNĐ)");
            lblNgayTraPhong.setText(XDate.toString(now, "dd-MM-yyyy HH:mm:ss aa"));
            Insets is1 = new Insets(10, 10, 10, 10);
            JPopupMenu pm = new JPopupMenu();
            JMenuItem mi1 = new JMenuItem("Chỉnh Sửa Thông Tin!");
            mi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            mi1.setMargin(is1);
            JMenuItem mi2 = new JMenuItem("Khách muốn thuê tiếp theo loại hình thuê khác!");
            mi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            mi2.setMargin(is1);
            pm.add(mi1);
            pm.add(mi2);
            mi1.addActionListener((ActionEvent ae) -> {
                if (tblPhong.getSelectedRow() < 0) {
                    MsgBox.alert(this, "Vui lòng chọn hóa đơn để sửa!");
                    return;
                }
                ChiTietHoaDon cthdCheckChon = _iChiTietHoaDon.getListChiTietHoaDonByID(tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "");
                if (cthdCheckChon.getTrangThai() == 2) {
                    MsgBox.alert(this, "Hóa đơn này đã kết toán và đang trong quá trình chờ thanh toán! \nKhông thể sửa! \nVui lòng chọn hóa đơn khác!");
                    return;
                }
                Frm_UpdateHDCT frm_UpdateHDCT = new Frm_UpdateHDCT(this, true, tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "");
                frm_UpdateHDCT.setVisible(true);
            });
            mi2.addActionListener((ActionEvent ae) -> {
                if (tblPhong.getSelectedRow() < 0) {
                    MsgBox.alert(this, "Vui lòng chọn hóa đơn kết toán để thuê tiếp theo hình thức khác!");
                    return;
                }
                ChiTietHoaDon cthdCheckChon = _iChiTietHoaDon.getListChiTietHoaDonByID(tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "");
                if (cthdCheckChon.getTrangThai() == 2) {
                    MsgBox.alert(this, "Hóa đơn này đã kết toán và đang trong quá trình chờ thanh toán! \nKhông thể thuê tiếp theo hình thức khác từ hóa đơn này! \nVui lòng chọn hóa đơn khác!");
                    return;
                }
                Frm_ThueTiep frm_ThueTiep = new Frm_ThueTiep(this, true, tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "", XDate.toString(now, "dd-MM-yyyy HH:mm:ss"), tblPhong.getValueAt(tblPhong.getSelectedRow(), 2) + "");
                frm_ThueTiep.setVisible(true);

            });

            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);

            lblNgayTraPhong.setText(XDate.toString(now, "dd-MM-yyyy HH:mm:ss aa"));

            List<ThongTinThuePhong> listTTTP = _iThongTinThuePhong.getListThongTinThuePhongAll(maPhongThue);
            int sizeArr = listTTTP.size();
            int i = 0;
            long tongTienDatCoc = 0;
            checkIn = new long[sizeArr];
            checkOut = new long[sizeArr];
            tienPhong_Luu = new long[sizeArr];
            tongPhuThuCheckIn = 0;
            tongPhuThuCheckOut = 0;
            tongTienPhong = 0;
            for (ThongTinThuePhong tt : listTTTP) {
                if (tt.getTrangThai() == 2) {
                    model.addRow(new Object[]{tt.getMaHoaDonChiTiet(), tt.getMaPhong(), tt.getTenLoaiHinhThue(), XDate.toString(tt.getNgayThue(), "dd-MM-yyyy HH:mm:ss"), XDate.toString(tt.getNgayTraDuKien(), "dd-MM-yyyy HH:mm:ss"), XDate.toString(tt.getNgayTraPhong(), "dd-MM-yyyy HH:mm:ss"), "", ""});
                } else {
                    model.addRow(new Object[]{tt.getMaHoaDonChiTiet(), tt.getMaPhong(), tt.getTenLoaiHinhThue(), XDate.toString(tt.getNgayThue(), "dd-MM-yyyy HH:mm:ss"), XDate.toString(tt.getNgayTraDuKien(), "dd-MM-yyyy HH:mm:ss"), XDate.toString(now, "dd-MM-yyyy HH:mm:ss"), "", ""});
                }
                long soNgayThue = (XDate.toDate(tblPhong.getValueAt(i, 5) + "", "dd-MM-yyyy HH:mm:ss").getTime() - tt.getNgayThue().getTime()) / (24 * 3600 * 1000);
                if (soNgayThue == 0) {
                    soNgayThue = 1;
                }
                long soGioThue = (XDate.toDate(tblPhong.getValueAt(i, 5) + "", "dd-MM-yyyy HH:mm:ss").getTime() - tt.getNgayThue().getTime()) / (60 * 60 * 1000);
                long soPhutThue = (XDate.toDate(tblPhong.getValueAt(i, 5) + "", "dd-MM-yyyy HH:mm:ss").getTime() - tt.getNgayThue().getTime()) / (60 * 1000);
                long soPhutTheoNgay = soPhutThue - (soGioThue * 60);
                long tienThuePhong = 0;
                if (tt.getTenLoaiHinhThue().equalsIgnoreCase("Theo Giờ")) {
                    model.setValueAt(soGioThue + ":" + soPhutTheoNgay + " (Giờ:Phút)", i, 6);
                    tienThuePhong = soGioThue * tt.getGiaTheoGio();
                    if (soPhutTheoNgay >= 0 && soPhutTheoNgay <= 15) {
                        tienThuePhong = tienThuePhong + (tt.getGiaTheoGio() * 1 / 4);
                    } else if (soPhutTheoNgay > 15 && soPhutTheoNgay <= 30) {
                        tienThuePhong = tienThuePhong + (tt.getGiaTheoGio() * 1 / 2);
                    } else if (soPhutTheoNgay > 30 && soPhutTheoNgay <= 45) {
                        tienThuePhong = tienThuePhong + (tt.getGiaTheoGio() * 3 / 4);
                    } else if (soPhutTheoNgay > 45 && soPhutTheoNgay < 60) {
                        tienThuePhong = tienThuePhong + tt.getGiaTheoGio();
                    }
                    model.setValueAt(tienThuePhong + "(VNĐ)", i, 7);
                    tienPhong_Luu[i] = tienThuePhong;
                    model.setValueAt("0 (VNĐ)", i, 8);
                    checkIn[i] = 0;
                    model.setValueAt("0 (VNĐ)", i, 9);
                    checkOut[i] = 0;
                } else {
                    tienThuePhong = soNgayThue * tt.getGiaTheoNgay();
                    model.setValueAt(soNgayThue + " (Ngày)", i, 6);
                    model.setValueAt(tienThuePhong + "(VNĐ)", i, 7);
                    tienPhong_Luu[i] = tienThuePhong;
                    List<GiaTriKhac> _lstGTK = _iGiaTriKhac.getListGiaTriKhac();
                    for (GiaTriKhac gtk : _lstGTK) {
                        if (gtk.getMaGiaTri().equals("CheckTG")) {
                            Date gioThue = Time.valueOf(XDate.toString(tt.getNgayThue(), "HH:mm:ss"));
                            Date ngayTra = XDate.toDate(tblPhong.getValueAt(i, 5) + "", "dd-MM-yyyy HH:mm:ss");
                            Date ngayCheckOut = XDate.toDate(XDate.toString(XDate.toDate(tblPhong.getValueAt(i, 4) + "", "dd-MM-yyyy "), "dd-MM-yyyy") + " " + gtk.getThoiGianCheckOut(), "dd-MM-yyyy HH:mm:ss");
                            if (gioThue.getTime() < gtk.getThoiGianCheckIn().getTime()) {
                                long phuThuCheckIn = tt.getGiaTheoNgay() * gtk.getGiaTriCheckIn() / 100;
                                tongPhuThuCheckIn = tongPhuThuCheckIn + phuThuCheckIn;
                                checkIn[i] = phuThuCheckIn;
                                model.setValueAt(phuThuCheckIn + " (VNĐ)", i, 8);
                            } else {
                                checkIn[i] = 0;
                                model.setValueAt("0 (VNĐ)", i, 8);
                            }
                            if (ngayTra.getTime() > ngayCheckOut.getTime()) {
                                long phuThuCheckOut = tt.getGiaTheoNgay() * gtk.getGiaTriCheckOut() / 100;
                                tongPhuThuCheckOut = tongPhuThuCheckOut + phuThuCheckOut;
                                checkOut[i] = phuThuCheckOut;
                                model.setValueAt(phuThuCheckOut + " VNĐ", i, 9);
                            } else {
                                checkOut[i] = 0;
                                model.setValueAt("0 (VNĐ)", i, 9);
                            }
                        }
                    }
                }
                i++;
                tongTienDatCoc = tongTienDatCoc + tt.getTienDatCoc();
                txtTienDatCoc.setText(tongTienDatCoc + "");
                tongTienPhong = tongTienPhong + tienThuePhong;
            }
            tblPhong.setComponentPopupMenu(pm);
            lblTongTienPhong.setText(tongTienPhong + " (VNĐ)");
            txtPhuThuCheckIn.setText(tongPhuThuCheckIn + "");
            txtPhuThuCheckOut.setText(tongPhuThuCheckOut + "");
            tongTienThanhToan();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillToComboBoxHinhThucThanhToan() {

        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboHinhThucThanhToan.getModel();
            model.removeAllElements();
            List<HinhThucThanhToan> list = _iHinhThucThanhToan.getListHinhThucThanhToan();
            for (HinhThucThanhToan httt : list) {
                model.addElement(httt);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillToComboBoxLoaiDichVu() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiDichVu.getModel();
            model.removeAllElements();
            List<LoaiDichVu> list = _iLoaiDichVu.getListLoaiDichVu();
            model.addElement("Tất Cả");
            for (LoaiDichVu ldv : list) {
                model.addElement(ldv);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillToDichVuPhong() {
        try {
            ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByMaPhong(maPhongThue);
            DefaultTableModel model = (DefaultTableModel) tblChiTietDichVu.getModel();
            model.setRowCount(0);

            Insets is1 = new Insets(10, 10, 10, 10);
            JPopupMenu pm = new JPopupMenu();
            JMenuItem mi1 = new JMenuItem("Sửa số lượng!");
            mi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            mi1.setMargin(is1);
            JMenuItem mi2 = new JMenuItem("Xóa dịch vụ!");
            mi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            mi2.setMargin(is1);
            pm.add(mi1);
            pm.add(mi2);
            mi1.addActionListener((ActionEvent ae) -> {
                if (tblChiTietDichVu.getSelectedRow() < 0) {
                    MsgBox.alert(this, "Vui lòng chọn dịch vụ cần sửa!");
                    return;
                }
                Frm_GoiDichVu frm_GoiDichVu = new Frm_GoiDichVu(frm_HoaDon, true, maPhongThue, "", tblChiTietDichVu.getValueAt(tblChiTietDichVu.getSelectedRow(), 2) + "", tblPhong.getValueAt(0, 0) + "", 2, tblChiTietDichVu.getValueAt(tblChiTietDichVu.getSelectedRow(), 0) + "", Integer.parseInt(tblChiTietDichVu.getValueAt(tblChiTietDichVu.getSelectedRow(), 4) + ""));
                frm_GoiDichVu.setVisible(true);
            });
            mi2.addActionListener((ActionEvent ae) -> {
                if (tblChiTietDichVu.getSelectedRow() < 0) {
                    MsgBox.alert(this, "Vui lòng chọn dịch vụ cần xóa!");
                    return;
                }
                try {
                    if (MsgBox.confirm(this, "Bạn có chắc chắn muốn xóa dịch vụ này?")) {
                        _iChiTietDichVu.deleteChiTietDichVu(tblChiTietDichVu.getValueAt(tblChiTietDichVu.getSelectedRow(), 0) + "");
                        MsgBox.alert(this, "Xóa thành công dịch vụ!");
                        fillToDichVuPhong();
                    }
                } catch (Exception e) {
                    MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
                    e.printStackTrace();
                }
            });
            tblChiTietDichVu.setComponentPopupMenu(pm);
            try {
                List<DichVu_Phong> list = _iDichVu_Phong.getListChiTietDichVu(cthd.getMaHoaDonChiTiet());
                tongTienDichVu = 0;
                for (DichVu_Phong dvp : list) {
                    Object[] row = {dvp.getMaChiTietDichVu(), dvp.getMaPhong(), dvp.getTenDichVu(), dvp.getDonGia(), dvp.getSoLuong(), (dvp.getDonGia() * dvp.getSoLuong())};
                    tongTienDichVu = tongTienDichVu + (dvp.getDonGia() * dvp.getSoLuong());
                    model.addRow(row);
                }
                lblTongTienDichVu.setText(tongTienDichVu + " (VNĐ)");
                tongTienThanhToan();
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
                e.printStackTrace();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillToDichVu() {
        try {
            pnDichVuAll.removeAll();
            pnDichVuAll.updateUI();
            List<DichVu> _listDichVu;
            if (txtDichVuCanTim.getText().isEmpty()) {
                if (cboLoaiDichVu.getSelectedItem().toString().equals("Tất Cả")) {
                    _listDichVu = _iDichVu.getListDichVu();
                } else {
                    LoaiDichVu ldv = (LoaiDichVu) cboLoaiDichVu.getSelectedItem();
                    _listDichVu = _iDichVu.getListDichVuByMaLoaiDichVu(ldv.getMaLoaiDichVu());
                }
            } else {
                _listDichVu = _iDichVu.getListDichVuByTenDichVu(txtDichVuCanTim.getText());
            }
            int chieuDai = 0;
            if (_listDichVu.size() % 3 == 0) {
                chieuDai = _listDichVu.size() / 3 * 218;
            } else {
                chieuDai = (_listDichVu.size() / 3 + 1) * 218;
            }
            if (_listDichVu.size() <= 3) {
                chieuDai = 218;
            }
            pnDichVuAll.setPreferredSize(new Dimension(643, chieuDai));
            for (DichVu dv : _listDichVu) {
                JPanel pnDichVu = new JPanel();
                JLabel thongTin = new JLabel("<html><div style=\"text-align: center;\">" + dv.getTenDichVu() + "<br> <br>" + dv.getDonGia() + "(VNĐ)</div></html>");
                thongTin.setPreferredSize(new Dimension(208, 150));
                thongTin.setHorizontalAlignment(SwingUtilities.CENTER);
                thongTin.setFont(new Font("Segoe UI", Font.BOLD, 16));
                pnDichVu.setPreferredSize(new Dimension(208, 150));
                pnDichVu.setBackground(Color.WHITE);
                pnDichVuAll.add(pnDichVu);
                pnDichVu.add(thongTin);
                pnDichVu.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        Frm_GoiDichVu frm_GoiDichVu = new Frm_GoiDichVu(frm_HoaDon, true, maPhongThue, dv.getMaDichVu(), dv.getTenDichVu(), tblPhong.getValueAt(0, 0) + "", 1, "", 0);
                        frm_GoiDichVu.setVisible(true);
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                    }
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void tongTienThanhToan() {
        try {
            tongTienThanhToan = 0;
            tongTienThanhToan = tongTienPhong + tongTienDichVu + Long.parseLong(txtPhuThuCheckIn.getText()) + Long.parseLong(txtPhuThuCheckOut.getText());
            lblTongTienThanhToan.setText(tongTienThanhToan + "");
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void thanhToan() {
        try {
            if (MsgBox.confirm(this, "Bạn chắc chắn hoàn tất thanh toán hóa đơn này?")) {

                int index = tblPhong.getRowCount();
//            MsgBox.alert(this, checkIn[0] + "");
                for (int i = 0; i < index; i++) {
                    ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByID(tblPhong.getValueAt(i, 0) + "");
                    HinhThucThanhToan httt = (HinhThucThanhToan) cboHinhThucThanhToan.getSelectedItem();
                    cthd.setMaHinhThucThanhToan(httt.getMaHinhThucThanhToan());
                    cthd.setPhuThuCheckIn(Integer.parseInt(checkIn[i] + ""));
                    cthd.setPhuThuCheckOut(Integer.parseInt(checkOut[i] + ""));
                    if (i == 0) {
                        cthd.setTienKhachDua(Integer.parseInt(txtTienKhachDua.getText()) + Integer.parseInt(txtTienDatCoc.getText()));
                        cthd.setTienTraLai(Integer.parseInt(txtTraLai.getText()));
                        cthd.setTongTienDichVu((int) tongTienDichVu);
                        cthd.setTienTheNganHang(Integer.parseInt(txtTheNganHang.getText()));
                    } else {
                        cthd.setTienKhachDua(0);
                        cthd.setTienTraLai(0);
                        cthd.setTongTienDichVu(0);
                        cthd.setTienTheNganHang(0);
                    }
                    if (cthd.getTrangThai() == 1) {
                        cthd.setNgayTraPhong(now);
                    }
                    cthd.setTongTienPhong((int) tienPhong_Luu[i]);
                    cthd.setNgayThanhToan(now);
                    cthd.setTrangThai(3);
                    cthd.setGhiChu(txtGhiChu.getText());
                    _iChiTietHoaDon.updateChiTietHoaDon(cthd);

                    ChiTietHoaDon cthdKH = _iChiTietHoaDon.getListChiTietHoaDonByID(tblPhong.getValueAt(0, 0) + "");
                    ChiTietHoaDon cthdCheck = _iChiTietHoaDon.checkTonTai(cthdKH.getMaHoaDon());
                    HoaDon hd = new HoaDon();
                    hd.setMaHoaDon(cthdKH.getMaHoaDon());
                    if (cthdCheck == null) {
                        hd.setTrangThai(false);
                    } else {
                        hd.setTrangThai(false);
                    }
                    _iHoaDon.updateTrangThai(hd);

                    _iPhong.updateTrangThai(3, maPhongThue);
                    MsgBox.alert(this, "Thanh toán thành công");
                    this.dispose();
                    hotelPhuongTo.cauHinhPhong();
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblPhong = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNgayTraPhong = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblGiaTheoNgay = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblGiaTheoGio = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lblTongTienPhong = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTienDatCoc = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTraLai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPhuThuCheckOut = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPhuThuCheckIn = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        txtTheNganHang = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTongTienThanhToan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietDichVu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        cboLoaiDichVu = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnDichVuAll = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDichVuCanTim = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblTongTienDichVu = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHI TIẾT THUÊ PHÒNG");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        lblPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblPhong.setText("Phòng 100");
        jPanel2.add(lblPhong);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Khách Hàng: ");

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblKhachHang.setText("Bùi Quang Vũ");

        tblPhong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblPhong.setForeground(new java.awt.Color(255, 0, 51));
        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HĐ", "Phòng", "Loại Hình", "Ngày Thuê", "Ngày Trả Dự Kiến", "Ngày Trả Phòng", "Tổng Thời Gian", "Tiền Phòng", "Check In", "Check Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPhong.setGridColor(new java.awt.Color(255, 255, 255));
        tblPhong.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPhong.setRowHeight(30);
        tblPhong.setSelectionBackground(new java.awt.Color(153, 0, 153));
        jScrollPane1.setViewportView(tblPhong);
        if (tblPhong.getColumnModel().getColumnCount() > 0) {
            tblPhong.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPhong.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblPhong.getColumnModel().getColumn(2).setPreferredWidth(5);
            tblPhong.getColumnModel().getColumn(7).setPreferredWidth(2);
            tblPhong.getColumnModel().getColumn(8).setPreferredWidth(2);
            tblPhong.getColumnModel().getColumn(9).setPreferredWidth(2);
        }

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Hóa Đơn Chi Tiết");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Ngày Trả Phòng:");

        lblNgayTraPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNgayTraPhong.setText("22/11/2021 12:00:00");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Giá Phòng Theo Ngày:");

        lblGiaTheoNgay.setBackground(new java.awt.Color(255, 255, 255));
        lblGiaTheoNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGiaTheoNgay.setForeground(new java.awt.Color(255, 0, 0));
        lblGiaTheoNgay.setText("1000000");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Giá Phòng Theo Giờ:");

        lblGiaTheoGio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGiaTheoGio.setForeground(new java.awt.Color(255, 0, 0));
        lblGiaTheoGio.setText("1000000");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("Tổng Tiền Phòng:");
        jPanel9.add(jLabel32);

        lblTongTienPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTongTienPhong.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTienPhong.setText("0");
        jPanel9.add(lblTongTienPhong);

        jPanel10.setBackground(new java.awt.Color(153, 0, 153));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Chi Tiết Thuê Phòng");
        jPanel10.add(jLabel33);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKhachHang)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNgayTraPhong)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaTheoNgay)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaTheoGio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblGiaTheoNgay)
                        .addComponent(jLabel12)
                        .addComponent(lblNgayTraPhong)
                        .addComponent(jLabel15)
                        .addComponent(lblGiaTheoGio))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblKhachHang)))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane3.setViewportView(txtGhiChu);

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTienKhachDua.setText("0");
        txtTienKhachDua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienKhachDuaFocusLost(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setText("Tiền Khách Đưa");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Ghi Chú");

        txtTienDatCoc.setEditable(false);
        txtTienDatCoc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTienDatCoc.setText("0");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setText("Tiền Đặt Cọc");

        txtTraLai.setEditable(false);
        txtTraLai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTraLai.setText("0");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setText("Trả Lại");

        txtPhuThuCheckOut.setEditable(false);
        txtPhuThuCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPhuThuCheckOut.setText("0");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setText("Phụ Thu Check Out");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("Phụ Thu Check In");

        txtPhuThuCheckIn.setEditable(false);
        txtPhuThuCheckIn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPhuThuCheckIn.setText("0");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("Hình Thức Thanh Toán");

        cboHinhThucThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboHinhThucThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHinhThucThanhToanItemStateChanged(evt);
            }
        });

        txtTheNganHang.setEditable(false);
        txtTheNganHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTheNganHang.setText("0");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("Thẻ Ngân Hàng");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(153, 0, 153));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Thanh Toán");
        jPanel12.add(jLabel27);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Tổng Thanh Toán:");
        jPanel14.add(jLabel7);

        lblTongTienThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTongTienThanhToan.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTienThanhToan.setText("0");
        jPanel14.add(lblTongTienThanhToan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(txtTheNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24)
                                    .addComponent(txtPhuThuCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(jLabel23)
                                    .addComponent(txtPhuThuCheckOut)
                                    .addComponent(jLabel21)
                                    .addComponent(txtTienDatCoc)))
                            .addComponent(jLabel22)
                            .addComponent(txtTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThanhToan)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTheNganHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhuThuCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhuThuCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienDatCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 337, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnThanhToan)
                .addContainerGap())
        );

        tblChiTietDichVu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblChiTietDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DV", "Phòng", "Dịch Vụ", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietDichVu.setGridColor(new java.awt.Color(255, 255, 255));
        tblChiTietDichVu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblChiTietDichVu.setRowHeight(30);
        tblChiTietDichVu.setSelectionBackground(new java.awt.Color(153, 0, 153));
        jScrollPane2.setViewportView(tblChiTietDichVu);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        cboLoaiDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboLoaiDichVu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiDichVuItemStateChanged(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel30.setText("Các Loại Dịch Vụ");

        pnDichVuAll.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane4.setViewportView(pnDichVuAll);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Dịch Vụ Cần Tìm");

        txtDichVuCanTim.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtDichVuCanTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDichVuCanTimKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(cboLoaiDichVu, 0, 521, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtDichVuCanTim)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDichVuCanTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("Tổng Tiền Dịch Vụ:");
        jPanel8.add(jLabel31);

        lblTongTienDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTongTienDichVu.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTienDichVu.setText("0");
        jPanel8.add(lblTongTienDichVu);

        jPanel13.setBackground(new java.awt.Color(153, 0, 153));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Chi Tiết Dịch Vụ");
        jPanel13.add(jLabel28);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        try {
            HinhThucThanhToan httt = (HinhThucThanhToan) cboHinhThucThanhToan.getSelectedItem();
            if (txtTienKhachDua.getText().isEmpty() && httt.getTenHinhThucThanhToan().equals("Tiền Mặt")) {
                txtTraLai.setText("0");
                return;
            }
            if (txtTienKhachDua.getText().isEmpty() && httt.getTenHinhThucThanhToan().equals("Thẻ Ngân Hàng")) {
                txtTraLai.setText("0");
                txtTheNganHang.setText(tongTienThanhToan - Integer.parseInt(txtTienDatCoc.getText()) + "");
                return;
            }
            if (httt.getTenHinhThucThanhToan().equals("Thẻ Ngân Hàng")) {
                long tienNganHang = Long.parseLong(lblTongTienThanhToan.getText()) - Long.parseLong(txtTienDatCoc.getText()) - Long.parseLong(txtTienKhachDua.getText());
                txtTheNganHang.setText(tienNganHang + "");
            } else {
                if (Long.parseLong(txtTienKhachDua.getText()) >= (Long.parseLong(lblTongTienThanhToan.getText()) - Long.parseLong(txtTienDatCoc.getText()))) {
                    long tienTraLai = Integer.parseInt(txtTienKhachDua.getText()) + Integer.parseInt(txtTienDatCoc.getText()) - Integer.parseInt(lblTongTienThanhToan.getText());
                    txtTraLai.setText(tienTraLai + "");
                } else {
                    txtTraLai.setText("0");
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }

    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void cboLoaiDichVuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiDichVuItemStateChanged
        fillToDichVu();
    }//GEN-LAST:event_cboLoaiDichVuItemStateChanged

    private void cboHinhThucThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHinhThucThanhToanItemStateChanged
        try {
            HinhThucThanhToan httt = (HinhThucThanhToan) cboHinhThucThanhToan.getSelectedItem();
            if (httt.getTenHinhThucThanhToan().equals("Thẻ Ngân Hàng")) {
                txtTheNganHang.setText(tongTienThanhToan - Integer.parseInt(txtTienDatCoc.getText()) + "");
            } else {
                txtTheNganHang.setText("0");
            }
            if (!txtTienKhachDua.getText().isEmpty() && httt.getTenHinhThucThanhToan().equals("Tiền Mặt")) {
                txtTheNganHang.setText("0");
                if (Long.parseLong(txtTienKhachDua.getText()) >= (Long.parseLong(lblTongTienThanhToan.getText()) - Long.parseLong(txtTienDatCoc.getText()))) {
                    long tienTraLai = Integer.parseInt(txtTienKhachDua.getText()) + Integer.parseInt(txtTienDatCoc.getText()) - Integer.parseInt(lblTongTienThanhToan.getText());
                    txtTraLai.setText(tienTraLai + "");
                } else {
                    txtTraLai.setText("0");
                }
            }
            if (Integer.parseInt(txtTienKhachDua.getText()) > 0 && httt.getTenHinhThucThanhToan().equals("Thẻ Ngân Hàng")) {
                txtTheNganHang.setText(tongTienThanhToan - Integer.parseInt(txtTienDatCoc.getText()) - Integer.parseInt(txtTienKhachDua.getText()) + "");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }//GEN-LAST:event_cboHinhThucThanhToanItemStateChanged

    private void txtTienKhachDuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienKhachDuaFocusLost
        try {
            if (txtTienKhachDua.getText().isEmpty()) {
                txtTienKhachDua.setText("0");
                txtTraLai.setText("0");
                txtTheNganHang.setText(tongTienThanhToan + "");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTienKhachDuaFocusLost

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            int checkTien;
            checkTien = (int) (Integer.parseInt(txtTienKhachDua.getText()) + Integer.parseInt(txtTheNganHang.getText()) + Integer.parseInt(txtTienDatCoc.getText()) - Integer.parseInt(txtTraLai.getText()) - tongTienThanhToan);
            if (checkTien != 0) {
                MsgBox.alert(this, "Chưa thanh toán đủ số tiền!");
                return;
            }
            thanhToan();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtDichVuCanTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDichVuCanTimKeyReleased
        fillToDichVu();
    }//GEN-LAST:event_txtDichVuCanTimKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_HoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_HoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_HoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_HoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_HoaDon("", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboLoaiDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblGiaTheoGio;
    private javax.swing.JLabel lblGiaTheoNgay;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNgayTraPhong;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblTongTienDichVu;
    private javax.swing.JLabel lblTongTienPhong;
    private javax.swing.JLabel lblTongTienThanhToan;
    private javax.swing.JPanel pnDichVuAll;
    private javax.swing.JTable tblChiTietDichVu;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtDichVuCanTim;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtPhuThuCheckIn;
    private javax.swing.JTextField txtPhuThuCheckOut;
    private javax.swing.JTextField txtTheNganHang;
    private javax.swing.JTextField txtTienDatCoc;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTraLai;
    // End of variables declaration//GEN-END:variables
}
