

package DAL.Entities;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GiaoCa {
    private String magiaoca, manv;
    private int tiendaucanhan,tongtienthe,tongtienmat,tienphatsinh,tienchenhlech,tongdoanhthuca,sotienthucgiao;
    private String gionhanca,giogiaoca,ghichu;

    public GiaoCa() {
    }

    public GiaoCa(String magiaoca, String manv, int tiendaucanhan, int tongtienthe, int tongtienmat, int tienphatsinh, int tienchenhlech, int tongdoanhthuca, int sotienthucgiao, String gionhanca, String giogiaoca, String ghichu) {
        this.magiaoca = magiaoca;
        this.manv = manv;
        this.tiendaucanhan = tiendaucanhan;
        this.tongtienthe = tongtienthe;
        this.tongtienmat = tongtienmat;
        this.tienphatsinh = tienphatsinh;
        this.tienchenhlech = tienchenhlech;
        this.tongdoanhthuca = tongdoanhthuca;
        this.sotienthucgiao = sotienthucgiao;
        this.gionhanca = gionhanca;
        this.giogiaoca = giogiaoca;
        this.ghichu = ghichu;
    }

    public String getMagiaoca() {
        return magiaoca;
    }

    public void setMagiaoca(String magiaoca) {
        this.magiaoca = magiaoca;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getTiendaucanhan() {
        return tiendaucanhan;
    }

    public void setTiendaucanhan(int tiendaucanhan) {
        this.tiendaucanhan = tiendaucanhan;
    }

    public int getTongtienthe() {
        return tongtienthe;
    }

    public void setTongtienthe(int tongtienthe) {
        this.tongtienthe = tongtienthe;
    }

    public int getTongtienmat() {
        return tongtienmat;
    }

    public void setTongtienmat(int tongtienmat) {
        this.tongtienmat = tongtienmat;
    }

    public int getTienphatsinh() {
        return tienphatsinh;
    }

    public void setTienphatsinh(int tienphatsinh) {
        this.tienphatsinh = tienphatsinh;
    }

    public int getTienchenhlech() {
        return tienchenhlech;
    }

    public void setTienchenhlech(int tienchenhlech) {
        this.tienchenhlech = tienchenhlech;
    }

    public int getTongdoanhthuca() {
        return tongdoanhthuca;
    }

    public void setTongdoanhthuca(int tongdoanhthuca) {
        this.tongdoanhthuca = tongdoanhthuca;
    }

    public int getSotienthucgiao() {
        return sotienthucgiao;
    }

    public void setSotienthucgiao(int sotienthucgiao) {
        this.sotienthucgiao = sotienthucgiao;
    }

    public String getGionhanca() {
        return gionhanca;
    }

    public void setGionhanca(String gionhanca) {
        this.gionhanca = gionhanca;
    }

    public String getGiogiaoca() {
        return giogiaoca;
    }

    public void setGiogiaoca(String giogiaoca) {
        this.giogiaoca = giogiaoca;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "GiaoCa{" + "magiaoca=" + magiaoca + ", manv=" + manv + ", tiendaucanhan=" + tiendaucanhan + ", tongtienthe=" + tongtienthe + ", tongtienmat=" + tongtienmat + ", tienphatsinh=" + tienphatsinh + ", tienchenhlech=" + tienchenhlech + ", tongdoanhthuca=" + tongdoanhthuca + ", sotienthucgiao=" + sotienthucgiao + ", gionhanca=" + gionhanca + ", giogiaoca=" + giogiaoca + ", ghichu=" + ghichu + '}';
    }
    
    
    
    
    
}
