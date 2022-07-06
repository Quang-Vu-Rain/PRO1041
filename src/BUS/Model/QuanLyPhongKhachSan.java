package BUS.Model;

public class QuanLyPhongKhachSan {

    private String _maPhong, _tenLoaiPhong, _ghiChu;
    private int _trangThai, _soTang, _giaTheoGio, _giaTheoNgay;

    public QuanLyPhongKhachSan() {
    }

    public QuanLyPhongKhachSan(String _maPhong, String _tenLoaiPhong, String _ghiChu, int _trangThai, int _soTang, int _giaTheoGio, int _giaTheoNgay) {
        this._maPhong = _maPhong;
        this._tenLoaiPhong = _tenLoaiPhong;
        this._ghiChu = _ghiChu;
        this._trangThai = _trangThai;
        this._soTang = _soTang;
        this._giaTheoGio = _giaTheoGio;
        this._giaTheoNgay = _giaTheoNgay;
    }

    public int getGiaTheoGio() {
        return _giaTheoGio;
    }

    public void setGiaTheoGio(int _giaTheoGio) {
        this._giaTheoGio = _giaTheoGio;
    }

    public int getGiaTheoNgay() {
        return _giaTheoNgay;
    }

    public void setGiaTheoNgay(int _giaTheoNgay) {
        this._giaTheoNgay = _giaTheoNgay;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public String getTenLoaiPhong() {
        return _tenLoaiPhong;
    }

    public void setTenLoaiPhong(String _tenLoaiPhong) {
        this._tenLoaiPhong = _tenLoaiPhong;
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

    public int getSoTang() {
        return _soTang;
    }

    public void setSoTang(int _soTang) {
        this._soTang = _soTang;
    }

    @Override
    public String toString() {
        return "QuanLyPhongKhachSan{" + "_maPhong=" + _maPhong + ", _tenLoaiPhong=" + _tenLoaiPhong + ", _ghiChu=" + _ghiChu + ", _trangThai=" + _trangThai + ", _soTang=" + _soTang + ", _giaTheoGio=" + _giaTheoGio + ", _giaTheoNgay=" + _giaTheoNgay + '}';
    }

}
