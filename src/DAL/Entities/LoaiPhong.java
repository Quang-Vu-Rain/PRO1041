package DAL.Entities;

public class LoaiPhong {

    private String _maLoaiPhong, _tenLoaiPhong;
    private int _giaTheoNgay, _giaTheoGio;

    public LoaiPhong() {
    }

    public LoaiPhong(String _maLoaiPhong, String _tenLoaiPhong, int _giaTheoNgay, int _giaTheoGio) {
        this._maLoaiPhong = _maLoaiPhong;
        this._tenLoaiPhong = _tenLoaiPhong;
        this._giaTheoNgay = _giaTheoNgay;
        this._giaTheoGio = _giaTheoGio;
    }

    public String getMaLoaiPhong() {
        return _maLoaiPhong;
    }

    public void setMaLoaiPhong(String _maLoaiPhong) {
        this._maLoaiPhong = _maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return _tenLoaiPhong;
    }

    public void setTenLoaiPhong(String _tenLoaiPhong) {
        this._tenLoaiPhong = _tenLoaiPhong;
    }

    public int getGiaTheoNgay() {
        return _giaTheoNgay;
    }

    public void setGiaTheoNgay(int _giaTheoNgay) {
        this._giaTheoNgay = _giaTheoNgay;
    }

    public int getGiaTheoGio() {
        return _giaTheoGio;
    }

    public void setGiaTheoGio(int _giaTheoGio) {
        this._giaTheoGio = _giaTheoGio;
    }

    @Override
    public String toString() {
        return _tenLoaiPhong;
    }

}
