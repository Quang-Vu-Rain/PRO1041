/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.Utils.MsgBox;
import BUS.Utils.XDate;
import BUS.Utils.XValidated;
import DAL.Entities.ChiTietHoaDon;
import DAL.Entities.GiaTriKhac;
import DAL.Entities.LoaiHinhThue;
import DAL.IServices.IChiTietHoaDonServices;
import DAL.IServices.IGiaTriKhacServices;
import DAL.IServices.ILoaiHinhThueServices;
import DAL.Services.ChiTietHoaDonServices;
import DAL.Services.GiaTriKhacServices;
import DAL.Services.LoaiHinhThueServices;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PC
 */
public final class Frm_ThueTiep extends javax.swing.JDialog {

    DefaultComboBoxModel model;
    private Frm_HoaDon hoaDon;
    public String maHDCT_Update;
    public String ngay_Update;
    public String loaiHinhThue_Update;
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();
    ILoaiHinhThueServices _iLoaiHinhThue = new LoaiHinhThueServices();
    IGiaTriKhacServices _iGiaTriKhac = new GiaTriKhacServices();

    public Frm_ThueTiep(java.awt.Frame parent, boolean modal, String maHDCT, String ngay, String loaiHinhThue) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        hoaDon = (Frm_HoaDon) parent;
        model = (DefaultComboBoxModel) cboLoaiHinhThue.getModel();
        fillLoaiHinhThue();
        maHDCT_Update = maHDCT;
        ngay_Update = ngay;
        loaiHinhThue_Update = loaiHinhThue;
        layThongTin();
    }

    public void layThongTin() {
        try {
            ChiTietHoaDon cthd = _iChiTietHoaDon.getListChiTietHoaDonByID(maHDCT_Update);
            lblPhong.setText("Phòng " + cthd.getMaPhong());
            List<GiaTriKhac> _lstGTK = _iGiaTriKhac.getListGiaTriKhac();
            for (GiaTriKhac gtk : _lstGTK) {
                if (gtk.getMaGiaTri().equals("CheckTG")) {
                    Date ngayTra = XDate.toDate(ngay_Update, "dd-MM-yyyy HH:mm:ss");
                    Date ngayCheckOut = XDate.toDate(XDate.toString(cthd.getNgayDuKienTra(), "dd-MM-yyyy") + " " + gtk.getThoiGianCheckOut(), "dd-MM-yyyy HH:mm:ss");
                    if (loaiHinhThue_Update.equals("Theo Ngày")) {
                        if (ngayTra.getTime() < ngayCheckOut.getTime()) {
                            txtNgayThue.setDate(XDate.toDate(ngay_Update, "dd-MM-yyyy HH:mm:ss"));
                        } else {
                            txtNgayThue.setDate(cthd.getNgayDuKienTra());
                        }
                        txtNgayThue.setDateFormatString("dd-MM-yyyy HH:mm:ss");
                        txtNgayTraDuKien.setDate(new Date());
                        txtNgayTraDuKien.setDateFormatString("dd-MM-yyyy HH:mm:ss");
                    } else {
                        txtNgayThue.setDate(XDate.toDate(ngay_Update, "dd-MM-yyyy HH:mm:ss"));
                        txtNgayThue.setDateFormatString("dd-MM-yyyy HH:mm:ss");
                        txtNgayTraDuKien.setDate(new Date());
                        txtNgayTraDuKien.setDateFormatString("dd-MM-yyyy HH:mm:ss");
                    }
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }

    }

    public void thueTiep() {
        try {
            if (!isValidated()) {
                return;
            }
            ChiTietHoaDon cthd_Old = _iChiTietHoaDon.getListChiTietHoaDonByID(maHDCT_Update);
            if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thuê tiếp phòng này?")) {

                cthd_Old.setTrangThai(2);
                if (loaiHinhThue_Update.equals("Theo Ngày")) {
                    List<GiaTriKhac> _lstGTK = _iGiaTriKhac.getListGiaTriKhac();
                    for (GiaTriKhac gtk : _lstGTK) {
                        if (gtk.getMaGiaTri().equals("CheckTG")) {
                            Date ngayTra = XDate.toDate(ngay_Update, "dd-MM-yyyy HH:mm:ss");
                            Date ngayCheckOut = XDate.toDate(XDate.toString(cthd_Old.getNgayDuKienTra(), "dd-MM-yyyy") + " " + gtk.getThoiGianCheckOut(), "dd-MM-yyyy HH:mm:ss");
                            if (ngayTra.getTime() < ngayCheckOut.getTime()) {
                                cthd_Old.setNgayTraPhong(XDate.toDate(ngay_Update, "dd-MM-yyyy HH:mm:ss"));
                            } else {
                                cthd_Old.setNgayTraPhong(cthd_Old.getNgayDuKienTra());
                            }
                        }
                    }
                }
                if (loaiHinhThue_Update.equals("Theo Giờ")) {
                    cthd_Old.setNgayTraPhong(txtNgayThue.getDate());
                }
                _iChiTietHoaDon.updateChiTietHoaDon(cthd_Old);
                ChiTietHoaDon cthd_New = new ChiTietHoaDon();
                String maHDCT = _iChiTietHoaDon.getMaHDCTAuto();
                cthd_New.setMaHoaDonChiTiet(maHDCT);
                cthd_New.setMaHoaDon(cthd_Old.getMaHoaDon());
                cthd_New.setMaPhong(cthd_Old.getMaPhong());
                LoaiHinhThue lht = (LoaiHinhThue) cboLoaiHinhThue.getSelectedItem();
                cthd_New.setMaLoaiHinhThue(lht.getMaLoaiHinhThue());
                cthd_New.setTrangThai(1);
                cthd_New.setNgayThue(txtNgayThue.getDate());
                cthd_New.setTienDatCoc(Integer.parseInt(txtTienDatCoc.getText()));
                cthd_New.setNgayDuKienTra(txtNgayTraDuKien.getDate());
                _iChiTietHoaDon.addChiTietHoaDon(cthd_New);
                MsgBox.alert(this, "Thuê tiếp thành công!");
                hoaDon.fillThongTin();
                this.dispose();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void fillLoaiHinhThue() {
        try {
            model.removeAllElements();
            List<LoaiHinhThue> list = _iLoaiHinhThue.getListLoaiHinhThue();
            for (LoaiHinhThue lht : list) {
                model.addElement(lht);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public boolean isValidated() {
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

        jPanel1 = new javax.swing.JPanel();
        lblPhong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cboLoaiHinhThue = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtNgayThue = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTraDuKien = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtTienDatCoc = new javax.swing.JTextField();
        btnThueTiep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THUÊ TIẾP");

        jPanel1.setBackground(new java.awt.Color(61, 35, 82));

        lblPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(228, 220, 241));
        lblPhong.setText("Phòng");
        jPanel1.add(lblPhong);

        jPanel2.setBackground(new java.awt.Color(136, 116, 163));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(228, 220, 241));
        jLabel6.setText("Loại Hình Thuê:");

        cboLoaiHinhThue.setBackground(new java.awt.Color(228, 220, 241));
        cboLoaiHinhThue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(228, 220, 241));
        jLabel9.setText("Bắt Đầu Thuê:");

        txtNgayThue.setBackground(new java.awt.Color(228, 220, 241));
        txtNgayThue.setEnabled(false);
        txtNgayThue.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(228, 220, 241));
        jLabel8.setText("Dự Kiến Trả:");

        txtNgayTraDuKien.setBackground(new java.awt.Color(228, 220, 241));
        txtNgayTraDuKien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(228, 220, 241));
        jLabel10.setText("Tiền Đặt Cọc:");

        txtTienDatCoc.setBackground(new java.awt.Color(228, 220, 241));
        txtTienDatCoc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTienDatCoc.setText("0");

        btnThueTiep.setBackground(new java.awt.Color(136, 116, 163));
        btnThueTiep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThueTiep.setText("Thuê Tiếp");
        btnThueTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThueTiepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThueTiep))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cboLoaiHinhThue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienDatCoc))))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboLoaiHinhThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTraDuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTienDatCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnThueTiep)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboLoaiHinhThue, txtNgayThue, txtNgayTraDuKien, txtTienDatCoc});

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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThueTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThueTiepActionPerformed
        thueTiep();
    }//GEN-LAST:event_btnThueTiepActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_ThueTiep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ThueTiep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ThueTiep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ThueTiep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_ThueTiep dialog = new Frm_ThueTiep(new javax.swing.JFrame(), true, "", "", "");
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
    private javax.swing.JButton btnThueTiep;
    private javax.swing.JComboBox<String> cboLoaiHinhThue;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPhong;
    private com.toedter.calendar.JDateChooser txtNgayThue;
    private com.toedter.calendar.JDateChooser txtNgayTraDuKien;
    private javax.swing.JTextField txtTienDatCoc;
    // End of variables declaration//GEN-END:variables
}
