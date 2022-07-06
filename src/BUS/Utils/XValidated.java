package BUS.Utils;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class XValidated {

    public static boolean checkRong(JTextField tf, String mss) {
        if (tf.getText().isEmpty()) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkRongPass(JPasswordField tf, String mss) {
        if (tf.getPassword().length == 0) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkRongTA(JTextArea tf, String mss) {
        if (tf.getText().isEmpty()) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSoThuc(JTextField tf, String mss) {
        try {
            double so = Double.parseDouble(tf.getText());
        } catch (Exception e) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSoNguyen(JTextField tf, String mss) {
        try {
            int so = Integer.parseInt(tf.getText());
        } catch (Exception e) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkKhoang(JTextField tf, String mss, int min, int max) {
        double so = Double.parseDouble(tf.getText());
        if (so < min || so > max) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkKhoangLonHon(JTextField tf, String mss, int min) {
        double so = Double.parseDouble(tf.getText());
        if (so <= min) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkNgay(JTextField tf, String mss) {
        try {
            Date ngay = XDate.toDate(tf.getText(), "dd-MM-yyyy");
        } catch (Exception e) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkGio(JTextField tf, String mss) {
        try {
            Date ngay = XDate.toDate(tf.getText(), "HH:mm:ss");
        } catch (Exception e) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkMail(JTextField tf, String mss) {
        String email = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (tf.getText().matches(email) == false) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSDT(JTextField tf, String mss) {
        String soDt = "^[0-9]{10}$";
        if (tf.getText().matches(soDt) == false) {
            MsgBox.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkTrongNgay(JDateChooser dc, String mss) {
        try {
            Date ngay = dc.getDate();
            return true;
        } catch (Exception e) {
            MsgBox.alert(null, mss);
            dc.requestFocus();
            return false;
        }
    }
}
