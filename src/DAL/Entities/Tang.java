package DAL.Entities;

public class Tang {

    private String _maTang;
    private int _soTang;

    public Tang() {
    }

    public Tang(String _maTang, int _soTang) {
        this._maTang = _maTang;
        this._soTang = _soTang;
    }

    public String getMaTang() {
        return _maTang;
    }

    public void setMaTang(String _maTang) {
        this._maTang = _maTang;
    }

    public int getSoTang() {
        return _soTang;
    }

    public void setSoTang(int _soTang) {
        this._soTang = _soTang;
    }

    @Override
    public String toString() {
        return "Tầng " + _soTang;
    }

}
