package bai_tap_lam_them.bai_lam_them_3.model;

public class KySu extends CanBo{
    private String nganh;

    public KySu() {
    }

    public KySu(String hoTen, String namSinh, String gioiTinh, String diaChi, String nganh) {
        super(hoTen, namSinh, gioiTinh, diaChi);
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override
    public void showInfo() {
        System.out.println("KySu{" +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                "nganh='" + nganh + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return super.toString()+","+nganh;
    }
}
