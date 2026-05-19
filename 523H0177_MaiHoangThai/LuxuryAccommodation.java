public class LuxuryAccommodation extends Accommodation {
    protected boolean beBoiCaNhan;
    protected boolean thucUongChaoMung;
    protected boolean mienPhiBuaSang;
    protected boolean phongTheHinh;
    protected int soNguoiToiDa;
    protected int chiPhiMotDem;
    
    public LuxuryAccommodation(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho);
    }
    public LuxuryAccommodation(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho, boolean beBoiCaNhan, boolean thucUongChaoMung, boolean mienPhiBuaSang, boolean phongTheHinh, int soNguoiToiDa, int chiPhiMotDem) {
        super(maSoDinhDanh, noiLuuTru, soNhaVaTenDuong, thanhPho);
        this.beBoiCaNhan = beBoiCaNhan;
        this.thucUongChaoMung = thucUongChaoMung;
        this.mienPhiBuaSang = mienPhiBuaSang;
        this.phongTheHinh = phongTheHinh;
        this.soNguoiToiDa = soNguoiToiDa;
        this.chiPhiMotDem = chiPhiMotDem;
    }

    // get
    public boolean getBeBoiCaNhan() {
        return this.beBoiCaNhan;
    }
    public boolean getThucUongChaoMung() {
        return this.thucUongChaoMung;
    }
    public boolean getMienPhiBuaSang() {
        return this.mienPhiBuaSang;
    }
    public boolean getPhongTheHinh() {
        return this.phongTheHinh;
    }
    public int getSoNguoiToiDa() {
        return this.soNguoiToiDa;
    }
    public int getChiPhiMotDem() {
        return this.chiPhiMotDem;
    }

    // set
    public void setBeBoiCaNhan(boolean beBoiCaNhan) {
        this.beBoiCaNhan = beBoiCaNhan;
    }
    public void setThucUongChaoMung(boolean thucUongChaoMung) {
        this.thucUongChaoMung = thucUongChaoMung;
    }
    public void setMienPhiBuaSang(boolean mienPhiBuaSang) {
        this.mienPhiBuaSang = mienPhiBuaSang;
    }
    public void setPhongTheHinh(boolean phongTheHinh) {
        this.phongTheHinh = phongTheHinh;
    }
    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }
    public void setChiPhiMotDem(int chiPhiMotDem) {
        this.chiPhiMotDem = chiPhiMotDem;
    }
}
