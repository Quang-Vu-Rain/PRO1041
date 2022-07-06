package DAL.Entities;

import java.util.Date;

public class ChiTietHoaDon {

    private String _maHoaDonChiTiet, _maHoaDon, _maPhong, _maHinhThucThanhToan, _maLoaiHinhThue, _GhiChu;
    private int _soNgayThue, _soGioThue, _phuThuCheckIn, _phuThuCheckOut, _tienKhachDua, _tienTraLai, _trangThai, _tongTienPhong, _tongTienDichVu, _tienTheNganHang, _tienDatCoc;
    private Date _ngayThue, _ngayDuKienTra, _ngayThanhToan, _ngayTraPhong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String _maHoaDonChiTiet, String _maHoaDon, String _maPhong, String _maHinhThucThanhToan, String _maLoaiHinhThue, String _GhiChu, int _soNgayThue, int _soGioThue, int _phuThuCheckIn, int _phuThuCheckOut, int _tienKhachDua, int _tienTraLai, int _trangThai, int _tongTienPhong, int _tongTienDichVu, int _tienTheNganHang, int _tienDatCoc, Date _ngayThue, Date _ngayDuKienTra, Date _ngayThanhToan, Date _ngayTraPhong) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
        this._maHoaDon = _maHoaDon;
        this._maPhong = _maPhong;
        this._maHinhThucThanhToan = _maHinhThucThanhToan;
        this._maLoaiHinhThue = _maLoaiHinhThue;
        this._GhiChu = _GhiChu;
        this._soNgayThue = _soNgayThue;
        this._soGioThue = _soGioThue;
        this._phuThuCheckIn = _phuThuCheckIn;
        this._phuThuCheckOut = _phuThuCheckOut;
        this._tienKhachDua = _tienKhachDua;
        this._tienTraLai = _tienTraLai;
        this._trangThai = _trangThai;
        this._tongTienPhong = _tongTienPhong;
        this._tongTienDichVu = _tongTienDichVu;
        this._tienTheNganHang = _tienTheNganHang;
        this._tienDatCoc = _tienDatCoc;
        this._ngayThue = _ngayThue;
        this._ngayDuKienTra = _ngayDuKienTra;
        this._ngayThanhToan = _ngayThanhToan;
        this._ngayTraPhong = _ngayTraPhong;
    }

    public String getMaHoaDonChiTiet() {
        return _maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String _maHoaDonChiTiet) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
    }

    public String getMaHoaDon() {
        return _maHoaDon;
    }

    public void setMaHoaDon(String _maHoaDon) {
        this._maHoaDon = _maHoaDon;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public String getMaHinhThucThanhToan() {
        return _maHinhThucThanhToan;
    }

    public void setMaHinhThucThanhToan(String _maHinhThucThanhToan) {
        this._maHinhThucThanhToan = _maHinhThucThanhToan;
    }

    public String getMaLoaiHinhThue() {
        return _maLoaiHinhThue;
    }

    public void setMaLoaiHinhThue(String _maLoaiHinhThue) {
        this._maLoaiHinhThue = _maLoaiHinhThue;
    }

    public String getGhiChu() {
        return _GhiChu;
    }

    public void setGhiChu(String _GhiChu) {
        this._GhiChu = _GhiChu;
    }

    public int getSoNgayThue() {
        return _soNgayThue;
    }

    public void setSoNgayThue(int _soNgayThue) {
        this._soNgayThue = _soNgayThue;
    }

    public int getSoGioThue() {
        return _soGioThue;
    }

    public void setSoGioThue(int _soGioThue) {
        this._soGioThue = _soGioThue;
    }

    public int getPhuThuCheckIn() {
        return _phuThuCheckIn;
    }

    public void setPhuThuCheckIn(int _phuThuCheckIn) {
        this._phuThuCheckIn = _phuThuCheckIn;
    }

    public int getPhuThuCheckOut() {
        return _phuThuCheckOut;
    }

    public void setPhuThuCheckOut(int _phuThuCheckOut) {
        this._phuThuCheckOut = _phuThuCheckOut;
    }

    public int getTienKhachDua() {
        return _tienKhachDua;
    }

    public void setTienKhachDua(int _tienKhachDua) {
        this._tienKhachDua = _tienKhachDua;
    }

    public int getTienTraLai() {
        return _tienTraLai;
    }

    public void setTienTraLai(int _tienTraLai) {
        this._tienTraLai = _tienTraLai;
    }

    public int getTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(int _trangThai) {
        this._trangThai = _trangThai;
    }

    public int getTongTienPhong() {
        return _tongTienPhong;
    }

    public void setTongTienPhong(int _tongTienPhong) {
        this._tongTienPhong = _tongTienPhong;
    }

    public int getTongTienDichVu() {
        return _tongTienDichVu;
    }

    public void setTongTienDichVu(int _tongTienDichVu) {
        this._tongTienDichVu = _tongTienDichVu;
    }

    public int getTienTheNganHang() {
        return _tienTheNganHang;
    }

    public void setTienTheNganHang(int _tienTheNganHang) {
        this._tienTheNganHang = _tienTheNganHang;
    }

    public int getTienDatCoc() {
        return _tienDatCoc;
    }

    public void setTienDatCoc(int _tienDatCoc) {
        this._tienDatCoc = _tienDatCoc;
    }

    public Date getNgayThue() {
        return _ngayThue;
    }

    public void setNgayThue(Date _ngayThue) {
        this._ngayThue = _ngayThue;
    }

    public Date getNgayDuKienTra() {
        return _ngayDuKienTra;
    }

    public void setNgayDuKienTra(Date _ngayDuKienTra) {
        this._ngayDuKienTra = _ngayDuKienTra;
    }

    public Date getNgayThanhToan() {
        return _ngayThanhToan;
    }

    public void setNgayThanhToan(Date _ngayThanhToan) {
        this._ngayThanhToan = _ngayThanhToan;
    }

    public Date getNgayTraPhong() {
        return _ngayTraPhong;
    }

    public void setNgayTraPhong(Date _ngayTraPhong) {
        this._ngayTraPhong = _ngayTraPhong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "_maHoaDonChiTiet=" + _maHoaDonChiTiet + ", _maHoaDon=" + _maHoaDon + ", _maPhong=" + _maPhong + ", _maHinhThucThanhToan=" + _maHinhThucThanhToan + ", _maLoaiHinhThue=" + _maLoaiHinhThue + ", _GhiChu=" + _GhiChu + ", _soNgayThue=" + _soNgayThue + ", _soGioThue=" + _soGioThue + ", _phuThuCheckIn=" + _phuThuCheckIn + ", _phuThuCheckOut=" + _phuThuCheckOut + ", _tienKhachDua=" + _tienKhachDua + ", _tienTraLai=" + _tienTraLai + ", _trangThai=" + _trangThai + ", _tongTienPhong=" + _tongTienPhong + ", _tongTienDichVu=" + _tongTienDichVu + ", _tienTheNganHang=" + _tienTheNganHang + ", _tienDatCoc=" + _tienDatCoc + ", _ngayThue=" + _ngayThue + ", _ngayDuKienTra=" + _ngayDuKienTra + ", _ngayThanhToan=" + _ngayThanhToan + ", _ngayTraPhong=" + _ngayTraPhong + '}';
    }

}
