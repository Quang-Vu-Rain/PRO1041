package DAL.Entities;

public class DichVu {
    private String _maDichVu, _maLoaiDichVu, _tenDichVu, _ghiChu;
    private int _donGia;

    public DichVu() {
    }

    public DichVu(String _maDichVu, String _maLoaiDichVu, String _tenDichVu, String _ghiChu, int _donGia) {
        this._maDichVu = _maDichVu;
        this._maLoaiDichVu = _maLoaiDichVu;
        this._tenDichVu = _tenDichVu;
        this._ghiChu = _ghiChu;
        this._donGia = _donGia;
    }

    public String getMaDichVu() {
        return _maDichVu;
    }

    public void setMaDichVu(String _maDichVu) {
        this._maDichVu = _maDichVu;
    }

    public String getMaLoaiDichVu() {
        return _maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String _maLoaiDichVu) {
        this._maLoaiDichVu = _maLoaiDichVu;
    }

    public String getTenDichVu() {
        return _tenDichVu;
    }

    public void setTenDichVu(String _tenDichVu) {
        this._tenDichVu = _tenDichVu;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }

    public int getDonGia() {
        return _donGia;
    }

    public void setDonGia(int _donGia) {
        this._donGia = _donGia;
    }

    @Override
    public String toString() {
        return "DichVu{" + "_maDichVu=" + _maDichVu + ", _maLoaiDichVu=" + _maLoaiDichVu + ", _tenDichVu=" + _tenDichVu + ", _ghiChu=" + _ghiChu + ", _donGia=" + _donGia + '}';
    }
    
}
