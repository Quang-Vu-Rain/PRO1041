package DAL.Entities;

public class KhachHang {

    private String _maKhachHang, _tenKhachHang, _soDienThoai, _soCCCD, _ghiChu;
    private int _tuoi;
    private boolean _gioiTinh;

    public KhachHang() {
    }

    public KhachHang(String _maKhachHang, String _tenKhachHang, String _soDienThoai, String _soCCCD, String _ghiChu, int _tuoi, boolean _gioiTinh) {
        this._maKhachHang = _maKhachHang;
        this._tenKhachHang = _tenKhachHang;
        this._soDienThoai = _soDienThoai;
        this._soCCCD = _soCCCD;
        this._ghiChu = _ghiChu;
        this._tuoi = _tuoi;
        this._gioiTinh = _gioiTinh;
    }

    public String getMaKhachHang() {
        return _maKhachHang;
    }

    public void setMaKhachHang(String _maKhachHang) {
        this._maKhachHang = _maKhachHang;
    }

    public String getTenKhachHang() {
        return _tenKhachHang;
    }

    public void setTenKhachHang(String _tenKhachHang) {
        this._tenKhachHang = _tenKhachHang;
    }

    public String getSoDienThoai() {
        return _soDienThoai;
    }

    public void setSoDienThoai(String _soDienThoai) {
        this._soDienThoai = _soDienThoai;
    }

    public String getSoCCCD() {
        return _soCCCD;
    }

    public void setSoCCCD(String _soCCCD) {
        this._soCCCD = _soCCCD;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }

    public int getTuoi() {
        return _tuoi;
    }

    public void setTuoi(int _tuoi) {
        this._tuoi = _tuoi;
    }

    public boolean isGioiTinh() {
        return _gioiTinh;
    }

    public void setGioiTinh(boolean _gioiTinh) {
        this._gioiTinh = _gioiTinh;
    }

    @Override
    public String toString() {
        return _tenKhachHang;
    }

}
