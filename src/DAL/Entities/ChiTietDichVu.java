package DAL.Entities;

public class ChiTietDichVu {

    private String _maChiTietDichVu, _maHoaDonChiTiet, _maDichVu;
    private int _soLuong;

    public ChiTietDichVu() {
    }

    public ChiTietDichVu(String _maChiTietDichVu, String _maHoaDonChiTiet, String _maDichVu, int _soLuong) {
        this._maChiTietDichVu = _maChiTietDichVu;
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
        this._maDichVu = _maDichVu;
        this._soLuong = _soLuong;
    }

    public String getMaHoaDonChiTiet() {
        return _maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String _maHoaDonChiTiet) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
    }

    public String getMaChiTietDichVu() {
        return _maChiTietDichVu;
    }

    public void setMaChiTietDichVu(String _maChiTietDichVu) {
        this._maChiTietDichVu = _maChiTietDichVu;
    }

    public String getMaDichVu() {
        return _maDichVu;
    }

    public void setMaDichVu(String _maDichVu) {
        this._maDichVu = _maDichVu;
    }

    public int getSoLuong() {
        return _soLuong;
    }

    public void setSoLuong(int _soLuong) {
        this._soLuong = _soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietDichVu{" + "_maChiTietDichVu=" + _maChiTietDichVu + ", _maHoaDonChiTiet=" + _maHoaDonChiTiet + ", _maDichVu=" + _maDichVu + ", _soLuong=" + _soLuong + '}';
    }

}
