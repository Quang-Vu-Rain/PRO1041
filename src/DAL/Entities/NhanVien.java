package DAL.Entities;

public class NhanVien {

    private String _maNhanVien,_tennv, _maKhau, _maQuyen, _email,_ghiChu ;

    public NhanVien() {
    }

    public NhanVien(String _maNhanVien, String _tennv, String _maKhau, String _maQuyen, String _email, String _ghiChu) {
        this._maNhanVien = _maNhanVien;
        this._tennv = _tennv;
        this._maKhau = _maKhau;
        this._maQuyen = _maQuyen;
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

    public String getMaQuyen() {
        return _maQuyen;
    }

    public void setMaQuyen(String _maQuyen) {
        this._maQuyen = _maQuyen;
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
        return _maNhanVien;
    }

    
}
