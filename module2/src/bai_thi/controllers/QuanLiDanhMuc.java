package bai_thi.controllers;

import bai_thi.commons.GhiDocFIle;
import bai_thi.models.DanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLiDanhMuc {
    static Scanner scanner = new Scanner(System.in);
    static List<DanhBa> danhBaList = new ArrayList<>();

    public static void hienThi() {
        if(danhBaList.isEmpty()){
            System.err.println("Danh bạ trống!!!");
            return;
        }
        for (DanhBa danhBa : danhBaList) {
            System.out.println(danhBa.showInfor());
            scanner.nextLine();
        }
    }

    public static void themDanhMuc() {
        String soDT = KiemTraNhap.kiemTraSoDT();
        System.out.println("Nhập nhóm danh bạ: ");
        String nhom = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhập dịa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();
        String email = KiemTraNhap.kiemTraEmail();
        danhBaList.add(new DanhBa(soDT, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email));
        System.out.println("Đã thêm mới thành công!!!");
    }



    public static void sua() {
        if(danhBaList.isEmpty()){
            System.err.println("Danh bạ trống!!!");
            return;
        }
        do{
            System.out.println("Nhập só điện thoại: ");
            String soDt = scanner.nextLine();
            System.out.println(soDt);
            if(soDt.isEmpty()){
                return;
            }
            boolean kt = false;
            for (DanhBa danhBa : danhBaList) {
                if (danhBa.getSoDT().equals(soDt)) {
                    System.out.println("Nhập nhóm danh bạ: ");
                    danhBa.setNhom(scanner.nextLine());
                    System.out.println("Nhập họ tên: ");
                    danhBa.setHoTen(scanner.nextLine());
                    System.out.println("Nhập giới tính: ");
                    danhBa.setGioiTinh(scanner.nextLine());
                    System.out.println("Nhập dịa chỉ: ");
                    danhBa.setDiaChi(scanner.nextLine());
                    System.out.println("Nhập ngày sinh: ");
                    danhBa.setNgaySinh(scanner.nextLine());
                    danhBa.setEmail(KiemTraNhap.kiemTraEmail());
                    System.out.println("Đã cập nhật thành công!!!");
                    kt = true;
                    return;
                }
            }
            if (!kt) {
                System.out.println("Không có trong danh bạ");
            }
        }while (true);
    }

    public static void xoa() {
        if(danhBaList.isEmpty()){
            System.err.println("Danh bạ trống!!!");
            return;
        }
        boolean kt = false;
        String soDt, kiemTra;
        do {
            System.out.println("Nhập số điện thoại cần xóa: ");
            soDt = scanner.nextLine();
            if (soDt.isEmpty()) {
                return;
            }
            for (DanhBa danhBa : danhBaList) {
                if (danhBa.getSoDT().equals(soDt)) {
                    kt = true;
                    System.out.println("Yêu cầu xác nhận (Y/N)");
                    kiemTra = scanner.nextLine();
                    if (kiemTra.equals("Y")) {
                        danhBaList.remove(danhBa);
                        System.out.println("Đã xóa thành công!!!");
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (!kt) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên: ");
            }
        } while (true);

    }

    public static void timKiem() {
        if(danhBaList.isEmpty()){
            System.err.println("Danh bạ trống!!!");
            return;
        }
        hienThi();
        String regex = "^[0-9]+$";
        boolean kt=false;
        System.out.println("Nhập tên hoặc số điện thoại cần tìm kiếm: ");
        String name = scanner.nextLine();
        if (name.matches(regex)) {
            for (DanhBa danhBa : danhBaList) {
                if (danhBa.getSoDT().contains(name)) {
                    kt=true;
                    System.out.println(danhBa.showInfor());
                }
            }
        } else {
            for (DanhBa danhBa : danhBaList) {
                if (danhBa.getHoTen().contains(name)) {
                    kt=true;
                    System.out.println(danhBa.showInfor());
                }
            }
        }
        if(!kt){
            System.out.println("Không có tên hay số điện thoại trên trong danh bạ");
        }
    }

    public static void docDanhBa() {
        System.out.println("Xác nhận đoc file vào danh bạ(Y/N) : ");
        String kt = scanner.nextLine();
        if (kt.equals("Y")) {
            danhBaList = GhiDocFIle.docFile();
            System.out.println("Đã dọc thành công!!!");
        }

    }

    public static void ghiDanhBa() {
        System.out.println("Xác nhân ghi vào file (Y/N) :");
        String kt = scanner.nextLine();
        if (kt.equals("Y")) {
            GhiDocFIle.ghiFile(danhBaList, false);
            System.out.println("Đã ghi file thành công!!!");
        }
    }
}
