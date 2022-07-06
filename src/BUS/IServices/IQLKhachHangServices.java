
package BUS.IServices;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLKhachHangServices {
    public void fillToTable(JTable tb);
    public void filltoSearch(JTable tb, JTextField maNhanVien);
    public void add(JTextField maKhachHang,JTextField tenKhachHang, JTextField tuoiKhachHang, JRadioButton gioiTinh, JTextField sdt, JTextField cccd, JTextArea ghiChu);
    public void edit(JTextField maKhachHang,JTextField tenKhachHang, JTextField tuoiKhachHang, JRadioButton gioiTinh, JTextField sdt, JTextField cccd, JTextArea ghiChu);
    public void delete(JTextField maKhachHang);
}
