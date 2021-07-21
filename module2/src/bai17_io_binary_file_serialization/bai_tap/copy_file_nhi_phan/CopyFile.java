package bai17_io_binary_file_serialization.bai_tap.copy_file_nhi_phan;

import java.io.*;

public class CopyFile {
    static String path1 = "src\\bai17_io_binary_file_serialization\\bai_tap\\copy_file_nhi_phan\\source.dat";
    static String path2 = "src\\bai17_io_binary_file_serialization\\bai_tap\\copy_file_nhi_phan\\target.dat";

    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        int count=0;
        try {
            is = new FileInputStream(path1);
            os = new FileOutputStream(path2,true);
            byte[] buffer = new byte[1024];
            int length;
//            while ((length = is.read(buffer)) > 0) {
//                os.write(buffer, 0, length);
//
//            }
            while ((length = is.read()) >0){
               os.write(length);
               count++;
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("Number of byte in File: "+count);
    }
}