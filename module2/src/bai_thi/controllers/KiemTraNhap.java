package bai_thi.controllers;

import java.util.Scanner;

public class KiemTraNhap {
    static Scanner scanner = new Scanner(System.in);
    public static String kiemTraSoDT(){
        String soDT;
        String regex = "^[0-9]{10}+$";
        do {
            try {
                System.out.println("Nhập số điện thoại: ");
                soDT = scanner.nextLine();
                if(!soDT.matches(regex)){
                    throw new Exception("Nhập sai định dạng");
                }
                break;
            } catch (Exception e) {
                System.err.println(e);
            }
        } while (true);
        return soDT;
    }
    public static String kiemTraEmail(){
        String email;
        String regex = "^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        do {
            try {
                System.out.println("Nhập email: ");
                email = scanner.nextLine();
                if(!email.matches(regex)){
                    throw new Exception("Nhập sai định dạng");
                }
                break;
            } catch (Exception e) {
                System.err.println(e);
            }
        } while (true);
        return email;
    }
}
