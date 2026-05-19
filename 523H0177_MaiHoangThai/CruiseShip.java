public class CruiseShip extends LuxuryAccommodation {
    private boolean barRiengTu;
    
    public CruiseShip(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, boolean beBoiCaNhan, boolean thucUongChaoMung, boolean mienPhiBuaSang, boolean phongTheHinh, int soNguoiToiDa, int chiPhiMotDem, boolean barRiengTu) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho, beBoiCaNhan, thucUongChaoMung, mienPhiBuaSang, phongTheHinh, soNguoiToiDa, chiPhiMotDem);
        this.barRiengTu = barRiengTu;
    }

    public boolean getBarRiengTu() {
        return this.barRiengTu;
    }
    public void setBarRiengTu(boolean barRiengTu) {
        this.barRiengTu = barRiengTu;
    }

    public String toString() {
        return "CruiseShip [" + this.maSoDinhDanh + ", " + this.noiLuuTru + ", " + this.soNhaVaTenDuong + ", " + this.thanhPho + ", " + this.barRiengTu + ", " + this.beBoiCaNhan + ", " + this.thucUongChaoMung + ", " + this.mienPhiBuaSang + ", " + this.phongTheHinh + "]";
    }
}