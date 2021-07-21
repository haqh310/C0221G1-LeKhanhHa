package bai_tap_lam_them.bai_lam_them_3.service;

import bai_tap_lam_them.bai_lam_them_3.common.GhiDocFile;
import bai_tap_lam_them.bai_lam_them_3.common.KiemTraNhapDuLieu;
import bai_tap_lam_them.bai_lam_them_3.model.CanBo;
import bai_tap_lam_them.bai_lam_them_3.model.CongNhan;
import bai_tap_lam_them.bai_lam_them_3.model.KySu;

import java.util.ArrayList;
import java.util.List;

public class KhoiTaoCanBo {
    static String fileCanBo = "canBo.csv";
    public static void khoiTaoCongNhan(){
        String name = KiemTraNhapDuLieu.nhapHoten();
        String namSinh = KiemTraNhapDuLieu.nhapNamSinh();
        String gioiTinh = KiemTraNhapDuLieu.chonGioiTinh();
        String diaChi = KiemTraNhapDuLieu.nhapDiaChi();
        String bac = KiemTraNhapDuLieu.nhapbac();
        List<CanBo> canBoList = new ArrayList<>();
        canBoList.add(new CongNhan(name,namSinh,gioiTinh,diaChi,bac));
        GhiDocFile.ghiFile(fileCanBo,canBoList,true);
    }

    public static void khoiTaoKySu(){
        String name = KiemTraNhapDuLieu.nhapHoten();
        String namSinh = KiemTraNhapDuLieu.nhapNamSinh();
        String gioiTinh = KiemTraNhapDuLieu.chonGioiTinh();
        String diaChi = KiemTraNhapDuLieu.nhapDiaChi();
        String nganh = KiemTraNhapDuLieu.chonNganhDaoTao();
        List<CanBo> canBoList = new ArrayList<>();
        canBoList.add(new KySu(name,namSinh,gioiTinh,diaChi,nganh));
        GhiDocFile.ghiFile(fileCanBo,canBoList,true);
    }

    public static void khoiTaoNhanVien(){
        String name = KiemTraNhapDuLieu.nhapHoten();
        String namSinh = KiemTraNhapDuLieu.nhapNamSinh();
        String gioiTinh = KiemTraNhapDuLieu.chonGioiTinh();
        String diaChi = KiemTraNhapDuLieu.nhapDiaChi();
        String congViec = KiemTraNhapDuLieu.chonCongViec();
        List<CanBo> canBoList = new ArrayList<>();
        canBoList.add(new CongNhan(name,namSinh,gioiTinh,diaChi,congViec));
        GhiDocFile.ghiFile(fileCanBo,canBoList,true);
    }
}
