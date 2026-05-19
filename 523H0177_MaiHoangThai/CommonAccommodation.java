import java.util.ArrayList;

public class CommonAccommodation extends Accommodation {
   protected ArrayList<Room> danhSachPhong;
   protected float heSoDanhGia;

   public CommonAccommodation(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, ArrayList<Room> danhSachPhong, float heSoDanhGia) {
      super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho);
      this.danhSachPhong = danhSachPhong;
      this.heSoDanhGia = heSoDanhGia;
   }
   public CommonAccommodation(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, float heSoDanhGia) {
      super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho);
      this.heSoDanhGia = heSoDanhGia;
      this.danhSachPhong = new ArrayList<>();
   }

   // get
   public ArrayList<Room> getDanhSachPhong() {
      return this.danhSachPhong;
   }
   public float getHeSoDanhGia() {
      return this.heSoDanhGia;
   }

   // set
   public void setDanhSachPhong(ArrayList<Room> danhSachPhong) {
      this.danhSachPhong = danhSachPhong;
   } 
   public void setHeSoDanhGia(float heSoDanhGia) {
      this.heSoDanhGia = heSoDanhGia;
   }
}
