package model.bean;

public class NhanVien {
    private int id;
    private String ten;
    private String ngaySinh;

    public NhanVien(int id, String ten, String ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien(String ten, String ngaySinh) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
