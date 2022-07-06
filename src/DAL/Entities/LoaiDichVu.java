package DAL.Entities;

public class LoaiDichVu {

    private String _maLoaiDichVu, _tenLoaiDichVu, _ghiChu;

    public LoaiDichVu() {
    }

    public LoaiDichVu(String _maLoaiDichVu, String _tenLoaiDichVu, String _ghiChu) {
        this._maLoaiDichVu = _maLoaiDichVu;
        this._tenLoaiDichVu = _tenLoaiDichVu;
        this._ghiChu = _ghiChu;
    }

    public String getMaLoaiDichVu() {
        return _maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String _maLoaiDichVu) {
        this._maLoaiDichVu = _maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return _tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String _tenLoaiDichVu) {
        this._tenLoaiDichVu = _tenLoaiDichVu;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String _ghiChu) {
        this._ghiChu = _ghiChu;
    }

    @Override
    public String toString() {
        return _tenLoaiDichVu;
    }

}
