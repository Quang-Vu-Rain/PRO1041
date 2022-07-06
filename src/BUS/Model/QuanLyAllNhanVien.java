package BUS.Model;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QuanLyAllNhanVien {

    private String _maNhanVien, _tennv, _maKhau, _tenQuyen, _email, _ghiChu;

    public QuanLyAllNhanVien() {
    }

    public QuanLyAllNhanVien(String _maNhanVien, String _tennv, String _maKhau, String _tenQuyen, String _email, String _ghiChu) {
        this._maNhanVien = _maNhanVien;
        this._tennv = _tennv;
        this._maKhau = _maKhau;
        this._tenQuyen = _tenQuyen;
        this._email = _email;
        this._ghiChu = _ghiChu;
    }

    public String getMaNhanVien() {
        return _maNhanVien;
    }

    public void setMaNhanVien(String _maNhanVien) {
        this._maNhanVien = _maNhanVien;
    }

    public String getTennv() {
        return _tennv;
    }

    public void setTennv(String _tennv) {
        this._tennv = _tennv;
    }

    public String getMaKhau() {
        return _maKhau;
    }

    public void setMaKhau(String _maKhau) {
        this._maKhau = _maKhau;
    }

    public String getTenQuyen() {
        return _tenQuyen;
    }

    public void setTenQuyen(String _tenQuyen) {
        this._tenQuyen = _tenQuyen;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }

    @Override
    public String toString() {
        return "QuanLyAllNhanVien{" + "_maNhanVien=" + _maNhanVien + ", _tennv=" + _tennv + ", _maKhau=" + _maKhau + ", _tenQuyen=" + _tenQuyen + ", _email=" + _email + ", _ghiChu=" + _ghiChu + '}';
    }

}
