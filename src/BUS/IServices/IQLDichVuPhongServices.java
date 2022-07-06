package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

public interface IQLDichVuPhongServices {

    public void fillLoaiDichVu(JComboBox cbo);
    
    public void fillDichVu(JPanel pn, String maLoaiDichVu);

    public void fillDichVuPhong(JTable tb, String maPhong);
}
