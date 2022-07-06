package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLGiaoCaServices {
    
    public void fillToTable(JTable tb);
    
    public void filltoSearch(JTable tb, JTextField maNhanVien);

    public void convert(JTextField matKhau, JTextArea ghiChu, JComboBox maNguoiNhan);

    public void editStt(JTextField maNhanVien);
    
    public void setTiendauca(int tiendauca);
    
    public void add(String maGiaoca, JTextField manv, JTextField tiendauca, 
    JTextField tongtienthe, JTextField tongtienmat,JTextField tienphatsinh,
    JTextField tienchenhlech,JTextField tongdoanhthuca,JTextField sotienthucgiao, String gionhanca,String giogiaoca, JTextArea ghiChu);
}
