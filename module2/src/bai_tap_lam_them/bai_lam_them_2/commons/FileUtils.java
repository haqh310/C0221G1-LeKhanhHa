package bai_tap_lam_them.bai_lam_them_2.commons;

import bai_tap_lam_them.bai_lam_them_2.models.CustomerForeign;
import bai_tap_lam_them.bai_lam_them_2.models.CustomerVN;
import bai_tap_lam_them.bai_lam_them_2.models.Invoice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String PATH = "D:\\C0221G1-LeKhanhHa\\module2\\src\\bai_tap_lam_them\\bai_lam_them_2\\data\\";
    public static void writeFile(String fileName, String content,boolean writeMode ){
        FileWriter fw=null;
        BufferedWriter write=null;
        try{
            fw = new FileWriter(PATH+fileName,writeMode);
            write = new BufferedWriter(fw);
            write.write(content);
            write.newLine();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                write.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> readFile(String name){
        List<String> list = new ArrayList<>();
        FileReader fr=null;
        BufferedReader reader=null;
        try {
            fr = new FileReader(PATH+name);
            reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine())!=null){
                list.add(line);
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
        return list;
    }

    public static<E> void writeFile(String fileName, List<E> list, boolean writeMode){
        File file = new File(PATH+fileName);
        BufferedWriter writer =null;
        try{
            writer = new BufferedWriter(new FileWriter(file,writeMode));
            for(E e : list){
                writer.write(e.toString());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String[]> readFileList(String fileName){
        List<String[]>  list = new ArrayList<>();
        File file=new File(PATH+fileName);
        BufferedReader reader=null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine())!=null){
                list.add(line.split(","));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static<E> List<E> readFileObject(String fileName){
        List<E>  list = new ArrayList<>();
        File file=new File(PATH+fileName);
        BufferedReader reader=null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String line;
            String[] arrStr=null;
            while ((line = reader.readLine())!=null){
                arrStr = line.split(",");
                if(fileName.equals("invoice.csv")){
                    list.add((E) new Invoice(arrStr));
                }else if(arrStr.length==4) {
                    list.add((E) new CustomerVN(arrStr));
                }else {
                    list.add((E) new CustomerForeign(arrStr));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
