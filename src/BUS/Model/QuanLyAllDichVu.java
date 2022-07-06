

package BUS.Model;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QuanLyAllDichVu {
    private String _maDichVu, _tenLoaiDichVu, _tenDichVu, _ghiChu;
    private int _donGia;

    public QuanLyAllDichVu() {
    }

    public QuanLyAllDichVu(String _maDichVu, String _tenLoaiDichVu, String _tenDichVu, String _ghiChu, int _donGia) {
        this._maDichVu = _maDichVu;
        this._tenLoaiDichVu = _tenLoaiDichVu;
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
        return "QuanLyAllDichVu{" + "_maDichVu=" + _maDichVu + ", _tenLoaiDichVu=" + _tenLoaiDichVu + ", _tenDichVu=" + _tenDichVu + ", _ghiChu=" + _ghiChu + ", _donGia=" + _donGia + '}';
    }
    
    
    
}
