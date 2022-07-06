package BUS.Model;

public class DichVu_Phong {

    private String _maPhong, _tenLoaiDichVu, _tenDichVu, _maChiTietDichVu;
    private int _soLuong, _donGia;

    public DichVu_Phong() {
    }

    public DichVu_Phong(String _maPhong, String _tenLoaiDichVu, String _tenDichVu, String _maChiTietDichVu, int _soLuong, int _donGia) {
        this._maPhong = _maPhong;
        this._tenLoaiDichVu = _tenLoaiDichVu;
        this._tenDichVu = _tenDichVu;
        this._maChiTietDichVu = _maChiTietDichVu;
        this._soLuong = _soLuong;
        this._donGia = _donGia;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public String getTenLoaiDichVu() {
        return _tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String _tenLoaiDichVu) {
        this._tenLoaiDichVu = _tenLoaiDichVu;
    }

    public String getTenDichVu() {
        return _tenDichVu;
    }

    public void setTenDichVu(String _tenDichVu) {
        this._tenDichVu = _tenDichVu;
    }

    public String getMaChiTietDichVu() {
        return _maChiTietDichVu;
    }

    public void setMaChiTietDichVu(String _maChiTietDichVu) {
        this._maChiTietDichVu = _maChiTietDichVu;
    }

    public int getSoLuong() {
        return _soLuong;
    }

    public void setSoLuong(int _soLuong) {
        this._soLuong = _soLuong;
    }

    public int getDonGia() {
        return _donGia;
    }

    public void setDonGia(int _donGia) {
        this._donGia = _donGia;
    }

    @Override
    public String toString() {
        return "DichVu_Phong{" + "_maPhong=" + _maPhong + ", _tenLoaiDichVu=" + _tenLoaiDichVu + ", _tenDichVu=" + _tenDichVu + ", _maChiTietDichVu=" + _maChiTietDichVu + ", _soLuong=" + _soLuong + ", _donGia=" + _donGia + '}';
    }

}
