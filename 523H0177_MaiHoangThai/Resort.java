import java.util.ArrayList;

public class Resort extends CommonAccommodation {
    private int soSao;
    private boolean beBoiCaNhan;

    public Resort(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, ArrayList<Room> danhSachPhong, float heSoDanhGia, int soSao, boolean beBoiCaNhan) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, danhSachPhong, heSoDanhGia);
        this.soSao = soSao;
        this.beBoiCaNhan = beBoiCaNhan;
    }
    public Resort(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, float heSoDanhGia, int soSao, boolean beBoiCaNhan) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, heSoDanhGia);
        this.soSao = soSao;
        this.beBoiCaNhan = beBoiCaNhan;
    }

    // get
    public int getSoSao() {
        return this.soSao;
    }
    public boolean getBeBoiCaNhan(){
        return this.beBoiCaNhan;
    }

    // set
    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }
    public void setBeBoiCaNhan(boolean beBoiCaNhan) {
        this.beBoiCaNhan = beBoiCaNhan;
    }

    public String toString(){
        return "Resort [" + this.maSoDinhDanh + ", " + this.noiLuuTru + ", " + this.soSao + ", " + this.soNhaVaTenDuong + ", " + this.beBoiCaNhan + ", " + this. thanhPho + "]";
    }
}
