
package BUS.IServices;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLTangServices {
    public void fillToTable(JTable tb);
    public void add(JTextField maTang,JTextField soTang);
    public void edit(JTextField maTang,JTextField soTang);
    public void delete(JTextField maTang);    
}
