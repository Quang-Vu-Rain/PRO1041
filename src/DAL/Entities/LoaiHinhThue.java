package DAL.Entities;

public class LoaiHinhThue {

    private String _maLoaiHinhThue, _tenLoaiHinhThue;

    public LoaiHinhThue() {
    }

    public LoaiHinhThue(String _maLoaiHinhThue, String _tenLoaiHinhThue) {
        this._maLoaiHinhThue = _maLoaiHinhThue;
        this._tenLoaiHinhThue = _tenLoaiHinhThue;
    }

    public String getMaLoaiHinhThue() {
        return _maLoaiHinhThue;
    }

    public void setMaLoaiHinhThue(String _maLoaiHinhThue) {
        this._maLoaiHinhThue = _maLoaiHinhThue;
    }

    public String getTenLoaiHinhThue() {
        return _tenLoaiHinhThue;
    }

    public void setTenLoaiHinhThue(String _tenLoaiHinhThue) {
        this._tenLoaiHinhThue = _tenLoaiHinhThue;
    }

    @Override
    public String toString() {
        return _tenLoaiHinhThue;
    }

}
