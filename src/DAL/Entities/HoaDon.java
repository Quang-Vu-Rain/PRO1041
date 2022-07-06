package DAL.Entities;

import java.util.Date;

public class HoaDon {

    private String _maHoaDon, _maKhachHang, _maNhanVien;
    private int _soNguoi;
    private boolean _trangThai;

    public HoaDon() {
    }

    public HoaDon(String _maHoaDon, String _maKhachHang, String _maNhanVien, int _soNguoi, boolean _trangThai) {
        this._maHoaDon = _maHoaDon;
        this._maKhachHang = _maKhachHang;
        this._maNhanVien = _maNhanVien;
        this._soNguoi = _soNguoi;
        this._trangThai = _trangThai;
    }

    public String getMaHoaDon() {
        return _maHoaDon;
    }

    public void setMaHoaDon(String _maHoaDon) {
        this._maHoaDon = _maHoaDon;
    }

    public String getMaKhachHang() {
        return _maKhachHang;
    }

    public void setMaKhachHang(String _maKhachHang) {
        this._maKhachHang = _maKhachHang;
    }

    public String getMaNhanVien() {
        return _maNhanVien;
    }

    public void setMaNhanVien(String _maNhanVien) {
        this._maNhanVien = _maNhanVien;
    }

    public int getSoNguoi() {
        return _soNguoi;
    }

    public void setSoNguoi(int _soNguoi) {
        this._soNguoi = _soNguoi;
    }

    public boolean isTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(boolean _trangThai) {
        this._trangThai = _trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "_maHoaDon=" + _maHoaDon + ", _maKhachHang=" + _maKhachHang + ", _maNhanVien=" + _maNhanVien + ", _soNguoi=" + _soNguoi + ", _trangThai=" + _trangThai + '}';
    }

}
