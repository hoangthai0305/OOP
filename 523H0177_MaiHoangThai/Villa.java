public class Villa extends LuxuryAccommodation {

    public Villa(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, boolean beBoiCaNhan, boolean thucUongChaoMung, boolean mienPhiBuaSang, boolean phongTheHinh, int soNguoiToiDa, int chiPhiMotDem) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, beBoiCaNhan, thucUongChaoMung, mienPhiBuaSang, phongTheHinh, soNguoiToiDa, chiPhiMotDem);
    }
    public String toString() {
        return "Villa [" + this.maSoDinhDanh + ", " + this.noiLuuTru + ", " + this.soNhaVaTenDuong + ", " + this.thanhPho + ", " + this.beBoiCaNhan + ", " + this.thucUongChaoMung + ", " + this.mienPhiBuaSang + ", " + this.phongTheHinh + ", " + this.soNguoiToiDa + ", " + this.chiPhiMotDem + "]";
    }
    
}
