/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.IQLPhongKhachSanServices;
import BUS.Model.QuanLyPhongKhachSan;
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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class QLPhongKhachSanServices implements IQLPhongKhachSanServices {
    
    IQuanLyPhongKhachSanServices _listPhong = new QuanLyPhongKhachSanServices();
    ITangServices _iTang = new TangServices();
    ILoaiPhongServices _iLoaiPhong = new LoaiPhongServices();
    IPhongServices _iPhong = new PhongServices();
    
    @Override
    public void fillToTablePhong(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<QuanLyPhongKhachSan> list = _listPhong.getListPhong(0);
            for (QuanLyPhongKhachSan lp : list) {
                Object[] row = {lp.getMaPhong(), lp.getTenLoaiPhong(), lp.getSoTang(), lp.getGiaTheoGio(), lp.getGiaTheoNgay(), lp.getTrangThai() == 1 ? "Trống" : lp.getTrangThai() == 2 ? "Đã có người ở" : "Đang dọn dẹp", lp.getGhiChu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void fillToComboBoxTang(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<Tang> list = _iTang.getListTang();
        for (Tang cd : list) {
            model.addElement(cd);
        }
    }
    
    @Override
    public void fillToComboBoxLoaiPhong(JComboBox cbo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        List<LoaiPhong> list = _iLoaiPhong.getListLoaiPhong();
        for (LoaiPhong cd : list) {
            model.addElement(cd);
        }
    }
    
    @Override
    public void themPhong(JComboBox cboTang, JComboBox cboPhong, JTextField maPhong, JComboBox trangThai, JTextArea ghiChu) {
        Tang _tang = (Tang) cboTang.getSelectedItem();
        LoaiPhong _loaiPhong = (LoaiPhong) cboPhong.getSelectedItem();
        Phong _phong = new Phong();
        _phong.setMaPhong(maPhong.getText());
        _phong.setMaLoaiPhong(_loaiPhong.getMaLoaiPhong());
        _phong.setMaTang(_tang.getMaTang());
        _phong.setTrangThai(trangThai.getSelectedItem().equals("Trống") ? 1 : trangThai.getSelectedItem().equals("Đã có người ở") ? 2 : 3);
        _phong.setGhiChu(ghiChu.getText());
        _iPhong.addPhong(_phong);
    }
    
    @Override
    public void suaphong(JComboBox cboTang, JComboBox cboPhong, JTextField maPhong, JComboBox trangThai, JTextArea ghiChu) {
        Tang _tang = (Tang) cboTang.getSelectedItem();
        LoaiPhong _loaiPhong = (LoaiPhong) cboPhong.getSelectedItem();
        Phong _phong = new Phong();
        _phong.setMaPhong(maPhong.getText());
        _phong.setMaLoaiPhong(_loaiPhong.getMaLoaiPhong());
        _phong.setMaTang(_tang.getMaTang());
        _phong.setTrangThai(trangThai.getSelectedItem().equals("Trống") ? 1 : trangThai.getSelectedItem().equals("Đã có người ở") ? 2 : 3);
        _phong.setGhiChu(ghiChu.getText());
        _iPhong.updatePhong(_phong);
    }
    
}
