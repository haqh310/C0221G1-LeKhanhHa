package bai_tap_lam_them.bai_lam_them_3.controller;

import bai_tap_lam_them.bai_lam_them_3.common.GhiDocFile;
import bai_tap_lam_them.bai_lam_them_3.model.CanBo;
import bai_tap_lam_them.bai_lam_them_3.service.HienThi;
import bai_tap_lam_them.bai_lam_them_3.service.KhoiTaoCanBo;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLiCanBo {
    static Scanner scanner = new Scanner(System.in);
    static String fileCanBo = "canBo.csv";

    public static void themMoiCanBo() {
        String chon;
        do {
            System.out.println("1.Them moi cong nhan\n" +
                    "2.Them moi ky su\n" +
                    "3.Them moi nhan vien\n" +
                    "4.Quay lai menu\n" +
                    "5.Thoat");
            System.out.println("Chon chuc nang (1-5): ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    KhoiTaoCanBo.khoiTaoCongNhan();
                    break;
                case "2":
                    KhoiTaoCanBo.khoiTaoKySu();
                    break;
                case "3":
                    KhoiTaoCanBo.khoiTaoNhanVien();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Nhap so 1-5");
            }
        } while (true);
    }

    public static void timKiemCanBo() {
        List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
        boolean kt = false;
        System.out.println("Nhap ten can tim");
        String name = scanner.nextLine();
        for (CanBo canBo : canBoList) {
            if (canBo.getHoTen().contains(name)) {
                canBo.showInfo();
                kt = true;
            }
        }
        if (!kt) {
            System.out.println("Khong co can bo ten : " + name);
        }
    }

    public static void sapXepCanBo(){
        List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
        canBoList.sort(Comparator.comparing(CanBo::getHoTen));
        for (CanBo canBo : canBoList) {
                canBo.showInfo();
            }
        }

        public static void xoaCanBo(){
            List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
            int chon;
            do{
                for(int i=0;i<canBoList.size();i++){
                    System.out.print(i+". ");
                    canBoList.get(i).showInfo();
                }
                System.out.println("Nhap lua chon (1-"+canBoList.size()+")");
                chon = Integer.parseInt(scanner.nextLine());
                if(chon >0 && chon <= canBoList.size()){
                    canBoList.remove(chon-1);
                    GhiDocFile.ghiFile(fileCanBo,canBoList,false);
                }else {
                    System.out.println("Nhap sai, vui long nhap lai");
                }
            }while (true);
        }

    public static void hienThiCanBo() {
        String chon;
        do {
            System.out.println("1.Hien thi cong nhan\n" +
                    "2.Hien thi ky su\n" +
                    "3.Hien thi nhan vien\n" +
                    "4.Quay lai menu\n" +
                    "5.Thoat");
            System.out.println("Chon chuc nang (1-5): ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    HienThi.hienThiCongNhan();
                    break;
                case "2":
                    HienThi.hienThiKySu();
                    break;
                case "3":
                    HienThi.hienThiNhanVien();
                    break;
                case "4":
                    return;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Nhap so 1-5");
            }
        } while (true);
    }
}
