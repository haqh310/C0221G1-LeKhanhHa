package model.bean;

public class SanPham {
    private int id;
    private String ten;
    private double gia;
    private int soLuong;
    private String mauSac;
    private String moTa;
    private int idDanhMuc;

    public SanPham(int id, String ten, double gia, int soLuong, String mauSac, String moTa, int idDanhMuc) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
    }

    public SanPham(String ten, double gia, int soLuong, String mauSac, String moTa, int idDanhMuc) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.idDanhMuc = idDanhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }
}
