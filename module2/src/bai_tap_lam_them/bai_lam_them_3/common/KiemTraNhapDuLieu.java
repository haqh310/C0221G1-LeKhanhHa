package bai_tap_lam_them.bai_lam_them_3.common;

import java.util.List;
import java.util.Scanner;

public class KiemTraNhapDuLieu {
    static Scanner scanner = new Scanner(System.in);

    public static String nhapHoten() {
        String name;
        do {
            try {
                System.out.println("Nhap ten: ");
                name = scanner.nextLine();
                CanBoNgoaiLe.checkHoTen(name);
                break;
            } catch (CanBoNgoaiLe e) {
                System.out.println(e);
            }
        } while (true);
        return name;
    }

    public static String nhapNamSinh() {
        String namSinh;
        do {
            try {
                System.out.println("Nhap nam Sinh: ");
                namSinh = scanner.nextLine();
                CanBoNgoaiLe.checkNamSinh(namSinh);
                break;
            } catch (CanBoNgoaiLe e) {
                System.out.println(e);
            }
        } while (true);
        return namSinh;
    }

    public static String chonGioiTinh() {
        String chon;
        do {
            System.out.println("1.Nam\n" +
                    "2.Nu\n" +
                    "3.Khac");
            System.out.println("Nhap lua chon: ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    return "Nam";
                case "2":
                    return "Nu";
                case "3":
                    return "Khac";
                default:
                    System.out.println("Vui long nhap tu 1 -3");
            }
        } while (true);
    }

    public static String nhapDiaChi() {
        String diaChi;
        do {
            try {
                System.out.println("Nhap dia chi: ");
                diaChi = scanner.nextLine();
                CanBoNgoaiLe.checkDiaChi(diaChi);
                break;
            } catch (CanBoNgoaiLe e) {
                System.out.println(e);
            }
        } while (true);
        return diaChi;
    }

    public static String nhapbac() {
        String bac;
        do {
            try {
                System.out.println("Nhap bach: ");
                bac = scanner.nextLine();
                CanBoNgoaiLe.checkbac(bac);
                break;
            } catch (CanBoNgoaiLe e) {
                System.out.println(e);
            }
        } while (true);
        return bac;
    }

    public static String chonNganhDaoTao() {
        List<String> stringList = GhiDocFile.docFileNganh("nganhDaoTao.csv");
        int chon;
        do {
            for (int i = 0; i < stringList.size(); i++) {
                System.out.println(i + 1 + ". " + stringList.get(i));
            }
            System.out.println("Nhap lua chon");
            chon = Integer.parseInt(scanner.nextLine());
            if (chon > 0 && chon <= stringList.size()) {
                return stringList.get(chon - 1).split(",")[1];
            } else {
                System.out.println("Nhap sai");
            }
        } while (true);
    }
    public static String chonCongViec(){
        String chon;
        do {
            System.out.println("1.Nam\n" +
                    "2.Nu\n" );
            System.out.println("Nhap lua chon: ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    return "PV-trong nhà";
                case "2":
                    return "PV-ngoài trời";
                default:
                    System.out.println("Vui long nhap tu 1 -3");
            }
        } while (true);
    }
}
