package bai_thi.controllers;

import java.util.Scanner;

public class DanhMuc {
    public static void quanLyDanhMuc(){
        Scanner scanner = new Scanner(System.in);
        String chon;
        do{
            System.out.println("---CHUONG TRINH QUAN LI DANH BA");
            System.out.println("1.Xem danh sách\n" +
                    "2.Thêm mới\n" +
                    "3.Cập nhật\n" +
                    "4.Xóa\n" +
                    "5.Tìm kiếm\n" +
                    "6.Đọc từ File\n"+
                    "7.Ghi vào File\n"+
                    "8.Thoát");
            System.out.println("Chọn chức năng (1-8): ");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    QuanLiDanhMuc.hienThi();
                    break;
                case "2":
                    QuanLiDanhMuc.themDanhMuc();
                    break;
                case "3":
                    QuanLiDanhMuc.sua();
                    break;
                case "4":
                    QuanLiDanhMuc.xoa();
                    break;
                case "5":
                    QuanLiDanhMuc.timKiem();
                    break;
                case "6":
                    QuanLiDanhMuc.docDanhBa();
                    break;
                case "7":
                    QuanLiDanhMuc.ghiDanhBa();
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1-8");
            }
        }while (true);
    }
}
