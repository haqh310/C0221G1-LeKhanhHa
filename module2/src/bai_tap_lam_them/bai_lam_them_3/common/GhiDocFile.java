package bai_tap_lam_them.bai_lam_them_3.common;

import bai_tap_lam_them.bai_lam_them_3.model.CanBo;
import bai_tap_lam_them.bai_lam_them_3.model.CongNhan;
import bai_tap_lam_them.bai_lam_them_3.model.KySu;
import bai_tap_lam_them.bai_lam_them_3.model.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GhiDocFile {
    static String path="D:\\C0221G1-LeKhanhHa\\module2\\src\\bai_tap_lam_them\\bai_lam_them_3\\data\\";

    public static void ghiFile(String fileName, List<CanBo> canBoList, boolean trangThai){
        FileWriter fw=null;
        BufferedWriter writer=null;
        try{
            fw = new FileWriter(path+fileName,trangThai);
            writer = new BufferedWriter(fw);
            for(CanBo canBo : canBoList){
                writer.write(canBo.toString());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<CanBo> docFile(String fileName){
        List<CanBo> canBoList = new ArrayList<>();
        File file = null;
        FileReader fr=null;
        BufferedReader reader=null;
        try{
            file = new File(path+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            fr = new FileReader(file);
            reader = new BufferedReader(fr);
            String line =null;
            String[] strings=null;
            CanBo canBo;
            while ((line=reader.readLine())!=null){
                strings = line.split(",");
                if(strings[4].contains("/7")){
                    canBo = new CongNhan(strings[0],strings[1],strings[2],strings[3],strings[4]);
                }else if(strings[4].contains("PV-")){
                    canBo = new NhanVien(strings[0],strings[1],strings[2],strings[3],strings[4]);
                }else {
                    canBo = new KySu(strings[0],strings[1],strings[2],strings[3],strings[4]);
                }
                canBoList.add(canBo);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return canBoList;
    }
    public static List<String> docFileNganh(String fileName){
        List<String> stringList = new ArrayList<>();
        FileReader fr=null;
        BufferedReader reader=null;
        try{
            fr = new FileReader(path+fileName);
            reader = new BufferedReader(fr);
            String line =null;
            while ((line=reader.readLine())!=null){
                stringList.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
