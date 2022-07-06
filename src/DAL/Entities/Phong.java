package DAL.Entities;

public class Phong {

    private String _maPhong, _maLoaiPhong, _maTang, _ghiChu;
    private int _trangThai;

    public Phong() {
    }

    public Phong(String _maPhong, String _maLoaiPhong, String _maTang, String _ghiChu, int _trangThai) {
        this._maPhong = _maPhong;
        this._maLoaiPhong = _maLoaiPhong;
        this._maTang = _maTang;
        this._ghiChu = _ghiChu;
        this._trangThai = _trangThai;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public String getMaLoaiPhong() {
        return _maLoaiPhong;
    }

    public void setMaLoaiPhong(String _maLoaiPhong) {
        this._maLoaiPhong = _maLoaiPhong;
    }

    public String getMaTang() {
        return _maTang;
    }

    public void setMaTang(String _maTang) {
        this._maTang = _maTang;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }

    public int getTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(int _trangThai) {
        this._trangThai = _trangThai;
    }

    @Override
    public String toString() {
        return "Phong{" + "_maPhong=" + _maPhong + ", _maLoaiPhong=" + _maLoaiPhong + ", _maTang=" + _maTang + ", _ghiChu=" + _ghiChu + ", _trangThai=" + _trangThai + '}';
    }

}
