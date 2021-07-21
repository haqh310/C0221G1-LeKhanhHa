package bai_tap_lam_them.bai_lam_them_3.model;

public class CongNhan extends CanBo {
    private String bac;

    public CongNhan() {
    }

    public CongNhan(String hoTen, String namSinh, String gioiTinh, String diaChi, String bac) {
        super(hoTen, namSinh, gioiTinh, diaChi);
        this.bac = bac;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    @Override
    public void showInfo() {
        System.out.println("CongNhan{" +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                "bac='" + bac + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return super.toString()+","+bac;
    }
}
