package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLNhanVienServices {

    public void fillToTable(JTable tb);

    public void filltoSearch(JTable tb, JTextField maNhanVien);

    public void fillToCombo(JComboBox quyen);

    public void filltoComboNv(JComboBox nv);

    public void convert2(JTextField matKhau, JTextArea ghiChu, JTextField maNguoiNhan);

    public void add(JTextField maNhanVien, JTextField tennv, JPasswordField matKhau, JComboBox quyen, JTextField email, JTextArea ghiChu);

    public void edit(JTextField maNhanVien, JTextField tennv, JPasswordField matKhau, JComboBox quyen, JTextField email, JTextArea ghiChu);

    public void delete(JTextField maNhanVien);
}
