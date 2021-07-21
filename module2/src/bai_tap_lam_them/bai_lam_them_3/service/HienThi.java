package bai_tap_lam_them.bai_lam_them_3.service;

import bai_tap_lam_them.bai_lam_them_3.common.GhiDocFile;
import bai_tap_lam_them.bai_lam_them_3.model.*;

import java.util.List;
import java.util.Scanner;

public class HienThi {
    static Scanner scanner = new Scanner(System.in);
    static String fileCanBo = "canBo.csv";
    public  static void hienThiCongNhan(){
        List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
        for(CanBo canBo : canBoList){
            if(canBo instanceof CongNhan){
                canBo.showInfo();
            }
        }
    }
    public  static void hienThiKySu(){
        List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
        for(CanBo canBo : canBoList){
            if(canBo instanceof KySu){
                canBo.showInfo();
            }
        }
    }
    public  static void hienThiNhanVien(){
        List<CanBo> canBoList = GhiDocFile.docFile(fileCanBo);
        for(CanBo canBo : canBoList){
            if(canBo instanceof NhanVien){
                canBo.showInfo();
            }
        }
    }
}
