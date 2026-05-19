abstract class Accommodation {
    protected int maSoDinhDanh;
    protected String noiLuuTru;
    protected String soNhaVaTenDuong;
    protected String thanhPho;
    

    public Accommodation(int maSoDinhDanh, String noiLuuTru, String soNhaVaTenDuong, String thanhPho){
        this.maSoDinhDanh = maSoDinhDanh;
        this.noiLuuTru = noiLuuTru;
        this.soNhaVaTenDuong = soNhaVaTenDuong;
        this.thanhPho = thanhPho;
    }

    // get
    public int getMaSoDinhDanh() {
        return this.maSoDinhDanh;
    }
    public String getNoiLuuTru() {
        return this.noiLuuTru;
    }
    public String getSoNhaVaTenDuong() {
        return this.soNhaVaTenDuong;
    }
    public String getThanhPho() {
        return this.thanhPho;
    }
    
    // set
    public void setMaSoDinhDanh(int maSoDinhDanh) {
        this.maSoDinhDanh = maSoDinhDanh;
    }
    public void setNoiLuuTru(String noiLuuTru) {
        this.noiLuuTru = noiLuuTru;
    }
    public void setSoNhaVaTenDuong(String soNhaVaTenDuong) {
        this.soNhaVaTenDuong = soNhaVaTenDuong;
    }
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
}
