/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL.GUI;

import BUS.Model.QuanLyPhongKhachSan;
import BUS.Utils.MsgBox;
import DAL.Entities.LoaiPhong;
import DAL.Entities.Phong;
import DAL.Entities.Tang;
import DAL.IServices.ILoaiPhongServices;
import DAL.IServices.IPhongServices;
import DAL.IServices.IQuanLyPhongKhachSanServices;
import DAL.IServices.ITangServices;
import DAL.Services.LoaiPhongServices;
import DAL.Services.PhongServices;
import DAL.Services.QuanLyPhongKhachSanServices;
import DAL.Services.TangServices;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public final class Frm_Phong extends javax.swing.JDialog {

    Frm_HoTelPhuongTo hotel;
    ITangServices _iTang = new TangServices();
    ILoaiPhongServices _iLoaiPhong = new LoaiPhongServices();
    IQuanLyPhongKhachSanServices _iQuanLyPhongKhachSan = new QuanLyPhongKhachSanServices();
    IPhongServices _iPhong = new PhongServices();
    List<Tang> listTang_Table;
    List<Tang> listTang;
    List<LoaiPhong> listLoaiPhong;
    List<QuanLyPhongKhachSan> listPhong = null;

    public Frm_Phong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        hotel = (Frm_HoTelPhuongTo) parent;
        tblPhong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblPhong.getTableHeader().setOpaque(false);
        tblPhong.getTableHeader().setForeground(new Color(228, 220, 241));
        tblPhong.getTableHeader().setBackground(new Color(61, 35, 82));
        fillTang();
        fillLoaiPhong();
        fillTang_Table();
        check();
    }

    public void fillTang_Table() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboTang_Table.getModel();
            model.removeAllElements();
            listTang_Table = _iTang.getListTang();
            for (Tang t : listTang_Table) {
                model.addElement(t);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void fillTang() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboTang.getModel();
            model.removeAllElements();
            listTang = _iTang.getListTang();
            for (Tang t : listTang) {
                model.addElement(t);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void fillLoaiPhong() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiPhong.getModel();
            model.removeAllElements();
            listLoaiPhong = _iLoaiPhong.getListLoaiPhong();
            for (LoaiPhong lp : listLoaiPhong) {
                model.addElement(lp);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void fillPhong() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);
            Tang t = (Tang) cboTang_Table.getSelectedItem();
            listPhong = _iQuanLyPhongKhachSan.getListPhong(t.getSoTang());
            for (QuanLyPhongKhachSan lp : listPhong) {
                Object[] row = {lp.getMaPhong(), lp.getTenLoaiPhong(), lp.getGiaTheoGio(), lp.getGiaTheoNgay(), lp.getTrangThai() == 1 ? "Trống" : lp.getTrangThai() == 2 ? "Đã có người ở" : "Đang dọn dẹp", lp.getGhiChu()};
                model.addRow(row);
            }
            clearForm();
            updateStatus();

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void fillPhongNSD() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
            model.setRowCount(0);
            Tang t = (Tang) cboTang_Table.getSelectedItem();
            listPhong = _iQuanLyPhongKhachSan.getListPhongTang_TrangThai(t.getSoTang(), 4);
            for (QuanLyPhongKhachSan lp : listPhong) {
                Object[] row = {lp.getMaPhong(), lp.getTenLoaiPhong(), lp.getGiaTheoGio(), lp.getGiaTheoNgay(), "Ngưng sử dụng", lp.getGhiChu()};
                model.addRow(row);
            }
            clearForm();
            updateStatus();

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void showForm() {
        try {
            txtMaPhong.setText(listPhong.get(tblPhong.getSelectedRow()).getMaPhong());
            int i;
            Tang t = (Tang) cboTang_Table.getSelectedItem();
            for (i = 0; i < listTang.size(); i++) {
                if (listTang.get(i).getSoTang() == t.getSoTang()) {
                    break;
                }
            }
            cboTang.setSelectedIndex(i);
            int a;
            for (a = 0; a < listLoaiPhong.size(); a++) {
                if (listLoaiPhong.get(a).getTenLoaiPhong().equals(listPhong.get(tblPhong.getSelectedRow()).getTenLoaiPhong())) {
                    break;
                }
            }
            cboLoaiPhong.setSelectedIndex(a);
            cboTrangThai.setSelectedIndex(listPhong.get(tblPhong.getSelectedRow()).getTrangThai() == 1 ? 0 : listPhong.get(tblPhong.getSelectedRow()).getTrangThai() == 2 ? 1 : listPhong.get(tblPhong.getSelectedRow()).getTrangThai() == 3 ? 2 : 3);
            txtGhiChu.setText(listPhong.get(tblPhong.getSelectedRow()).getGhiChu());
            updateStatus();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    void updateStatus() {
        try {
            boolean edit = (this.tblPhong.getSelectedRow() >= 0);
            txtMaPhong.setEnabled(!edit);
            btnThem.setEnabled(!edit);
            lblKyHieu.setVisible(!edit);
            cboKyHieu.setVisible(!edit);
            btnSua.setEnabled(edit);
            btnXoa.setEnabled(edit);
            cboTang.setEnabled(!edit);
            if (!edit) {
                Tang t = (Tang) cboTang.getSelectedItem();
                txtMaPhong.setText(_iPhong.getMaPhongAuto(cboKyHieu.getSelectedItem() + "" + t.getSoTang()));
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void clearForm() {
        try {
            txtMaPhong.setText("");
            txtGhiChu.setText("");
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void addPhong() {
        try {
            if (chkThemNhieu.isSelected()) {
                if (MsgBox.confirm(this, "Bạn chắc chắn muốn thêm " + txtSoLuong.getText() + " phòng?")) {
                    for (int i = 0; i < Integer.parseInt(txtSoLuong.getText()); i++) {
                        Phong p = new Phong();
                        Tang t = (Tang) cboTang.getSelectedItem();
                        p.setMaPhong(_iPhong.getMaPhongAuto(cboKyHieu.getSelectedItem() + "" + t.getSoTang()));
                        p.setMaTang(t.getMaTang());
                        LoaiPhong lp = (LoaiPhong) cboLoaiPhong.getSelectedItem();
                        p.setMaLoaiPhong(lp.getMaLoaiPhong());
                        p.setTrangThai(cboTrangThai.getSelectedIndex() == 0 ? 1 : cboTrangThai.getSelectedIndex() == 1 ? 2 : cboTrangThai.getSelectedIndex() == 2 ? 3 : 4);
                        p.setGhiChu(txtGhiChu.getText());
                        _iPhong.addPhong(p);
                        MsgBox.alert(this, "Thêm phòng thành công");
                        fillPhong();
                        hotel.cauHinhPhong();
                    }
                }
            } else {
                if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thêm phòng này?")) {
                    Phong p = new Phong();
                    p.setMaPhong(txtMaPhong.getText());
                    Tang t = (Tang) cboTang.getSelectedItem();
                    p.setMaTang(t.getMaTang());
                    LoaiPhong lp = (LoaiPhong) cboLoaiPhong.getSelectedItem();
                    p.setMaLoaiPhong(lp.getMaLoaiPhong());
                    p.setTrangThai(cboTrangThai.getSelectedIndex() == 0 ? 1 : cboTrangThai.getSelectedIndex() == 1 ? 2 : cboTrangThai.getSelectedIndex() == 2 ? 3 : 4);
                    p.setGhiChu(txtGhiChu.getText());
                    _iPhong.addPhong(p);
                    MsgBox.alert(this, "Thêm phòng thành công");
                    fillPhong();
                    hotel.cauHinhPhong();
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void updatePhong() {
        try {
            if (MsgBox.confirm(this, "Bạn có chắc chắn muốn sửa phòng này?")) {
                Phong p = new Phong();
                p.setMaPhong(txtMaPhong.getText());
                Tang t = (Tang) cboTang.getSelectedItem();
                p.setMaTang(t.getMaTang());
                LoaiPhong lp = (LoaiPhong) cboLoaiPhong.getSelectedItem();
                p.setMaLoaiPhong(lp.getMaLoaiPhong());
                p.setTrangThai(cboTrangThai.getSelectedIndex() == 0 ? 1 : cboTrangThai.getSelectedIndex() == 1 ? 2 : cboTrangThai.getSelectedIndex() == 2 ? 3 : 4);
                p.setGhiChu(txtGhiChu.getText());
                _iPhong.updatePhong(p);
                MsgBox.alert(this, "Sửa phòng thành công");
                fillPhong();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void check() {
        try {
            if (chkThemNhieu.isSelected()) {
                pnThemSLL.setVisible(true);
            } else {
                pnThemSLL.setVisible(false);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
        }
    }

    public void xoaPhong() {
        try {
            if (MsgBox.confirm(this, "Phòng này sẽ được chuyển sang trạng thái ngưng sử dụng. Bạn có chắn chắn?")) {
                Phong p = _iPhong.checkPhong(tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "");
                if (p != null) {
                    MsgBox.alert(this, "Phòng này đang có người sử dụng, không thể xóa!");
                    return;
                }
                _iPhong.updateTrangThai(4, tblPhong.getValueAt(tblPhong.getSelectedRow(), 0) + "");
                MsgBox.alert(this, "Thành công!");
                fillPhong();
                hotel.cauHinhPhong();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
            e.printStackTrace();
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
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboLoaiPhong = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        lblKyHieu = new javax.swing.JLabel();
        cboKyHieu = new javax.swing.JComboBox<>();
        chkThemNhieu = new javax.swing.JCheckBox();
        pnThemSLL = new javax.swing.JPanel();
        lblSoLuong = new javax.swing.JLabel();
        btnTru = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        btnCong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cboTang_Table = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnPhongNgungSuDung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ PHÒNG");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(61, 35, 82));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(228, 220, 241));
        jLabel3.setText("Quản Lý Phòng");
        jPanel1.add(jLabel3);

        jPanel3.setBackground(new java.awt.Color(136, 116, 163));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 220, 241));
        jLabel1.setText("Phòng");

        txtMaPhong.setEditable(false);
        txtMaPhong.setBackground(new java.awt.Color(228, 220, 241));
        txtMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaPhong.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 220, 241));
        jLabel2.setText("Tầng");

        cboTang.setBackground(new java.awt.Color(228, 220, 241));
        cboTang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboTang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTangItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(228, 220, 241));
        jLabel4.setText("Loại Phòng");

        cboLoaiPhong.setBackground(new java.awt.Color(228, 220, 241));
        cboLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(228, 220, 241));
        jLabel5.setText("Trạng Thái");

        cboTrangThai.setBackground(new java.awt.Color(228, 220, 241));
        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Đã Có Người ở", "Đang Dọn Dẹp", "Ngưng Sử Dụng" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(228, 220, 241));
        jLabel6.setText("Ghi Chú");

        txtGhiChu.setBackground(new java.awt.Color(228, 220, 241));
        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        btnThem.setBackground(new java.awt.Color(136, 116, 163));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(136, 116, 163));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(136, 116, 163));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(136, 116, 163));
        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        lblKyHieu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblKyHieu.setForeground(new java.awt.Color(228, 220, 241));
        lblKyHieu.setText("Ký Hiệu");

        cboKyHieu.setBackground(new java.awt.Color(228, 220, 241));
        cboKyHieu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboKyHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
        cboKyHieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKyHieuItemStateChanged(evt);
            }
        });

        chkThemNhieu.setBackground(new java.awt.Color(136, 116, 163));
        chkThemNhieu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        chkThemNhieu.setForeground(new java.awt.Color(228, 220, 241));
        chkThemNhieu.setText("Thêm Nhiều");
        chkThemNhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkThemNhieuActionPerformed(evt);
            }
        });

        pnThemSLL.setBackground(new java.awt.Color(136, 116, 163));

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(228, 220, 241));
        lblSoLuong.setText("Số Lượng");

        btnTru.setBackground(new java.awt.Color(136, 116, 163));
        btnTru.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        txtSoLuong.setBackground(new java.awt.Color(228, 220, 241));
        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("10");

        btnCong.setBackground(new java.awt.Color(136, 116, 163));
        btnCong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThemSLLLayout = new javax.swing.GroupLayout(pnThemSLL);
        pnThemSLL.setLayout(pnThemSLLLayout);
        pnThemSLLLayout.setHorizontalGroup(
            pnThemSLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemSLLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoLuong)
                .addGap(26, 26, 26)
                .addComponent(btnTru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThemSLLLayout.setVerticalGroup(
            pnThemSLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemSLLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThemSLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThemSLLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTru)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCong))
                    .addComponent(lblSoLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 26, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKyHieu)
                                .addGap(18, 18, 18)
                                .addComponent(cboKyHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboLoaiPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkThemNhieu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnThemSLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoi, btnSua, btnThem, btnXoa});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboKyHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKyHieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkThemNhieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThemSLL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(136, 116, 163));

        cboTang_Table.setBackground(new java.awt.Color(228, 220, 241));
        cboTang_Table.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cboTang_Table.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTang_TableItemStateChanged(evt);
            }
        });

        tblPhong.setBackground(new java.awt.Color(228, 220, 241));
        tblPhong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng", "Loại Phòng", "Giá Theo Giờ", "Giá Theo Ngày", "Trạng Thái", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.setGridColor(new java.awt.Color(255, 255, 255));
        tblPhong.setRowHeight(30);
        tblPhong.setSelectionBackground(new java.awt.Color(136, 116, 163));
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhong);

        jPanel4.setBackground(new java.awt.Color(61, 35, 82));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(228, 220, 241));
        jLabel7.setText("Danh Sách Phòng");
        jPanel4.add(jLabel7);

        btnPhongNgungSuDung.setBackground(new java.awt.Color(136, 116, 163));
        btnPhongNgungSuDung.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnPhongNgungSuDung.setText("Phòng Đã Ngưng Hoạt Động");
        btnPhongNgungSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhongNgungSuDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboTang_Table, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPhongNgungSuDung))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTang_Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhongNgungSuDung))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTang_TableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTang_TableItemStateChanged
        fillPhong();
    }//GEN-LAST:event_cboTang_TableItemStateChanged

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        if (evt.getClickCount() == 2) {
            showForm();
        }
    }//GEN-LAST:event_tblPhongMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addPhong();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        fillPhong();
        updateStatus();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void cboKyHieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKyHieuItemStateChanged
        Tang t = (Tang) cboTang.getSelectedItem();
        txtMaPhong.setText(_iPhong.getMaPhongAuto(cboKyHieu.getSelectedItem() + "" + t.getSoTang()));
    }//GEN-LAST:event_cboKyHieuItemStateChanged

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        updatePhong();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        xoaPhong();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboTangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTangItemStateChanged
        Tang t = (Tang) cboTang.getSelectedItem();
        txtMaPhong.setText(_iPhong.getMaPhongAuto(cboKyHieu.getSelectedItem() + "" + t.getSoTang()));
    }//GEN-LAST:event_cboTangItemStateChanged

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTruActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCongActionPerformed

    private void chkThemNhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkThemNhieuActionPerformed
        check();
    }//GEN-LAST:event_chkThemNhieuActionPerformed

    private void btnPhongNgungSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhongNgungSuDungActionPerformed
        fillPhongNSD();
    }//GEN-LAST:event_btnPhongNgungSuDungActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Phong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Phong dialog = new Frm_Phong(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnPhongNgungSuDung;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboKyHieu;
    private javax.swing.JComboBox<String> cboLoaiPhong;
    private javax.swing.JComboBox<String> cboTang;
    private javax.swing.JComboBox<String> cboTang_Table;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JCheckBox chkThemNhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblKyHieu;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JPanel pnThemSLL;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
