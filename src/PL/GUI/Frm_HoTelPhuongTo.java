/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PL.GUI;

import BUS.Model.QuanLyPhongKhachSan;
import BUS.Utils.Auth;
import BUS.Utils.MsgBox;
import DAL.Entities.Phong;
import DAL.Entities.Tang;
import DAL.IServices.IPhongServices;
import DAL.IServices.IQuanLyPhongKhachSanServices;
import DAL.IServices.ITangServices;
import DAL.Services.PhongServices;
import DAL.Services.QuanLyPhongKhachSanServices;
import DAL.Services.TangServices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC
 */
public final class Frm_HoTelPhuongTo extends javax.swing.JFrame {

    IQuanLyPhongKhachSanServices _iQuanLyPhong = new QuanLyPhongKhachSanServices();
    ITangServices _iTang = new TangServices();
    IPhongServices _iPhong = new PhongServices();
    int[] clicker = null;
    int trangThai = 0;/*0: Tất Cả, 1: Trống, 2:Có Người Ở, 3: Dọn Dẹp*/

    public Frm_HoTelPhuongTo() {
        initComponents();
        cauHinhPhong();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(50);
    }

    public void cauHinhPhong() {
        try {
            List<Tang> listTang = _iTang.getListTang();
            clicker = new int[listTang.size()];
            for (int a = 0; a < listTang.size(); a++) {
                clicker[a] = 1;
            }
            pnHotelPhuongTo.removeAll();
            pnHotelPhuongTo.updateUI();
            int i = 0;
            List<Phong> allPhongKS = _iPhong.getListPhong();
            List<QuanLyPhongKhachSan> PhongTrongKS = _iQuanLyPhong.getListPhongTrangThai(1);
            List<QuanLyPhongKhachSan> PhongCoNguoiOKS = _iQuanLyPhong.getListPhongTrangThai(2);
            List<QuanLyPhongKhachSan> PhongDangDonKS = _iQuanLyPhong.getListPhongTrangThai(3);
            int allPhong = allPhongKS.size();
            int phongTrong = PhongTrongKS.size();
            int phongCoNguoiO = PhongCoNguoiOKS.size();
            int phongDangDon = PhongDangDonKS.size();
            for (Tang t : listTang) {
                List<QuanLyPhongKhachSan> listPhong = null;
                if (trangThai == 0) {
                    listPhong = _iQuanLyPhong.getListPhong(t.getSoTang());
                } else {
                    listPhong = _iQuanLyPhong.getListPhongTang_TrangThai(t.getSoTang(), trangThai);
                }
                int chieuDai = 0;
                if (listPhong.size() % 9 == 0) {
                    chieuDai = (listPhong.size() / 9) * 180 + 30;
//                if ((listPhong.size() / 9) % 2 == 0) {
//                    chieuDai = (listPhong.size() / 9) * 170 + 25 + 30;
//                } else {
//                    chieuDai = (listPhong.size() / 9) * 170 + 20 + 30;
//                }
                } else {
                    chieuDai = (listPhong.size() / 9 + 1) * 180 + 30;
//                if ((listPhong.size() / 9 + 1) % 2 == 0) {
//                    chieuDai = ((listPhong.size() / 9) + 1) * 170 + 25 + 30;
//                } else {
//                    chieuDai = ((listPhong.size() / 9) + 1) * 170 + 20 + 30;
//                }
                }
                if (listPhong.size() < 9) {
                    chieuDai = 180 + 30;
                }
                if (listPhong.size() == 0) {
                    chieuDai = 0;
                }
//            if (listPhong.size() / 9 + 1 % 2 == 0) {
//                if(listPhong.size() > )
//            }
                JPanel pnTang = new JPanel();
                pnTang.setPreferredSize(new Dimension(1630, chieuDai));
                pnTang.setLayout(new BoxLayout(pnTang, BoxLayout.PAGE_AXIS));

                JPanel pnTenTang = new JPanel();
                pnTenTang.setBackground(new Color(136, 116, 163));
                pnTenTang.setPreferredSize(new Dimension(1630, 30));
                pnTenTang.setLayout(new FlowLayout(FlowLayout.LEFT));

                JLabel lblTenTang = new JLabel("Tầng " + t.getSoTang());
                lblTenTang.setFont(new Font("Tahoma", Font.BOLD, 16));
                lblTenTang.setForeground(new Color(228, 220, 241));

                JPanel pnPhongAll = new JPanel();
                pnPhongAll.setBackground(new Color(228, 220, 241));
                pnPhongAll.setPreferredSize(new Dimension(1630, chieuDai - 30));
                pnPhongAll.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

                pnTenTang.add(lblTenTang);
                pnTang.add(pnTenTang);
                pnTang.add(pnPhongAll);

                for (QuanLyPhongKhachSan p : listPhong) {
                    JPanel pnPhong = new JPanel();
                    JLabel thongTin = new JLabel(p.getMaPhong());
                    thongTin.setPreferredSize(new Dimension(170, 170));
                    thongTin.setHorizontalAlignment(SwingUtilities.CENTER);
                    thongTin.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    thongTin.setForeground(Color.white);
                    pnPhong.setPreferredSize(new Dimension(175, 170));
                    pnPhong.setBackground(Color.WHITE);
                    pnPhongAll.add(pnPhong);
                    pnPhong.add(thongTin);

                    Insets is1 = new Insets(10, 10, 10, 10);
                    JPopupMenu pm = new JPopupMenu();
                    JMenuItem mi1 = new JMenuItem("Check In!");
                    mi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    mi1.setMargin(is1);
                    JMenuItem mi2 = new JMenuItem("Chi Tiết Thuê Phòng!");
                    mi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    mi2.setMargin(is1);
                    JMenuItem mi3 = new JMenuItem("Chuyển Phòng!");
                    mi3.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    mi3.setMargin(is1);
                    JMenuItem mi4 = new JMenuItem("Dọn Phòng!");
                    mi4.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    mi4.setMargin(is1);
                    pm.add(mi1);
                    pm.add(mi2);
                    pm.add(mi3);
                    pm.add(mi4);

                    if (p.getTrangThai() == 1) {
                        pnPhong.setBackground(new Color(0, 200, 83));
                        thongTin.setText("<html><div style=\"text-align: center;\">Phòng " + p.getMaPhong() + "<bt> <br>" + "<br>(" + p.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đang trống</div></html>");
                        mi1.setEnabled(true);
                        mi2.setEnabled(false);
                        mi3.setEnabled(false);
                        mi4.setEnabled(false);
                    }
                    if (p.getTrangThai() == 2) {
                        pnPhong.setBackground(new Color(221, 44, 0));
                        thongTin.setText("<html><div style=\"text-align: center;\">Phòng " + p.getMaPhong() + "<bt> <br>" + "<br>(" + p.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đã có người ở</div></html>");
                        mi1.setEnabled(false);
                        mi2.setEnabled(true);
                        mi3.setEnabled(true);
                        mi4.setEnabled(false);
                    }
                    if (p.getTrangThai() == 3) {
                        pnPhong.setBackground(new Color(0, 191, 165));
                        thongTin.setText("<html><div style=\"text-align: center;\">Phòng " + p.getMaPhong() + "<bt> <br>" + "<br>(" + p.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đang dọn dẹp</div></html>");
                        mi1.setEnabled(false);
                        mi2.setEnabled(false);
                        mi3.setEnabled(false);
                        mi4.setEnabled(true);
                    }

                    pnPhong.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                        }

                        @Override
                        public void mousePressed(MouseEvent me) {
                            if (SwingUtilities.isRightMouseButton(me)) {
                                pm.show(me.getComponent(), me.getX(), me.getY());
                            }
                        }

                        @Override
                        public void mouseReleased(MouseEvent me) {
                            if (SwingUtilities.isRightMouseButton(me)) {
                                pm.show(me.getComponent(), me.getX(), me.getY());
                            }
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {

                        }

                        @Override
                        public void mouseExited(MouseEvent me) {

                        }
                    });
                    mi1.addActionListener((ActionEvent ae) -> {
//                        MsgBox.alert(null, p.getMaPhong());
                        Frm_CheckIn frm_CheckIn = new Frm_CheckIn(this, true, p.getMaPhong());
                        frm_CheckIn.setVisible(true);
                    });
                    mi2.addActionListener((ActionEvent ae) -> {
//                        MsgBox.alert(null, p.getMaPhong());
                        Frm_HoaDon frm_HoaDon = new Frm_HoaDon(p.getMaPhong(), this);
                        frm_HoaDon.setVisible(true);
                    });
                    mi3.addActionListener((ActionEvent ae) -> {
//                        MsgBox.alert(null, p.getMaPhong());
//                        Frm_ChuyenPhong frm_ChuyenPhong = new Frm_ChuyenPhong(this, true, p.getMaPhong(), p.getTenLoaiPhong());
//                        frm_ChuyenPhong.setVisible(true);
                    });
                    mi4.addActionListener((ActionEvent ae) -> {
//                        MsgBox.alert(null, p.getMaPhong());
                        if (MsgBox.confirm(null, "Bạn có chắn chắn phòng này đã được dọn dẹp xong?")) {
                            try {
                                _iPhong.updateTrangThai(1, p.getMaPhong());
                                MsgBox.alert(pnTang, "Phòng đã được dọn dẹp!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                MsgBox.alert(pnTang, "Dọn phòng thất bại!");
                            }
                            cauHinhPhong();
                        }
                    });
                }
                pnHotelPhuongTo.add(pnTang);
                pnHotelPhuongTo.updateUI();
                int chieuDaiNew = chieuDai;
                pnTenTang.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        clicker[i]++;
                        if (clicker[i] % 2 == 0) {
                            pnPhongAll.setVisible(false);
                            pnTang.setPreferredSize(new Dimension(1630, 30));
                        } else {
                            pnPhongAll.setVisible(true);
                            pnTang.setPreferredSize(new Dimension(1630, chieuDaiNew));
                        }
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
                lblTatCa.setText("Tất Cả (" + allPhong + ")");
                lblPhongTrong.setText("Phòng Trống (" + phongTrong + ")");
                lblDaCoNguoiO.setText("Phòng Đã Có Người Ở (" + phongCoNguoiO + ")");
                lblDangDonDep.setText("Phòng Đang Dọn Dẹp (" + phongDangDon + ")");
            }
            pnHotelPhuongTo.updateUI();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi này liên hệ zới anh Zũ đẹp zai để được giải quyết!");
//            e.printStackTrace();
        }
    }

    public void init() {
        setLocationRelativeTo(null);
        openDangNhap();
//        if (!Auth.isLogin()) {
//            System.exit(0);
//        }
    }

    public void openDangNhap() {
        new DangNhap().setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnHotelPhuongTo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        pnPhongTrong = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lblPhongTrong = new javax.swing.JLabel();
        pnDaCoNguoiO = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        lblDaCoNguoiO = new javax.swing.JLabel();
        pnDangDonDep = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        lblDangDonDep = new javax.swing.JLabel();
        pnTatCa = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        lblTatCa = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        pnQLP = new javax.swing.JPanel();
        lblQLP = new javax.swing.JLabel();
        pnePhu1 = new javax.swing.JPanel();
        pnQLTang = new javax.swing.JPanel();
        lblQLTang = new javax.swing.JLabel();
        pnePhu2 = new javax.swing.JPanel();
        pnLP = new javax.swing.JPanel();
        lblLP = new javax.swing.JLabel();
        pnePhu4 = new javax.swing.JPanel();
        pnDV = new javax.swing.JPanel();
        lblDV = new javax.swing.JLabel();
        pnePhu5 = new javax.swing.JPanel();
        pnLDV = new javax.swing.JPanel();
        lblLDV = new javax.swing.JLabel();
        pnePhu6 = new javax.swing.JPanel();
        pnKH = new javax.swing.JPanel();
        lblKH = new javax.swing.JLabel();
        pnePhu7 = new javax.swing.JPanel();
        pnNV = new javax.swing.JPanel();
        lblNV = new javax.swing.JLabel();
        pnePhu9 = new javax.swing.JPanel();
        pnTK = new javax.swing.JPanel();
        lblTK = new javax.swing.JLabel();
        pnePhu10 = new javax.swing.JPanel();
        pnTG = new javax.swing.JPanel();
        lblTG = new javax.swing.JLabel();
        pnePhu11 = new javax.swing.JPanel();
        pnDMK = new javax.swing.JPanel();
        lblDMK = new javax.swing.JLabel();
        pnePhu12 = new javax.swing.JPanel();
        pnDX = new javax.swing.JPanel();
        lblDX = new javax.swing.JLabel();
        pnePhu14 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ KHÁCH SẠN PHƯƠNG TỔ");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 1000));

        pnHotelPhuongTo.setBackground(new java.awt.Color(228, 220, 241));
        pnHotelPhuongTo.setPreferredSize(new java.awt.Dimension(1240, 10000));

        jPanel2.setMinimumSize(new java.awt.Dimension(1403, 180));
        jPanel2.setPreferredSize(new java.awt.Dimension(1625, 400));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBackground(new java.awt.Color(136, 116, 163));
        jPanel3.setPreferredSize(new java.awt.Dimension(1300, 30));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1625, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(246, 238, 232));
        jPanel4.setPreferredSize(new java.awt.Dimension(1500, 400));

        jPanel5.setBackground(new java.awt.Color(221, 44, 0));
        jPanel5.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 200, 83));
        jPanel6.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 200, 83));
        jPanel7.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);

        jPanel8.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8);

        jPanel9.setMinimumSize(new java.awt.Dimension(170, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(136, 14, 79));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(76, 76, 76))
        );

        jPanel4.add(jPanel9);

        jPanel10.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10);

        jPanel11.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel11);

        jPanel12.setMinimumSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel12);

        jPanel2.add(jPanel4);

        pnHotelPhuongTo.add(jPanel2);

        jScrollPane1.setViewportView(pnHotelPhuongTo);

        jPanel1.setBackground(new java.awt.Color(61, 35, 82));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(228, 220, 241));

        pnPhongTrong.setBackground(new java.awt.Color(228, 220, 241));
        pnPhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnPhongTrongMouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(0, 200, 83));
        jPanel14.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblPhongTrong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPhongTrong.setForeground(new java.awt.Color(30, 2, 51));
        lblPhongTrong.setText("Phòng Trống");

        javax.swing.GroupLayout pnPhongTrongLayout = new javax.swing.GroupLayout(pnPhongTrong);
        pnPhongTrong.setLayout(pnPhongTrongLayout);
        pnPhongTrongLayout.setHorizontalGroup(
            pnPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhongTrongLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        pnPhongTrongLayout.setVerticalGroup(
            pnPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhongTrongLayout.createSequentialGroup()
                .addGroup(pnPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        pnDaCoNguoiO.setBackground(new java.awt.Color(228, 220, 241));
        pnDaCoNguoiO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDaCoNguoiOMouseClicked(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(221, 44, 0));
        jPanel17.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDaCoNguoiO.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDaCoNguoiO.setForeground(new java.awt.Color(30, 2, 51));
        lblDaCoNguoiO.setText("Phòng Đã Có Người Ở");

        javax.swing.GroupLayout pnDaCoNguoiOLayout = new javax.swing.GroupLayout(pnDaCoNguoiO);
        pnDaCoNguoiO.setLayout(pnDaCoNguoiOLayout);
        pnDaCoNguoiOLayout.setHorizontalGroup(
            pnDaCoNguoiOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDaCoNguoiOLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblDaCoNguoiO, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnDaCoNguoiOLayout.setVerticalGroup(
            pnDaCoNguoiOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
            .addComponent(lblDaCoNguoiO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnDangDonDep.setBackground(new java.awt.Color(228, 220, 241));
        pnDangDonDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDangDonDepMouseClicked(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(0, 191, 165));
        jPanel19.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDangDonDep.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDangDonDep.setForeground(new java.awt.Color(30, 2, 51));
        lblDangDonDep.setText("Phòng Đang Dọn Dẹp");

        javax.swing.GroupLayout pnDangDonDepLayout = new javax.swing.GroupLayout(pnDangDonDep);
        pnDangDonDep.setLayout(pnDangDonDepLayout);
        pnDangDonDepLayout.setHorizontalGroup(
            pnDangDonDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangDonDepLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDangDonDep, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        pnDangDonDepLayout.setVerticalGroup(
            pnDangDonDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
            .addComponent(lblDangDonDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnTatCa.setBackground(new java.awt.Color(228, 220, 241));
        pnTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTatCaMouseClicked(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(102, 0, 102));
        jPanel21.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblTatCa.setBackground(new java.awt.Color(117, 100, 119));
        lblTatCa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTatCa.setForeground(new java.awt.Color(30, 2, 51));
        lblTatCa.setText("Tất Cả");

        javax.swing.GroupLayout pnTatCaLayout = new javax.swing.GroupLayout(pnTatCa);
        pnTatCa.setLayout(pnTatCaLayout);
        pnTatCaLayout.setHorizontalGroup(
            pnTatCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTatCaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        pnTatCaLayout.setVerticalGroup(
            pnTatCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(lblTatCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(pnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDaCoNguoiO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnDangDonDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 586, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnDangDonDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnDaCoNguoiO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnPhongTrong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnTatCa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(61, 35, 82));

        pnQLP.setBackground(new java.awt.Color(61, 35, 82));
        pnQLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnQLPMouseMoved(evt);
            }
        });
        pnQLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnQLPMouseExited(evt);
            }
        });

        lblQLP.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblQLP.setForeground(new java.awt.Color(228, 220, 241));
        lblQLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Brick house.png"))); // NOI18N
        lblQLP.setText("Phòng");
        lblQLP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblQLP.setIconTextGap(15);

        pnePhu1.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu1.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu1Layout = new javax.swing.GroupLayout(pnePhu1);
        pnePhu1.setLayout(pnePhu1Layout);
        pnePhu1Layout.setHorizontalGroup(
            pnePhu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu1Layout.setVerticalGroup(
            pnePhu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnQLPLayout = new javax.swing.GroupLayout(pnQLP);
        pnQLP.setLayout(pnQLPLayout);
        pnQLPLayout.setHorizontalGroup(
            pnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLPLayout.createSequentialGroup()
                .addComponent(pnePhu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQLP, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQLPLayout.setVerticalGroup(
            pnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLP, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnQLTang.setBackground(new java.awt.Color(61, 35, 82));
        pnQLTang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnQLTangMouseMoved(evt);
            }
        });
        pnQLTang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQLTangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnQLTangMouseExited(evt);
            }
        });

        lblQLTang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblQLTang.setForeground(new java.awt.Color(228, 220, 241));
        lblQLTang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Company.png"))); // NOI18N
        lblQLTang.setText("Tầng");
        lblQLTang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblQLTang.setIconTextGap(15);

        pnePhu2.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu2.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu2Layout = new javax.swing.GroupLayout(pnePhu2);
        pnePhu2.setLayout(pnePhu2Layout);
        pnePhu2Layout.setHorizontalGroup(
            pnePhu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu2Layout.setVerticalGroup(
            pnePhu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnQLTangLayout = new javax.swing.GroupLayout(pnQLTang);
        pnQLTang.setLayout(pnQLTangLayout);
        pnQLTangLayout.setHorizontalGroup(
            pnQLTangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLTangLayout.createSequentialGroup()
                .addComponent(pnePhu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQLTang, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQLTangLayout.setVerticalGroup(
            pnQLTangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLTang, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnLP.setBackground(new java.awt.Color(61, 35, 82));
        pnLP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnLPMouseMoved(evt);
            }
        });
        pnLP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnLPMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnLPMouseExited(evt);
            }
        });

        lblLP.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblLP.setForeground(new java.awt.Color(228, 220, 241));
        lblLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Closed door.png"))); // NOI18N
        lblLP.setText("Loại Phòng");
        lblLP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblLP.setIconTextGap(15);

        pnePhu4.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu4.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu4Layout = new javax.swing.GroupLayout(pnePhu4);
        pnePhu4.setLayout(pnePhu4Layout);
        pnePhu4Layout.setHorizontalGroup(
            pnePhu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu4Layout.setVerticalGroup(
            pnePhu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnLPLayout = new javax.swing.GroupLayout(pnLP);
        pnLP.setLayout(pnLPLayout);
        pnLPLayout.setHorizontalGroup(
            pnLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLPLayout.createSequentialGroup()
                .addComponent(pnePhu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnLPLayout.setVerticalGroup(
            pnLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLP, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu4, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnDV.setBackground(new java.awt.Color(61, 35, 82));
        pnDV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnDVMouseMoved(evt);
            }
        });
        pnDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDVMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnDVMouseExited(evt);
            }
        });

        lblDV.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDV.setForeground(new java.awt.Color(228, 220, 241));
        lblDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Basket.png"))); // NOI18N
        lblDV.setText("Dịch Vụ");
        lblDV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDV.setIconTextGap(15);

        pnePhu5.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu5.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu5Layout = new javax.swing.GroupLayout(pnePhu5);
        pnePhu5.setLayout(pnePhu5Layout);
        pnePhu5Layout.setHorizontalGroup(
            pnePhu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu5Layout.setVerticalGroup(
            pnePhu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDVLayout = new javax.swing.GroupLayout(pnDV);
        pnDV.setLayout(pnDVLayout);
        pnDVLayout.setHorizontalGroup(
            pnDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDVLayout.createSequentialGroup()
                .addComponent(pnePhu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDVLayout.setVerticalGroup(
            pnDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDV, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu5, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnLDV.setBackground(new java.awt.Color(61, 35, 82));
        pnLDV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnLDVMouseMoved(evt);
            }
        });
        pnLDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnLDVMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnLDVMouseExited(evt);
            }
        });

        lblLDV.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblLDV.setForeground(new java.awt.Color(228, 220, 241));
        lblLDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Bubble.png"))); // NOI18N
        lblLDV.setText("Loại Dịch Vụ");
        lblLDV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblLDV.setIconTextGap(15);

        pnePhu6.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu6.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu6Layout = new javax.swing.GroupLayout(pnePhu6);
        pnePhu6.setLayout(pnePhu6Layout);
        pnePhu6Layout.setHorizontalGroup(
            pnePhu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu6Layout.setVerticalGroup(
            pnePhu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnLDVLayout = new javax.swing.GroupLayout(pnLDV);
        pnLDV.setLayout(pnLDVLayout);
        pnLDVLayout.setHorizontalGroup(
            pnLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLDVLayout.createSequentialGroup()
                .addComponent(pnePhu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLDV)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pnLDVLayout.setVerticalGroup(
            pnLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLDV, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu6, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnKH.setBackground(new java.awt.Color(61, 35, 82));
        pnKH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnKHMouseMoved(evt);
            }
        });
        pnKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnKHMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnKHMouseExited(evt);
            }
        });

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblKH.setForeground(new java.awt.Color(228, 220, 241));
        lblKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Boy.png"))); // NOI18N
        lblKH.setText("Khách Hàng");
        lblKH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblKH.setIconTextGap(15);

        pnePhu7.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu7.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu7Layout = new javax.swing.GroupLayout(pnePhu7);
        pnePhu7.setLayout(pnePhu7Layout);
        pnePhu7Layout.setHorizontalGroup(
            pnePhu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu7Layout.setVerticalGroup(
            pnePhu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnKHLayout = new javax.swing.GroupLayout(pnKH);
        pnKH.setLayout(pnKHLayout);
        pnKHLayout.setHorizontalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKHLayout.createSequentialGroup()
                .addComponent(pnePhu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnKHLayout.setVerticalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKH, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu7, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnNV.setBackground(new java.awt.Color(61, 35, 82));
        pnNV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnNVMouseMoved(evt);
            }
        });
        pnNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnNVMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnNVMouseExited(evt);
            }
        });

        lblNV.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNV.setForeground(new java.awt.Color(228, 220, 241));
        lblNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Clien list.png"))); // NOI18N
        lblNV.setText("Nhân Viên");
        lblNV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblNV.setIconTextGap(15);

        pnePhu9.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu9.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu9Layout = new javax.swing.GroupLayout(pnePhu9);
        pnePhu9.setLayout(pnePhu9Layout);
        pnePhu9Layout.setHorizontalGroup(
            pnePhu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu9Layout.setVerticalGroup(
            pnePhu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnNVLayout = new javax.swing.GroupLayout(pnNV);
        pnNV.setLayout(pnNVLayout);
        pnNVLayout.setHorizontalGroup(
            pnNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNVLayout.createSequentialGroup()
                .addComponent(pnePhu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNVLayout.setVerticalGroup(
            pnNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNV, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu9, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnTK.setBackground(new java.awt.Color(61, 35, 82));
        pnTK.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnTKMouseMoved(evt);
            }
        });
        pnTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnTKMouseExited(evt);
            }
        });

        lblTK.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTK.setForeground(new java.awt.Color(228, 220, 241));
        lblTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Diagram.png"))); // NOI18N
        lblTK.setText("Thống Kê");
        lblTK.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTK.setIconTextGap(15);

        pnePhu10.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu10.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu10Layout = new javax.swing.GroupLayout(pnePhu10);
        pnePhu10.setLayout(pnePhu10Layout);
        pnePhu10Layout.setHorizontalGroup(
            pnePhu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu10Layout.setVerticalGroup(
            pnePhu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTKLayout = new javax.swing.GroupLayout(pnTK);
        pnTK.setLayout(pnTKLayout);
        pnTKLayout.setHorizontalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTKLayout.createSequentialGroup()
                .addComponent(pnePhu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTKLayout.setVerticalGroup(
            pnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTK, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu10, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnTG.setBackground(new java.awt.Color(61, 35, 82));
        pnTG.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnTGMouseMoved(evt);
            }
        });
        pnTG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnTGMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnTGMouseExited(evt);
            }
        });

        lblTG.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTG.setForeground(new java.awt.Color(228, 220, 241));
        lblTG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Date.png"))); // NOI18N
        lblTG.setText("Thời Gian");
        lblTG.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblTG.setIconTextGap(15);

        pnePhu11.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu11.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu11Layout = new javax.swing.GroupLayout(pnePhu11);
        pnePhu11.setLayout(pnePhu11Layout);
        pnePhu11Layout.setHorizontalGroup(
            pnePhu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu11Layout.setVerticalGroup(
            pnePhu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTGLayout = new javax.swing.GroupLayout(pnTG);
        pnTG.setLayout(pnTGLayout);
        pnTGLayout.setHorizontalGroup(
            pnTGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTGLayout.createSequentialGroup()
                .addComponent(pnePhu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTGLayout.setVerticalGroup(
            pnTGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTG, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu11, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnDMK.setBackground(new java.awt.Color(61, 35, 82));
        pnDMK.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnDMKMouseMoved(evt);
            }
        });
        pnDMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDMKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnDMKMouseExited(evt);
            }
        });

        lblDMK.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDMK.setForeground(new java.awt.Color(228, 220, 241));
        lblDMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Dice.png"))); // NOI18N
        lblDMK.setText("Đổi Mật Khẩu");
        lblDMK.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDMK.setIconTextGap(15);

        pnePhu12.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu12.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu12Layout = new javax.swing.GroupLayout(pnePhu12);
        pnePhu12.setLayout(pnePhu12Layout);
        pnePhu12Layout.setHorizontalGroup(
            pnePhu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu12Layout.setVerticalGroup(
            pnePhu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDMKLayout = new javax.swing.GroupLayout(pnDMK);
        pnDMK.setLayout(pnDMKLayout);
        pnDMKLayout.setHorizontalGroup(
            pnDMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDMKLayout.createSequentialGroup()
                .addComponent(pnePhu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDMK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDMKLayout.setVerticalGroup(
            pnDMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDMK, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu12, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        pnDX.setBackground(new java.awt.Color(61, 35, 82));
        pnDX.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnDXMouseMoved(evt);
            }
        });
        pnDX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDXMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnDXMouseExited(evt);
            }
        });

        lblDX.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDX.setForeground(new java.awt.Color(228, 220, 241));
        lblDX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PL/Icon/Exit.png"))); // NOI18N
        lblDX.setText("Đăng Xuất");
        lblDX.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDX.setIconTextGap(15);

        pnePhu14.setBackground(new java.awt.Color(61, 35, 82));
        pnePhu14.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout pnePhu14Layout = new javax.swing.GroupLayout(pnePhu14);
        pnePhu14.setLayout(pnePhu14Layout);
        pnePhu14Layout.setHorizontalGroup(
            pnePhu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnePhu14Layout.setVerticalGroup(
            pnePhu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnDXLayout = new javax.swing.GroupLayout(pnDX);
        pnDX.setLayout(pnDXLayout);
        pnDXLayout.setHorizontalGroup(
            pnDXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDXLayout.createSequentialGroup()
                .addComponent(pnePhu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDX)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDXLayout.setVerticalGroup(
            pnDXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDX, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
            .addComponent(pnePhu14, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnQLP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnQLTang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnLP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnLDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnQLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnQLTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnLDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnDMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnDX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void pnTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTatCaMouseClicked
        trangThai = 0;
        cauHinhPhong();
    }//GEN-LAST:event_pnTatCaMouseClicked

    private void pnPhongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnPhongTrongMouseClicked
        trangThai = 1;
        cauHinhPhong();
    }//GEN-LAST:event_pnPhongTrongMouseClicked

    private void pnDaCoNguoiOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDaCoNguoiOMouseClicked
        trangThai = 2;
        cauHinhPhong();
    }//GEN-LAST:event_pnDaCoNguoiOMouseClicked

    private void pnDangDonDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDangDonDepMouseClicked
        trangThai = 3;
        cauHinhPhong();
    }//GEN-LAST:event_pnDangDonDepMouseClicked

    private void pnQLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLPMouseExited
        pnQLP.setBackground(new Color(61, 35, 82));
        lblQLP.setForeground(new Color(228, 220, 241));
        pnePhu1.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnQLPMouseExited

    private void pnQLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLPMouseMoved
        pnQLP.setBackground(new Color(228, 220, 241));
        lblQLP.setForeground(new Color(61, 35, 82));
        pnePhu1.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnQLPMouseMoved

    private void pnQLTangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLTangMouseMoved
        pnQLTang.setBackground(new Color(228, 220, 241));
        lblQLTang.setForeground(new Color(61, 35, 82));
        pnePhu2.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnQLTangMouseMoved

    private void pnQLTangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLTangMouseExited
        pnQLTang.setBackground(new Color(61, 35, 82));
        lblQLTang.setForeground(new Color(228, 220, 241));
        pnePhu2.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnQLTangMouseExited

    private void pnLPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLPMouseMoved
        pnLP.setBackground(new Color(228, 220, 241));
        lblLP.setForeground(new Color(61, 35, 82));
        pnePhu4.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnLPMouseMoved

    private void pnLPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLPMouseExited
        pnLP.setBackground(new Color(61, 35, 82));
        lblLP.setForeground(new Color(228, 220, 241));
        pnePhu4.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnLPMouseExited

    private void pnDVMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDVMouseMoved
        pnDV.setBackground(new Color(228, 220, 241));
        lblDV.setForeground(new Color(61, 35, 82));
        pnePhu5.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnDVMouseMoved

    private void pnDVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDVMouseExited
        pnDV.setBackground(new Color(61, 35, 82));
        lblDV.setForeground(new Color(228, 220, 241));
        pnePhu5.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnDVMouseExited

    private void pnLDVMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLDVMouseMoved
        pnLDV.setBackground(new Color(228, 220, 241));
        lblLDV.setForeground(new Color(61, 35, 82));
        pnePhu6.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnLDVMouseMoved

    private void pnLDVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLDVMouseExited
        pnLDV.setBackground(new Color(61, 35, 82));
        lblLDV.setForeground(new Color(228, 220, 241));
        pnePhu6.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnLDVMouseExited

    private void pnKHMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKHMouseMoved
        pnKH.setBackground(new Color(228, 220, 241));
        lblKH.setForeground(new Color(61, 35, 82));
        pnePhu7.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnKHMouseMoved

    private void pnKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKHMouseExited
        pnKH.setBackground(new Color(61, 35, 82));
        lblKH.setForeground(new Color(228, 220, 241));
        pnePhu7.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnKHMouseExited

    private void pnNVMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnNVMouseMoved
        pnNV.setBackground(new Color(228, 220, 241));
        lblNV.setForeground(new Color(61, 35, 82));
        pnePhu9.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnNVMouseMoved

    private void pnNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnNVMouseExited
        pnNV.setBackground(new Color(61, 35, 82));
        lblNV.setForeground(new Color(228, 220, 241));
        pnePhu9.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnNVMouseExited

    private void pnTKMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTKMouseMoved
        pnTK.setBackground(new Color(228, 220, 241));
        lblTK.setForeground(new Color(61, 35, 82));
        pnePhu10.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnTKMouseMoved

    private void pnTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTKMouseExited
        pnTK.setBackground(new Color(61, 35, 82));
        lblTK.setForeground(new Color(228, 220, 241));
        pnePhu10.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnTKMouseExited

    private void pnTGMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTGMouseMoved
        pnTG.setBackground(new Color(228, 220, 241));
        lblTG.setForeground(new Color(61, 35, 82));
        pnePhu11.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnTGMouseMoved

    private void pnTGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTGMouseExited
        pnTG.setBackground(new Color(61, 35, 82));
        lblTG.setForeground(new Color(228, 220, 241));
        pnePhu11.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnTGMouseExited

    private void pnDMKMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDMKMouseMoved
        pnDMK.setBackground(new Color(228, 220, 241));
        lblDMK.setForeground(new Color(61, 35, 82));
        pnePhu12.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnDMKMouseMoved

    private void pnDMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDMKMouseExited
        pnDMK.setBackground(new Color(61, 35, 82));
        lblDMK.setForeground(new Color(228, 220, 241));
        pnePhu12.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnDMKMouseExited

    private void pnDXMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDXMouseMoved
        pnDX.setBackground(new Color(228, 220, 241));
        lblDX.setForeground(new Color(61, 35, 82));
        pnePhu14.setBackground(Color.WHITE);
    }//GEN-LAST:event_pnDXMouseMoved

    private void pnDXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDXMouseExited
        pnDX.setBackground(new Color(61, 35, 82));
        lblDX.setForeground(new Color(228, 220, 241));
        pnePhu14.setBackground(new Color(61, 35, 82));
    }//GEN-LAST:event_pnDXMouseExited

    private void pnQLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLPMouseClicked
        if (Auth.isManager()) {
            new Frm_Phong(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnQLPMouseClicked

    private void pnQLTangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLTangMouseClicked
        if (Auth.isManager()) {
            new Frm_Tang().setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnQLTangMouseClicked

    private void pnLPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLPMouseClicked
        if (Auth.isManager()) {
            new Frm_LoaiPhong().setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnLPMouseClicked

    private void pnDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDVMouseClicked
        new Frm_DichVu().setVisible(true);
    }//GEN-LAST:event_pnDVMouseClicked

    private void pnLDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLDVMouseClicked
        new Frm_LoaiDichVu().setVisible(true);
    }//GEN-LAST:event_pnLDVMouseClicked

    private void pnKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKHMouseClicked
        new Frm_KhachHang().setVisible(true);
    }//GEN-LAST:event_pnKHMouseClicked

    private void pnNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnNVMouseClicked
        if (Auth.isManager()) {
            new Frm_NhanVien().setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnNVMouseClicked

    private void pnTGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTGMouseClicked
        if (Auth.isManager()) {
            new Frm_CauHinhGioCheckIn_Out(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnTGMouseClicked

    private void pnTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTKMouseClicked
        if (Auth.isManager()) {
            new Frm_ThongKe(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Bạn không có quyền!");
        }
    }//GEN-LAST:event_pnTKMouseClicked

    private void pnDMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDMKMouseClicked
        if (Auth.isLogin()) {
            new DoiMatKhau().setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập!");
        }
    }//GEN-LAST:event_pnDMKMouseClicked

    private void pnDXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDXMouseClicked
        if (MsgBox.confirm(this, "Bạn có muốn đăng xuất?")) {
            Auth.clear();
            dispose();
            new DangNhap().setVisible(true);
        }

    }//GEN-LAST:event_pnDXMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_HoTelPhuongTo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_HoTelPhuongTo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_HoTelPhuongTo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_HoTelPhuongTo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_HoTelPhuongTo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDMK;
    private javax.swing.JLabel lblDV;
    private javax.swing.JLabel lblDX;
    private javax.swing.JLabel lblDaCoNguoiO;
    private javax.swing.JLabel lblDangDonDep;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblLDV;
    private javax.swing.JLabel lblLP;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblPhongTrong;
    private javax.swing.JLabel lblQLP;
    private javax.swing.JLabel lblQLP12;
    private javax.swing.JLabel lblQLP2;
    private javax.swing.JLabel lblQLP7;
    private javax.swing.JLabel lblQLTang;
    private javax.swing.JLabel lblTG;
    private javax.swing.JLabel lblTK;
    private javax.swing.JLabel lblTatCa;
    private javax.swing.JPanel pnDMK;
    private javax.swing.JPanel pnDV;
    private javax.swing.JPanel pnDX;
    private javax.swing.JPanel pnDaCoNguoiO;
    private javax.swing.JPanel pnDangDonDep;
    private javax.swing.JPanel pnHotelPhuongTo;
    private javax.swing.JPanel pnKH;
    private javax.swing.JPanel pnLDV;
    private javax.swing.JPanel pnLP;
    private javax.swing.JPanel pnNV;
    private javax.swing.JPanel pnPhongTrong;
    private javax.swing.JPanel pnQLP;
    private javax.swing.JPanel pnQLP12;
    private javax.swing.JPanel pnQLP2;
    private javax.swing.JPanel pnQLP7;
    private javax.swing.JPanel pnQLTang;
    private javax.swing.JPanel pnTG;
    private javax.swing.JPanel pnTK;
    private javax.swing.JPanel pnTatCa;
    private javax.swing.JPanel pnePhu1;
    private javax.swing.JPanel pnePhu10;
    private javax.swing.JPanel pnePhu11;
    private javax.swing.JPanel pnePhu12;
    private javax.swing.JPanel pnePhu13;
    private javax.swing.JPanel pnePhu14;
    private javax.swing.JPanel pnePhu2;
    private javax.swing.JPanel pnePhu3;
    private javax.swing.JPanel pnePhu4;
    private javax.swing.JPanel pnePhu5;
    private javax.swing.JPanel pnePhu6;
    private javax.swing.JPanel pnePhu7;
    private javax.swing.JPanel pnePhu8;
    private javax.swing.JPanel pnePhu9;
    // End of variables declaration//GEN-END:variables
}
