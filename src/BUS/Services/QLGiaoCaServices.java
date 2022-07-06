package BUS.Services;

import BUS.IServices.IQLGiaoCaServices;
import DAL.Entities.GiaoCa;
import DAL.Entities.NhanVien;
import DAL.IServices.IGiaoCaServices;
import DAL.IServices.INhanVienServices;
import DAL.IServices.IQuyenServices;
import DAL.Services.GiaoCaServices;
import DAL.Services.NhanVienServices;
import DAL.Services.QuyenServices;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLGiaoCaServices implements IQLGiaoCaServices {

    IGiaoCaServices _listGiaoca = new GiaoCaServices();
    INhanVienServices _listNhanVien = new NhanVienServices();
    IQuyenServices _iQuyen = new QuyenServices();
    ImageIcon iconTick = new ImageIcon("src\\PL\\Icon\\Tick.png");
    ImageIcon iconTrash = new ImageIcon("src\\PL\\Icon\\Trash.png");
    ImageIcon iconError = new ImageIcon("src\\PL\\Icon\\Problem.png");

    @Override
    public void convert(JTextField matKhau, JTextArea ghiChu, JComboBox maNguoiNhan) {
        NhanVien nv = new NhanVien();
        nv.setGhiChu(ghiChu.getText().toString());

        List<GiaoCa> list = _listGiaoca.getListGiaoCa();
//        for (int i = 0; i < list.size(); i++) {
//            if ((!matKhau.getText().toString().equals(list.get(i).getMaKhau()))) {
//                JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu, vui lòng nhập lại !", "Thông báo", 0, iconError);
//                return;
//            } else {
//                nv.setMaNhanVien(maNguoiNhan.getModel().getSelectedItem().toString());
//            }
//        }
        _listNhanVien.convert(nv);
    }

    @Override
    public void editStt(JTextField maNhanVien) {
        GiaoCa gc = new GiaoCa();
        gc.setManv(maNhanVien.getText().toString());
        _listGiaoca.updateSttNhanVien(gc);
    }

    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            //  DecimalFormat df = new DecimalFormat("###,###.##VND");
            List<GiaoCa> list = _listGiaoca.getListGiaoCa();
            for (GiaoCa gc : list) {
                Object[] row = {gc.getMagiaoca(), gc.getManv(), gc.getTiendaucanhan(), gc.getTongtienthe(), gc.getTongtienmat(), gc.getTienphatsinh(), gc.getTienchenhlech(), gc.getTongdoanhthuca(), gc.getSotienthucgiao(), gc.getGionhanca(), gc.getGiogiaoca(), gc.getGhichu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filltoSearch(JTable tb, JTextField maNhanVien) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<GiaoCa> list = _listGiaoca.selectbyKeyword(maNhanVien.getText().toString());
            for (GiaoCa gc : list) {
                Object[] row = {gc.getMagiaoca(), gc.getManv(), gc.getTiendaucanhan(), gc.getTongtienthe(), gc.getTongtienmat(), gc.getTienphatsinh(), gc.getTienchenhlech(), gc.getGionhanca(), gc.getGiogiaoca(), gc.getGhichu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTiendauca(int tiendauca) {
        GiaoCa gc = new GiaoCa();
        gc.setTiendaucanhan(tiendauca);
        _listGiaoca.setTiendauca(gc);
    }

    @Override
    public void add(String maGiaoca, JTextField manv, JTextField tiendauca, JTextField tongtienthe, JTextField tongtienmat, JTextField tienphatsinh, JTextField tienchenhlech, JTextField tongdoanhthuca, JTextField sotienthucgiao, String gionhanca, String giogiaoca, JTextArea ghiChu) {
        GiaoCa gc = new GiaoCa();
        gc.setMagiaoca(maGiaoca);
        gc.setManv(manv.getText().toString());
        gc.setTiendaucanhan(Integer.valueOf(tiendauca.getText().toString()));
        gc.setTongtienthe(Integer.valueOf(tongtienthe.getText().toString()));
        gc.setTongtienmat(Integer.valueOf(tongtienmat.getText().toString()));
        gc.setTienphatsinh(Integer.valueOf(tienphatsinh.getText().toString()));
        gc.setTienchenhlech(Integer.valueOf(tienchenhlech.getText().toString()));
        gc.setTongdoanhthuca(Integer.valueOf(tongdoanhthuca.getText().toString()));
        gc.setSotienthucgiao(Integer.valueOf(sotienthucgiao.getText().toString()));
        gc.setGionhanca(gionhanca);
        gc.setGiogiaoca(giogiaoca);
        gc.setGhichu(ghiChu.getText());
        _listGiaoca.addGiaoCa(gc);
    }

}
