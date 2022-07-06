
package BUS.IServices;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLLoaiDichVuServices {
    public void fillToTable(JTable tb);
    public void add(JTextField maLoaiDichVu,JTextField tenLoaiDichVu, JTextArea ghiChu);
    public void edit(JTextField maLoaiDichVu,JTextField tenLoaiDichVu, JTextArea ghiChu);
    public void delete(JTextField maLoaiDichVu);
}
