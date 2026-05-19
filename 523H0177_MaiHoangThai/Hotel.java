import java.util.ArrayList;

public class Hotel extends CommonAccommodation {
    private int soSaoChatLuongDichVu;

    public Hotel(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, ArrayList<Room> danhSachPhong, float heSoDanhGia, int soSaoChatLuongDichVu) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, danhSachPhong, heSoDanhGia);
        this.soSaoChatLuongDichVu = soSaoChatLuongDichVu;
    }
    public Hotel(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, float heSoDanhGia, int soSaoChatLuongDichVu) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, heSoDanhGia);
        this.soSaoChatLuongDichVu = soSaoChatLuongDichVu;
    }

    // get
    public int getSoSaoChatLuongDichVu() {
        return this.soSaoChatLuongDichVu;
    }
    // set
    public void setSoSaoChatLuongDichVu(int soSaoChatLuongDichVu) {
        this.soSaoChatLuongDichVu = soSaoChatLuongDichVu;
    }

    public String toString(){
        return "Hotel [" + this.maSoDinhDanh + ", " + this.soSaoChatLuongDichVu + ", " + this.noiLuuTru + ", " + this.soNhaVaTenDuong + ", " + this.thanhPho + "]";
    }
}
