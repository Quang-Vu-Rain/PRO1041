package DAL.Entities;

import java.util.Date;

public class GiaTriKhac {

    private String _maGiaTri, _moTa;
    private Date _thoiGianCheckIn, _thoiGianCheckOut;
    private int _giaTriCheckIn, _giaTriCheckOut;

    public GiaTriKhac() {
    }

    public GiaTriKhac(String _maGiaTri, String _moTa, Date _thoiGianCheckIn, Date _thoiGianCheckOut, int _giaTriCheckIn, int _giaTriCheckOut) {
        this._maGiaTri = _maGiaTri;
        this._moTa = _moTa;
        this._thoiGianCheckIn = _thoiGianCheckIn;
        this._thoiGianCheckOut = _thoiGianCheckOut;
        this._giaTriCheckIn = _giaTriCheckIn;
        this._giaTriCheckOut = _giaTriCheckOut;
    }

    public String getMaGiaTri() {
        return _maGiaTri;
    }

    public void setMaGiaTri(String _maGiaTri) {
        this._maGiaTri = _maGiaTri;
    }

    public String getMoTa() {
        return _moTa;
    }

    public void setMoTa(String _moTa) {
        this._moTa = _moTa;
    }

    public Date getThoiGianCheckIn() {
        return _thoiGianCheckIn;
    }

    public void setThoiGianCheckIn(Date _thoiGianCheckIn) {
        this._thoiGianCheckIn = _thoiGianCheckIn;
    }

    public Date getThoiGianCheckOut() {
        return _thoiGianCheckOut;
    }

    public void setThoiGianCheckOut(Date _thoiGianCheckOut) {
        this._thoiGianCheckOut = _thoiGianCheckOut;
    }

    public int getGiaTriCheckIn() {
        return _giaTriCheckIn;
    }

    public void setGiaTriCheckIn(int _giaTriCheckIn) {
        this._giaTriCheckIn = _giaTriCheckIn;
    }

    public int getGiaTriCheckOut() {
        return _giaTriCheckOut;
    }

    public void setGiaTriCheckOut(int _giaTriCheckOut) {
        this._giaTriCheckOut = _giaTriCheckOut;
    }

    @Override
    public String toString() {
        return "GiaTriKhac{" + "_maGiaTri=" + _maGiaTri + ", _moTa=" + _moTa + ", _thoiGianCheckIn=" + _thoiGianCheckIn + ", _thoiGianCheckOut=" + _thoiGianCheckOut + ", _giaTriCheckIn=" + _giaTriCheckIn + ", _giaTriCheckOut=" + _giaTriCheckOut + '}';
    }

}
