package DAL.Entities;

public class Quyen {

    private String _maQuyen, _tenQuyen;

    public Quyen() {
    }

    public Quyen(String _maQuyen, String _tenQuyen) {
        this._maQuyen = _maQuyen;
        this._tenQuyen = _tenQuyen;
    }

    public String getMaQuyen() {
        return _maQuyen;
    }

    public void setMaQuyen(String _maQuyen) {
        this._maQuyen = _maQuyen;
    }

    public String getTenQuyen() {
        return _tenQuyen;
    }

    public void setTenQuyen(String _tenQuyen) {
        this._tenQuyen = _tenQuyen;
    }

    @Override
    public String toString() {
        return _maQuyen;
    }

}
