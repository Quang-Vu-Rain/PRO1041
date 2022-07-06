package PL.GUI;

import BUS.IServices.IQLLoaiPhongServices;
import BUS.Services.QLLoaiPhongServices;
import BUS.Utils.MsgBox;
import DAL.Services.LoaiPhongServices;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Frm_LoaiPhong extends javax.swing.JFrame {

    IQLLoaiPhongServices _iLoaiPhong = new QLLoaiPhongServices();
    LoaiPhongServices loaiphong = new LoaiPhongServices();
    int _index = 0;
    ImageIcon iconTick = new ImageIcon("src\\PL\\Icon\\Tick.png");
    ImageIcon iconTrash = new ImageIcon("src\\PL\\Icon\\Trash.png");
    ImageIcon iconError = new ImageIcon("src\\PL\\Icon\\Problem.png");

    public Frm_LoaiPhong() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tblloaiphong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        filltoTable();
        showForm();
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
        txtmalp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttenlp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttheongay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttheogio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblloaiphong = new javax.swing.JTable();
        btnlammoi = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ LOẠI PHÒNG");

        jPanel1.setBackground(new java.awt.Color(10, 189, 227));

        txtmalp.setEditable(false);
        txtmalp.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtmalp.setBorder(null);
        txtmalp.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mã loại phòng");

        txttenlp.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txttenlp.setBorder(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên loại phòng");

        txttheongay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txttheongay.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Giá theo ngày");

        txttheogio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txttheogio.setBorder(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Giá theo giờ");

        tblloaiphong.setAutoCreateRowSorter(true);
        tblloaiphong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblloaiphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại phòng", "Tên loại phòng", "Giá theo giờ", "Giá theo ngày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblloaiphong.setGridColor(new java.awt.Color(255, 255, 255));
        tblloaiphong.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tblloaiphong.setRowHeight(24);
        tblloaiphong.setSelectionBackground(new java.awt.Color(10, 189, 227));
        tblloaiphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblloaiphongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblloaiphong);

        btnlammoi.setBackground(new java.awt.Color(34, 47, 62));
        btnlammoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnlammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnlammoi.setText("Làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(34, 47, 62));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnxoa.setForeground(new java.awt.Color(255, 255, 255));
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(34, 47, 62));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnsua.setForeground(new java.awt.Color(255, 255, 255));
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthem.setBackground(new java.awt.Color(34, 47, 62));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(10, 189, 227));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quản Lý Loại Phòng");
        jPanel2.add(jLabel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addGap(18, 18, 18)
                                .addComponent(btnsua))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnxoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnlammoi))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(txttheogio, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(txtmalp)
                                .addComponent(txttenlp)
                                .addComponent(txttheongay)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem, btnxoa});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmalp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttenlp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttheogio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttheongay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem)
                            .addComponent(btnsua))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa)
                            .addComponent(btnlammoi)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblloaiphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblloaiphongMouseClicked
        try {
            _index = tblloaiphong.getSelectedRow();
            showForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblloaiphongMouseClicked

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        clear();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        try {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa loại phòng ?");
            if (choice != JOptionPane.YES_OPTION) {
                return;
            }
            _iLoaiPhong.delete(txtmalp);
            _iLoaiPhong.fillToTable(tblloaiphong);
            JOptionPane.showMessageDialog(this, "Xóa loại phòng thành công !", "Thông báo", 0, iconTrash);
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loại phòng đang được sử dụng !", "Thông báo", 0, iconError);
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        try {
            if (checkEditAll() == false) {
                return;
            } else {
                int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật loại dịch vụ ?");
                if (choice != JOptionPane.YES_OPTION) {
                    return;
                }
                _iLoaiPhong.edit(txtmalp, txttenlp, txttheogio, txttheongay);
                _iLoaiPhong.fillToTable(tblloaiphong);
                JOptionPane.showMessageDialog(this, "Cập nhật loại dịch vụ thành công !", "Thông báo", 0, iconTick);
                clear();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không thể sửa!");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        try {
            if (checkAddAll() == false) {
                return;
            } else {
                int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm loại phòng ?");
                if (choice != JOptionPane.YES_OPTION) {
                    return;
                }
                _iLoaiPhong.add(txtmalp, txttenlp, txttheogio, txttheongay);
                _iLoaiPhong.fillToTable(tblloaiphong);
                JOptionPane.showMessageDialog(this, "Thêm loại phòng thành công !", "Thông báo", 0, iconTick);
                clear();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không thể xóa!");
        }
    }//GEN-LAST:event_btnthemActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_LoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_LoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_LoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_LoaiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_LoaiPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblloaiphong;
    private javax.swing.JTextField txtmalp;
    private javax.swing.JTextField txttenlp;
    private javax.swing.JTextField txttheogio;
    private javax.swing.JTextField txttheongay;
    // End of variables declaration//GEN-END:variables

    private void filltoTable() {
        _iLoaiPhong.fillToTable(tblloaiphong);
    }

    private void showForm() {
        txtmalp.setText(tblloaiphong.getValueAt(_index, 0).toString());
        txttenlp.setText(tblloaiphong.getValueAt(_index, 1).toString());
        txttheogio.setText(tblloaiphong.getValueAt(_index, 2).toString());
        txttheongay.setText(tblloaiphong.getValueAt(_index, 3).toString());
    }

    private void clear() {
        txtmalp.setText("");
        txttenlp.setText("");
        txttheogio.setText("");
        txttheongay.setText("");
        txtmalp.setEditable(true);
        txtmalp.setEnabled(true);
    }

    private boolean checkEditAll() {
        String malp = txtmalp.getText();
        String tenlp = txttenlp.getText();
        int giatheogio, giatheongay;
        if (malp.length() == 0 || tenlp.length() == 0 || txttheogio.getText().length() == 0 || txttheongay.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu !", "Thông báo", 0, iconError);
            return false;
        }
        try {
            giatheogio = Integer.parseInt(txttheogio.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá theo giờ phải là số !", "Thông báo", 0, iconError);
            return false;
        }
        if (giatheogio <= 0) {
            JOptionPane.showMessageDialog(this, "Giá theo giờ không phù hợp !", "Thông báo", 0, iconError);
            return false;
        }
        try {
            giatheongay = Integer.parseInt(txttheongay.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá theo ngày phải là số !", "Thông báo", 0, iconError);
            return false;
        }
        if (giatheongay <= 0) {
            JOptionPane.showMessageDialog(this, "Giá theo ngày không phù hợp !", "Thông báo", 0, iconError);
            return false;
        }
        return true;
    }

    private boolean checkAddAll() {
        String malp = txtmalp.getText();
        String tenlp = txttenlp.getText();
        int giatheogio, giatheongay;
        if (malp.length() == 0 || tenlp.length() == 0 || txttheogio.getText().length() == 0 || txttheongay.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu !", "Thông báo", 0, iconError);
            return false;
        }
        try {
            giatheogio = Integer.parseInt(txttheogio.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá theo giờ phải là số !", "Thông báo", 0, iconError);
            return false;
        }
        if (giatheogio <= 0) {
            JOptionPane.showMessageDialog(this, "Giá theo giờ không phù hợp !", "Thông báo", 0, iconError);
            return false;
        }
        try {
            giatheongay = Integer.parseInt(txttheongay.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá theo ngày phải là số !", "Thông báo", 0, iconError);
            return false;
        }
        if (giatheongay <= 0) {
            JOptionPane.showMessageDialog(this, "Giá theo ngày không phù hợp !", "Thông báo", 0, iconError);
            return false;
        }
        if (loaiphong.getListLoaiPhongByID(malp) != null) {
            JOptionPane.showMessageDialog(this, "Mã loại phòng đã tồn tại !", "Thông báo", 0, iconError);
            return false;
        }
        return true;
    }
}
