package bai_thi.commons;

import bai_thi.models.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GhiDocFIle {
    static String path="D:\\C0221G1-LeKhanhHa\\module2\\src\\bai_thi\\data\\contacts.csv";

    public static void ghiFile( List<DanhBa> danhBaList, boolean trangThai){
        FileWriter fw=null;
        BufferedWriter writer=null;
        try{
            fw = new FileWriter(path,trangThai);
            writer = new BufferedWriter(fw);
            writer.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            writer.newLine();
            for(DanhBa danhBa : danhBaList){
                writer.write(danhBa.toString());
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

    public static List<DanhBa> docFile(){
        List<DanhBa> danhBaList = new ArrayList<>();
        File file = null;
        FileReader fr=null;
        BufferedReader reader=null;
        try{
            file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            fr = new FileReader(file);
            reader = new BufferedReader(fr);
            String line =reader.readLine();
            String[] strings=null;
            while ((line=reader.readLine())!=null){
                strings = line.split(",");
                danhBaList.add(new DanhBa(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6]));
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
        return danhBaList;
    }
}
