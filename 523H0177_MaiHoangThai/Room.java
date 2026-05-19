public class Room {
    protected int maDinhDanh;
    protected String tenPhong;
    protected int soLuongLau;
    protected String loaiPhong;
    protected int soLuongGiuong;
    protected int soLuongToiDa;
    protected double dienTichSan;
    protected double chiPhiPhong1Dem;

    public Room(int maDinhDanh, String tenPhong, int soLuongLau, String loaiPhong, int soLuongGiuong, int soLuongToiDa, double dienTichSan, double chiPhiPhong1Dem){
        this.maDinhDanh = maDinhDanh;
        this.tenPhong = tenPhong;
        this.soLuongLau = soLuongLau;
        this.loaiPhong = loaiPhong;
        this.soLuongGiuong = soLuongGiuong;
        this.soLuongToiDa = soLuongToiDa;
        this.dienTichSan = dienTichSan;
        this.chiPhiPhong1Dem = chiPhiPhong1Dem;
    }

    // get
    public int getMaDinhDanh() {
        return this.maDinhDanh;
    }
    public String getTenPhong() {
        return this.tenPhong;
    }
    public int getSoLuongLau() {
        return this.soLuongLau;
    }
    public String getLoaiPhong() {
        return this.loaiPhong;
    }
    public int getSoLuongGiuong() {
        return this.soLuongGiuong;
    }
    public int getSoLuongToiDa() {
        return this.soLuongToiDa;
    }
    public double getDienTichSan() {
        return this.dienTichSan;
    }
    public double getChiPhiPhong1Dem() {
        return this.chiPhiPhong1Dem;
    }

    // set
    public void setMaDinhDanh(int maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
    }
    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    public void setSoLuongLau(int soLuongLau) {
        this.soLuongLau = soLuongLau;
    }
    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
    public void setSoLuongGiuong(int soLuongGiuong) {
        this.soLuongGiuong = soLuongGiuong;
    }
    public void setSoLuongToiDa(int soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }
    public void setDienTichSan(double dienTichSan) {
        this.dienTichSan = dienTichSan;
    }
    public void setChiPhiPhong1Dem(double chiPhiPhong1Dem) {
        this.chiPhiPhong1Dem = chiPhiPhong1Dem;
    }

    public String toString(){
        return "Room [" + this.maDinhDanh + ", " + this.tenPhong + ", " + this.soLuongLau + ", " + this.loaiPhong + ", " + this.soLuongToiDa + ", " + this.dienTichSan + ", " + this.chiPhiPhong1Dem + "]";
    }
}
