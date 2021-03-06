/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.Utils.MsgBox;
import BUS.Utils.XDate;
import BUS.Utils.XValidated;
import DAL.Entities.GiaTriKhac;
import DAL.IServices.IGiaTriKhacServices;
import DAL.Services.GiaTriKhacServices;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author PC
 */
public final class Frm_CauHinhGioCheckIn_Out extends javax.swing.JDialog {

    IGiaTriKhacServices _iGiaTriKhach = new GiaTriKhacServices();

    public Frm_CauHinhGioCheckIn_Out(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        layThongTin();
    }

    public void layThongTin() {
        try {
            GiaTriKhac gtk = _iGiaTriKhach.getThoiGianCheckIn();
            txtThoiGianCheckIn.setText(XDate.toString(gtk.getThoiGianCheckIn(), "HH:mm:ss"));
            txtThoiGianCheckOut.setText(XDate.toString(gtk.getThoiGianCheckOut(), "HH:mm:ss"));
            txtPhuThuCheckIn.setText(gtk.getGiaTriCheckIn() + "");
            txtPhuThuCheckOut.setText(gtk.getGiaTriCheckOut() + "");
            txtMoTa.setText(gtk.getMoTa());
        } catch (Exception e) {
        }
    }

    public boolean isValidated() {
        if (XValidated.checkRong(txtThoiGianCheckIn, "Giờ CheckIn không được để trống!")) {
            return false;
        }
        if (XValidated.checkGio(txtThoiGianCheckIn, "Giờ CheckIn phải đúng định dạng (HH:mm:ss)!")) {
            return false;
        }
        if (XValidated.checkRong(txtThoiGianCheckOut, "Giờ CheckOut không được để trống!")) {
            return false;
        }
        if (XValidated.checkGio(txtThoiGianCheckOut, "Giờ CheckOut phải đúng định dạng (HH:mm:ss)!")) {
            return false;
        }
        if (XValidated.checkRong(txtPhuThuCheckIn, "Phụ thu CheckIn không được để trống!")) {
            return false;
        }
        if (XValidated.checkSoNguyen(txtPhuThuCheckIn, "Phụ thu CheckIn phải là số nguyên!")) {
            return false;
        }
        if (XValidated.checkRong(txtPhuThuCheckOut, "Phụ thu CheckOut không được để trống!")) {
            return false;
        }
        if (XValidated.checkSoNguyen(txtPhuThuCheckOut, "Phụ thu CheckOut phải là số nguyên!")) {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtPhuThuCheckOut = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtThoiGianCheckIn = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhuThuCheckIn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtThoiGianCheckOut = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnLuu = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPhong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CẤU HÌNH THỜI GIAN");

        jPanel2.setBackground(new java.awt.Color(136, 116, 163));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(228, 220, 241));
        jLabel8.setText("% Phụ thu CheckOut");

        txtPhuThuCheckOut.setBackground(new java.awt.Color(228, 220, 241));
        txtPhuThuCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(228, 220, 241));
        jLabel9.setText("Giờ CheckIn");

        txtThoiGianCheckIn.setBackground(new java.awt.Color(228, 220, 241));
        txtThoiGianCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(228, 220, 241));
        jLabel10.setText("% Phụ thu CheckIn");

        txtPhuThuCheckIn.setBackground(new java.awt.Color(228, 220, 241));
        txtPhuThuCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(228, 220, 241));
        jLabel11.setText("Giờ CheckOut");

        txtThoiGianCheckOut.setBackground(new java.awt.Color(228, 220, 241));
        txtThoiGianCheckOut.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtMoTa.setEditable(false);
        txtMoTa.setBackground(new java.awt.Color(228, 220, 241));
        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMoTa.setLineWrap(true);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        btnLuu.setBackground(new java.awt.Color(136, 116, 163));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(228, 220, 241));
        jLabel12.setText("Mô Tả");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiGianCheckOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuThuCheckIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThoiGianCheckIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                        .addComponent(btnLuu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(txtPhuThuCheckOut))))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtThoiGianCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPhuThuCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtThoiGianCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPhuThuCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(45, 45, 45)
                .addComponent(btnLuu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(61, 35, 82));

        lblPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPhong.setForeground(new java.awt.Color(228, 220, 241));
        lblPhong.setText("Cấu Hình Thời Gian CheckIn_Out");
        jPanel1.add(lblPhong);

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            if (MsgBox.confirm(this, "Bạn có chắc muốn thay đổi cấu hình thời gian CheckIn_Out?")) {
                if (!isValidated()) {
                    return;
                }
                GiaTriKhac gtk = new GiaTriKhac();
                gtk.setThoiGianCheckIn(Time.valueOf(txtThoiGianCheckIn.getText()));
                gtk.setThoiGianCheckOut(Time.valueOf(txtThoiGianCheckOut.getText()));
                gtk.setGiaTriCheckIn(Integer.parseInt(txtPhuThuCheckIn.getText()));
                gtk.setGiaTriCheckOut(Integer.parseInt(txtPhuThuCheckOut.getText()));
                _iGiaTriKhach.updateGiaTriKhac(gtk);
                MsgBox.alert(this, "Thay đổi thành công!");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_CauHinhGioCheckIn_Out.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_CauHinhGioCheckIn_Out.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_CauHinhGioCheckIn_Out.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_CauHinhGioCheckIn_Out.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_CauHinhGioCheckIn_Out dialog = new Frm_CauHinhGioCheckIn_Out(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtPhuThuCheckIn;
    private javax.swing.JTextField txtPhuThuCheckOut;
    private javax.swing.JTextField txtThoiGianCheckIn;
    private javax.swing.JTextField txtThoiGianCheckOut;
    // End of variables declaration//GEN-END:variables
}
