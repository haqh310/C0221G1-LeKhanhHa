package bai_tap_lam_them.bai_lam_them_1.commons;

import bai_tap_lam_them.bai_lam_them_1.models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static String path = "D:\\C0221G1-LeKhanhHa\\module2\\src\\bai_tap_lam_them\\bai_lam_them_1\\data\\vehicle.csv";
    private static final String COMMON = ",";
    public static void writeFile(String content){
        try{
            FileWriter fw= new FileWriter(path,true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(content);
            writer.newLine();
            writer.close();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }
    }

    public static List<String> readFile(){
        List<String> listVehicle = new ArrayList<>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line ;
            while((line = reader.readLine()) !=null){
                listVehicle.add(line);
            }
            reader.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return listVehicle;
    }
    public static void resetFile(){
        try{
            File file = new File(path);
            file.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void setPath(String name){
        StringBuffer sb = new StringBuffer("D:\\C0221G1-LeKhanhHa\\module2\\src\\bai_tap_lam_them\\bai_lam_them_1\\data\\");
        sb.append(name);
        sb.append(".csv");
        path = sb.toString();
    }
}
