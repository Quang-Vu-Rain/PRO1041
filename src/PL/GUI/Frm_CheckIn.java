/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.IServices.IQLCheckInServices;
import BUS.Services.QLCheckInServices;
import BUS.Utils.MsgBox;
import BUS.Utils.XDate;
import BUS.Utils.XValidated;
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
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public final class Frm_CheckIn extends javax.swing.JDialog {

    IKhachHangSevices _iKhachHang = new KhachHangServices();
    ILoaiHinhThueServices _iLoaiHinhThue = new LoaiHinhThueServices();
    IHoaDonServices _iHoaDon = new HoaDonServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();
    IPhongServices _iPhong = new PhongServices();
    IQLCheckInServices _iQLCheckIn = (IQLCheckInServices) new QLCheckInServices();

    String maPhongAdd;
    private Frm_HoTelPhuongTo khachSan;

    public Frm_CheckIn(java.awt.Frame parent, boolean modal, String maPhong) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        khachSan = (Frm_HoTelPhuongTo) parent;
        lblPhong.setText("Phòng " + maPhong);
        cboKhachHang.setEditable(true);
        fillKhachHang();
        fillLoaiHinhThue();
        maPhongAdd = maPhong;
//        String now1 = XDate.toString(new Date(), "dd-MM-yyyy HH:mm:ss");
        txtNgayThue.setDate(new Date());
        txtNgayThue.setDateFormatString("dd-MM-yyyy HH:mm:ss");
//        Calendar c2 = Calendar.getInstance();
//        Date d = new Date();
//        c2.setTime(d);
//        System.out.println(c2.getTime());
//        txtNgayTraDuKien.setDate(c2.getTime());
//        txtNgayTraDuKien.setDateFormatString("dd-MM-yyyy" + Time.valueOf("12:00:00"));
//        Date time = Time.valueOf("12:00:00");
//        System.out.println(time.getTime());
//        d.setTime(time.getTime());
        txtNgayTraDuKien.setDate(new Date());
//        txtNgayTraDuKien.setMinSelectableDate();
        txtNgayTraDuKien.setDateFormatString("dd-MM-yyyy HH:mm:ss");
        cboKhachHang.getSelectedItem();
    }

    public void thongTinKhachHang() {
        try {
            if (checkTonTaiKhachHang()) {
                KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();
                txtTuoi.setText(kh.getTuoi() + "");
                rdoNam.setSelected(kh.isGioiTinh());
                rdoNu.setSelected(!kh.isGioiTinh());
                txtSDT.setText(kh.getSoDienThoai());
                txtCCCD.setText(kh.getSoCCCD());
            } else {
                txtTuoi.setText("");
                rdoNam.setSelected(true);
                txtSDT.setText("");
                txtCCCD.setText("");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillKhachHang() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhachHang.getModel();
            model.removeAllElements();
            List<KhachHang> list = _iKhachHang.getListKhachHang();
            model.addElement("");
            for (KhachHang kh : list) {
                model.addElement(kh);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void fillLoaiHinhThue() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiHinhThue.getModel();
        model.removeAllElements();
        List<LoaiHinhThue> list = _iLoaiHinhThue.getListLoaiHinhThue();
        for (LoaiHinhThue lh : list) {
            model.addElement(lh);
        }
    }

    public void thuePhong() {
        try {
            if (!isValidated()) {
                return;
            }
            if (MsgBox.confirm(this, "Chắc chắn khách hàng muốn thuê phòng này?")) {
                String maKH = null;
                if (checkTonTaiKhachHang()) {
                    KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();
                    maKH = kh.getMaKhachHang();
                } else {
                    KhachHang kh = new KhachHang();
                    maKH = _iKhachHang.getMaKHAuto();
                    kh.setMaKhachHang(maKH);
                    kh.setTenKhachHang(cboKhachHang.getSelectedItem() + "");
                    kh.setTuoi(Integer.parseInt(txtTuoi.getText()));
                    kh.setGioiTinh(rdoNam.isSelected());
                    kh.setSoCCCD(txtCCCD.getText());
                    kh.setSoDienThoai(txtSDT.getText());
                    _iKhachHang.addKhachHang(kh);
                }

                HoaDon hdCheck = _iHoaDon.getListHoaDonByMaKH(maKH);
                if (hdCheck != null) {
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    String maHDCT = _iChiTietHoaDon.getMaHDCTAuto();
                    cthd.setMaHoaDonChiTiet(maHDCT);
                    cthd.setMaHoaDon(hdCheck.getMaHoaDon());
                    cthd.setMaPhong(maPhongAdd);
                    LoaiHinhThue lht = (LoaiHinhThue) cboLoaiHinhThue.getSelectedItem();
                    cthd.setMaLoaiHinhThue(lht.getMaLoaiHinhThue());
                    cthd.setNgayThue(txtNgayThue.getDate());
                    cthd.setTienDatCoc(Integer.parseInt(txtTienDatCoc.getText()));
                    cthd.setNgayDuKienTra(txtNgayTraDuKien.getDate());
                    cthd.setTrangThai(1);
                    _iChiTietHoaDon.addChiTietHoaDon(cthd);
                    _iPhong.updateTrangThai(2, maPhongAdd);
                } else {
                    HoaDon hd = new HoaDon();
                    String maHD = _iHoaDon.getMaHDAuto();
                    hd.setMaHoaDon(maHD);
                    hd.setMaKhachHang(maKH);
                    hd.setSoNguoi(Integer.parseInt(txtSoNguoi.getText()));
                    hd.setMaNhanVien("NV001");
                    hd.setTrangThai(true);
                    _iHoaDon.addHoaDon(hd);

                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    String maHDCT = _iChiTietHoaDon.getMaHDCTAuto();
                    cthd.setMaHoaDonChiTiet(maHDCT);
                    cthd.setMaHoaDon(maHD);
                    cthd.setMaPhong(maPhongAdd);
                    LoaiHinhThue lht = (LoaiHinhThue) cboLoaiHinhThue.getSelectedItem();
                    cthd.setMaLoaiHinhThue(lht.getMaLoaiHinhThue());
                    cthd.setNgayThue(txtNgayThue.getDate());
                    cthd.setTienDatCoc(Integer.parseInt(txtTienDatCoc.getText()));
                    cthd.setNgayDuKienTra(txtNgayTraDuKien.getDate());
                    cthd.setTrangThai(1);
                    _iChiTietHoaDon.addChiTietHoaDon(cthd);
                    _iPhong.updateTrangThai(2, maPhongAdd);
                }
                this.dispose();
                khachSan.cauHinhPhong();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public boolean checkTonTaiKhachHang() {
        try {
            KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isValidated() {
        if (cboKhachHang.getSelectedItem() == "") {
            MsgBox.alert(this, "Tên Khách Hàng không được để trống!");
            cboKhachHang.requestFocus();
            return false;
        }
        if (XValidated.checkRong(txtTuoi, "Tuổi không được để trống!")) {
            return false;
        }
        if (XValidated.checkSoNguyen(txtTuoi, "Tuổi phải là số nguyên!")) {
            return false;
        }
        if (XValidated.checkRong(txtSoNguoi, "Số người được để trống!")) {
            return false;
        }
        if (XValidated.checkSoNguyen(txtSoNguoi, "Số người phải là số nguyên!")) {
            return false;
        }
        try {
            Date ngayChek = txtNgayTraDuKien.getDate();
            String ngayCheckString = XDate.toString(ngayChek, "dd-MM-yyyy HH:mm:ss");
        } catch (Exception e) {
            MsgBox.alert(this, "Vui lòng chọn ngày dự kiến trả phòng!");
            return false;
        }
        if (XValidated.checkRong(txtTienDatCoc, "Tiền đặt cọc được để trống!")) {
            return false;
        }
        if (XValidated.checkSoNguyen(txtTienDatCoc, "Tiền đặt cọc phải là số nguyên!")) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblPhong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboLoaiHinhThue = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNgayThue = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtNgayTraDuKien = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienDatCoc = new javax.swing.JTextField();
        btnCheckIn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CHECKIN");

        jPanel1.setBackground(new java.awt.Color(61, 35, 82));

        lblPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(228, 220, 241));
        lblPhong.setText("Phòng 000");
        jPanel1.add(lblPhong);

        jPanel2.setBackground(new java.awt.Color(136, 116, 163));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 220, 241));
        jLabel2.setText("Khách Hàng");

        cboKhachHang.setBackground(new java.awt.Color(228, 220, 241));
        cboKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKhachHangItemStateChanged(evt);
            }
        });
        cboKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboKhachHangKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(228, 220, 241));
        jLabel3.setText("Loại Hình Thuê");

        cboLoaiHinhThue.setBackground(new java.awt.Color(228, 220, 241));
        cboLoaiHinhThue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(228, 220, 241));
        jLabel4.setText("Bắt Đầu Thuê");

        txtNgayThue.setBackground(new java.awt.Color(228, 220, 241));
        txtNgayThue.setEnabled(false);
        txtNgayThue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(228, 220, 241));
        jLabel5.setText("Dự Kiến Trả");

        txtNgayTraDuKien.setBackground(new java.awt.Color(228, 220, 241));
        txtNgayTraDuKien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(228, 220, 241));
        jLabel7.setText("Số Người");

        txtSoNguoi.setBackground(new java.awt.Color(228, 220, 241));
        txtSoNguoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoNguoi.setText("1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(228, 220, 241));
        jLabel8.setText("Tiền Đặt Cọc");

        txtTienDatCoc.setBackground(new java.awt.Color(228, 220, 241));
        txtTienDatCoc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTienDatCoc.setText("0");

        btnCheckIn.setBackground(new java.awt.Color(136, 116, 163));
        btnCheckIn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCheckIn.setText("Check In!");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(228, 220, 241));
        jLabel6.setText("Giới Tính");

        rdoNam.setBackground(new java.awt.Color(228, 220, 241));
        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(228, 220, 241));
        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(228, 220, 241));
        jLabel9.setText("Tuổi");

        txtTuoi.setBackground(new java.awt.Color(228, 220, 241));
        txtTuoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(228, 220, 241));
        jLabel10.setText("Số điện thoại");

        txtSDT.setBackground(new java.awt.Color(228, 220, 241));
        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(228, 220, 241));
        jLabel11.setText("CCCD");

        txtCCCD.setBackground(new java.awt.Color(228, 220, 241));
        txtCCCD.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCheckIn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienDatCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCCCD)
                                .addComponent(txtSDT)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rdoNam)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoNu))
                                .addComponent(txtTuoi)
                                .addComponent(cboKhachHang, 0, 195, Short.MAX_VALUE)
                                .addComponent(cboLoaiHinhThue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboLoaiHinhThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienDatCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnCheckIn)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNgayThue, txtNgayTraDuKien, txtSoNguoi});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        thuePhong();
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void cboKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKhachHangItemStateChanged
        thongTinKhachHang();
    }//GEN-LAST:event_cboKhachHangItemStateChanged

    private void cboKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboKhachHangKeyReleased
        MsgBox.alert(this, cboKhachHang.getSelectedItem() + "");
    }//GEN-LAST:event_cboKhachHangKeyReleased

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_CheckIn dialog = new Frm_CheckIn(new javax.swing.JFrame(), true, "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboKhachHang;
    private javax.swing.JComboBox<String> cboLoaiHinhThue;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtCCCD;
    private com.toedter.calendar.JDateChooser txtNgayThue;
    private com.toedter.calendar.JDateChooser txtNgayTraDuKien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTienDatCoc;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

}
