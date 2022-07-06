package DAL.Entities;

public class HinhThucThanhToan {

    private String _maHinhThucThanhToan, _tenHinhThucThanhToan;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String _maHinhThucThanhToan, String _tenHinhThucThanhToan) {
        this._maHinhThucThanhToan = _maHinhThucThanhToan;
        this._tenHinhThucThanhToan = _tenHinhThucThanhToan;
    }

    public String getMaHinhThucThanhToan() {
        return _maHinhThucThanhToan;
    }

    public void setMaHinhThucThanhToan(String _maHinhThucThanhToan) {
        this._maHinhThucThanhToan = _maHinhThucThanhToan;
    }

    public String getTenHinhThucThanhToan() {
        return _tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String _tenHinhThucThanhToan) {
        this._tenHinhThucThanhToan = _tenHinhThucThanhToan;
    }

    @Override
    public String toString() {
        return _tenHinhThucThanhToan;
    }

}
