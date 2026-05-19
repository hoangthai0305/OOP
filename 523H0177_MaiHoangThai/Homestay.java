import java.util.ArrayList;

public class Homestay extends CommonAccommodation {
    public Homestay(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, ArrayList<Room> danhSachPhong, float heSoDanhGia) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, danhSachPhong, heSoDanhGia);
    }
    public Homestay(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, float heSoDanhGia) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, heSoDanhGia);
    }
    
    public String toString(){
        return "Homestay [" + this.maSoDinhDanh + ", " + this.noiLuuTru + ", " + this.soNhaVaTenDuong + ", " + this.heSoDanhGia + ", " + this.thanhPho + "]";
    }
}
