/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.Utils.MsgBox;
import BUS.Utils.XDate;
import DAL.IServices.IThongKeServices;
import DAL.Services.ThongKeServices;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class Frm_ThongKe extends javax.swing.JDialog {

    IThongKeServices _iThongKe = new ThongKeServices();

    public Frm_ThongKe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tblDoanhThu.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
        tblDichVu.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
        tblDoanhThu.getTableHeader().setOpaque(false);
        tblDoanhThu.getTableHeader().setForeground(new Color(228,220,241));
        tblDoanhThu.getTableHeader().setBackground(new Color(61,35,82));
        tblDichVu.getTableHeader().setOpaque(false);
        tblDichVu.getTableHeader().setForeground(new Color(228,220,241));
        tblDichVu.getTableHeader().setBackground(new Color(61,35,82));
        checkLoaiTK();
        fillDoanhThu();
        fillDichVu();

    }

    public void fillDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        List<Object[]> list = _iThongKe.getDoanhThu();
        int i = 0;
        for (Object[] row : list) {
            model.addRow(new Object[]{row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]});
            model.setValueAt(XDate.toString(XDate.toDate(model.getValueAt(i, 9) + "", "yyyy-MM-dd"), "dd-MM-yyyy"), i, 9);
            i++;
        }
    }

    public void fillDichVu() {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        List<Object[]> list = _iThongKe.getDichVu();
        for (Object[] row : list) {
            model.addRow(new Object[]{row[0], row[1], row[2], row[3]});
        }
    }

    public void checkLoaiTK() {
        if (cboLoaiThongKe.getSelectedItem().equals("Ngày")) {
            lblNam.setVisible(false);
            ycNam.setVisible(false);
            lblTu.setVisible(true);
            lblDen.setVisible(true);
            dcNgayBatDau.setVisible(true);
            dcNgayKetThuc.setVisible(true);
            cboLoaiNgay.setVisible(true);
            btnXacNhan.setVisible(true);
            checkLoaiNgay();
        }
        if (cboLoaiThongKe.getSelectedItem().equals("Năm")) {
            cboLoaiNgay.setVisible(false);
            dcNgayBatDau.setVisible(false);
            dcNgayKetThuc.setVisible(false);
            lblNam.setVisible(false);
            ycNam.setVisible(false);
            btnXacNhan.setVisible(false);
        }
        if (cboLoaiThongKe.getSelectedItem().equals("Tháng")) {
            cboLoaiNgay.setVisible(false);
            lblTu.setVisible(false);
            lblDen.setVisible(false);
            dcNgayBatDau.setVisible(false);
            dcNgayKetThuc.setVisible(false);
            lblNam.setVisible(true);
            ycNam.setVisible(true);
            btnXacNhan.setVisible(true);
        }
    }

    public void checkLoaiNgay() {
        if (cboLoaiNgay.getSelectedItem().equals("Một Ngày")) {
            lblTu.setVisible(false);
            lblDen.setVisible(false);
            dcNgayKetThuc.setVisible(false);
            dcNgayBatDau.setVisible(true);
            dcNgayBatDau.setDate(new Date());
            dcNgayBatDau.setDateFormatString("dd-MM-yyyy");
        }
        if (cboLoaiNgay.getSelectedItem().equals("Khoảng Ngày")) {
            lblTu.setVisible(true);
            lblDen.setVisible(true);
            dcNgayKetThuc.setVisible(true);
            dcNgayBatDau.setVisible(true);
            Calendar c1 = Calendar.getInstance();
            Date date1 = new Date();
            c1.setTime(date1);
            c1.roll(Calendar.DATE, false);
            dcNgayBatDau.setDate(c1.getTime());
            dcNgayBatDau.setDateFormatString("dd-MM-yyyy");
            dcNgayKetThuc.setDate(new Date());
            dcNgayKetThuc.setDateFormatString("dd-MM-yyyy");
        }
    }

    public void locLoaiDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        List<Object[]> list = null;
        if (cboLoaiThongKe.getSelectedItem().equals("Ngày")) {
            if (cboLoaiNgay.getSelectedItem().equals("Một Ngày")) {
                list = _iThongKe.getDoanhThuTheoNgay(dcNgayBatDau.getDate());
            }
            if (cboLoaiNgay.getSelectedItem().equals("Khoảng Ngày")) {
                list = _iThongKe.getDoanhThuTheoKhoangNgay(dcNgayBatDau.getDate(), dcNgayKetThuc.getDate());
            }
        }
        if (cboLoaiThongKe.getSelectedItem().equals("Tháng")) {
            list = _iThongKe.getDoanhThuTheoThang(ycNam.getYear() + "");
        }
        if (cboLoaiThongKe.getSelectedItem().equals("Năm")) {
            list = _iThongKe.getDoanhThuTheoNam();
        }
        int i = 0;
        for (Object[] row : list) {
            model.addRow(new Object[]{row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]});
            if (cboLoaiThongKe.getSelectedItem().equals("Ngày")) {
                model.setValueAt(XDate.toString(XDate.toDate(model.getValueAt(i, 9) + "", "yyyy-MM-dd"), "dd-MM-yyyy"), i, 9);
            }
            i++;
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

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiThongKe = new javax.swing.JComboBox<>();
        cboLoaiNgay = new javax.swing.JComboBox<>();
        lblTu = new javax.swing.JLabel();
        dcNgayBatDau = new com.toedter.calendar.JDateChooser();
        dcNgayKetThuc = new com.toedter.calendar.JDateChooser();
        lblDen = new javax.swing.JLabel();
        lblNam = new javax.swing.JLabel();
        ycNam = new com.toedter.calendar.JYearChooser();
        btnXacNhan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THỐNG KÊ");

        jPanel3.setBackground(new java.awt.Color(136, 116, 163));

        jTabbedPane1.setBackground(new java.awt.Color(136, 116, 163));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(136, 116, 163));

        tblDoanhThu.setBackground(new java.awt.Color(228, 220, 241));
        tblDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL Hóa Đơn", "Tổng Tiền Phòng", "TB Tiền Phòng", "Tổng Tiền Dịch Vụ", "TB Tiền Dịch Vụ", "Phụ Thu", "Tổng Doanh Thu", "Hóa Đơn Thấp Nhất", "Hóa Đơn Cao Nhất", "Thời Gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setGridColor(new java.awt.Color(255, 255, 255));
        tblDoanhThu.setRowHeight(30);
        tblDoanhThu.setSelectionBackground(new java.awt.Color(136, 116, 163));
        jScrollPane1.setViewportView(tblDoanhThu);
        if (tblDoanhThu.getColumnModel().getColumnCount() > 0) {
            tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 220, 241));
        jLabel2.setText("Thống Kê Theo");

        cboLoaiThongKe.setBackground(new java.awt.Color(228, 220, 241));
        cboLoaiThongKe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        cboLoaiThongKe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiThongKeItemStateChanged(evt);
            }
        });

        cboLoaiNgay.setBackground(new java.awt.Color(228, 220, 241));
        cboLoaiNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboLoaiNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Một Ngày", "Khoảng Ngày" }));
        cboLoaiNgay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiNgayItemStateChanged(evt);
            }
        });

        lblTu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTu.setForeground(new java.awt.Color(228, 220, 241));
        lblTu.setText("Từ");

        dcNgayBatDau.setBackground(new java.awt.Color(228, 220, 241));
        dcNgayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        dcNgayKetThuc.setBackground(new java.awt.Color(228, 220, 241));
        dcNgayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblDen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDen.setForeground(new java.awt.Color(228, 220, 241));
        lblDen.setText("Đến");

        lblNam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNam.setForeground(new java.awt.Color(228, 220, 241));
        lblNam.setText("Năm");

        ycNam.setBackground(new java.awt.Color(228, 220, 241));
        ycNam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnXacNhan.setBackground(new java.awt.Color(136, 116, 163));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1593, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboLoaiNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTu)
                                .addGap(18, 18, 18)
                                .addComponent(dcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDen)
                                .addGap(18, 18, 18)
                                .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNam)
                                .addGap(18, 18, 18)
                                .addComponent(ycNam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXacNhan))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dcNgayBatDau, dcNgayKetThuc});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cboLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboLoaiNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTu)
                        .addComponent(lblDen))
                    .addComponent(dcNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ycNam, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnXacNhan)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thống Kê Doanh Thu", jPanel1);

        jPanel2.setBackground(new java.awt.Color(136, 116, 163));

        tblDichVu.setBackground(new java.awt.Color(228, 220, 241));
        tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Dịch Vụ", "Tên Loại Dịch Vụ", "Số Lượng", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDichVu.setGridColor(new java.awt.Color(255, 255, 255));
        tblDichVu.setRowHeight(30);
        tblDichVu.setSelectionBackground(new java.awt.Color(136, 116, 163));
        jScrollPane2.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1593, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống Kê Dịch Vụ", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1622, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiThongKeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiThongKeItemStateChanged
        checkLoaiTK();
        locLoaiDoanhThu();
    }//GEN-LAST:event_cboLoaiThongKeItemStateChanged

    private void cboLoaiNgayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiNgayItemStateChanged
        checkLoaiNgay();
    }//GEN-LAST:event_cboLoaiNgayItemStateChanged

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        locLoaiDoanhThu();
    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_ThongKe dialog = new Frm_ThongKe(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cboLoaiNgay;
    private javax.swing.JComboBox<String> cboLoaiThongKe;
    private com.toedter.calendar.JDateChooser dcNgayBatDau;
    private com.toedter.calendar.JDateChooser dcNgayKetThuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDen;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblTu;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblDoanhThu;
    private com.toedter.calendar.JYearChooser ycNam;
    // End of variables declaration//GEN-END:variables
}
