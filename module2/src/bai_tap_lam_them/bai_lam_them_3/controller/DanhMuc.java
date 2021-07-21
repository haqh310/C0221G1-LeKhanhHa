package bai_tap_lam_them.bai_lam_them_3.controller;

import java.util.Scanner;

public class DanhMuc {
    public static void quanLyDanhMuc(){
        Scanner scanner = new Scanner(System.in);
        String chon;
        do{
            System.out.println("1.Nhập thông tin mới cho cán bộ\n" +
                    "2.Tìm kiếm theo họ tên\n" +
                    "3.Sắp xếp theo tên\n" +
                    "4.Hiển thị thông tin về danh sách các cán bộ\n" +
                    "5.Thoát khỏi chương trình.\n");
            System.out.println("Chon chuc nang (1-5): ");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    QuanLiCanBo.themMoiCanBo();
                    break;
                case "2":
                    QuanLiCanBo.timKiemCanBo();
                    break;
                case "3":
                    QuanLiCanBo.sapXepCanBo();
                    break;
                case "4":
                    QuanLiCanBo.hienThiCanBo();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Nhap so 1-5");
            }
        }while (true);
      }
}
