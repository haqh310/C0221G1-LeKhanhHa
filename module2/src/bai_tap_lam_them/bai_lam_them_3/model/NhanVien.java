package bai_tap_lam_them.bai_lam_them_3.model;

public class NhanVien extends  CanBo{
    private String congViec;

    public NhanVien() {

    }

    public NhanVien(String hoTen, String namSinh, String gioiTinh, String diaChi, String congViec) {
        super(hoTen, namSinh, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public void showInfo() {
        System.out.println("NhanVien{" +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                "congViec='" + congViec + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return super.toString()+","+congViec;
    }
}
