package BUS.Model;

import java.util.Date;

public class ThongTinThuePhong {

    private String _maHoaDonChiTiet, _tenKhachHang, _tenLoaiHinhThue, _maPhong;
    private Date _ngayThue, _ngayTraDuKien, _ngayTraPhong;
    private int _tienDatCoc, _giaTheoGio, _giaTheoNgay, _trangThai;

    public ThongTinThuePhong() {
    }

    public ThongTinThuePhong(String _maHoaDonChiTiet, String _tenKhachHang, String _tenLoaiHinhThue, String _maPhong, Date _ngayThue, Date _ngayTraDuKien, Date _ngayTraPhong, int _tienDatCoc, int _giaTheoGio, int _giaTheoNgay, int _trangThai) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
        this._tenKhachHang = _tenKhachHang;
        this._tenLoaiHinhThue = _tenLoaiHinhThue;
        this._maPhong = _maPhong;
        this._ngayThue = _ngayThue;
        this._ngayTraDuKien = _ngayTraDuKien;
        this._ngayTraPhong = _ngayTraPhong;
        this._tienDatCoc = _tienDatCoc;
        this._giaTheoGio = _giaTheoGio;
        this._giaTheoNgay = _giaTheoNgay;
        this._trangThai = _trangThai;
    }

    public String getMaHoaDonChiTiet() {
        return _maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String _maHoaDonChiTiet) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
    }

    public String getTenKhachHang() {
        return _tenKhachHang;
    }

    public void setTenKhachHang(String _tenKhachHang) {
        this._tenKhachHang = _tenKhachHang;
    }

    public String getTenLoaiHinhThue() {
        return _tenLoaiHinhThue;
    }

    public void setTenLoaiHinhThue(String _tenLoaiHinhThue) {
        this._tenLoaiHinhThue = _tenLoaiHinhThue;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public Date getNgayThue() {
        return _ngayThue;
    }

    public void setNgayThue(Date _ngayThue) {
        this._ngayThue = _ngayThue;
    }

    public Date getNgayTraDuKien() {
        return _ngayTraDuKien;
    }

    public void setNgayTraDuKien(Date _ngayTraDuKien) {
        this._ngayTraDuKien = _ngayTraDuKien;
    }

    public Date getNgayTraPhong() {
        return _ngayTraPhong;
    }

    public void setNgayTraPhong(Date _ngayTraPhong) {
        this._ngayTraPhong = _ngayTraPhong;
    }

    public int getTienDatCoc() {
        return _tienDatCoc;
    }

    public void setTienDatCoc(int _tienDatCoc) {
        this._tienDatCoc = _tienDatCoc;
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

    public int getTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(int _trangThai) {
        this._trangThai = _trangThai;
    }

    @Override
    public String toString() {
        return "ThongTinThuePhong{" + "_maHoaDonChiTiet=" + _maHoaDonChiTiet + ", _tenKhachHang=" + _tenKhachHang + ", _tenLoaiHinhThue=" + _tenLoaiHinhThue + ", _maPhong=" + _maPhong + ", _ngayThue=" + _ngayThue + ", _ngayTraDuKien=" + _ngayTraDuKien + ", _ngayTraPhong=" + _ngayTraPhong + ", _tienDatCoc=" + _tienDatCoc + ", _giaTheoGio=" + _giaTheoGio + ", _giaTheoNgay=" + _giaTheoNgay + ", _trangThai=" + _trangThai + '}';
    }

}
