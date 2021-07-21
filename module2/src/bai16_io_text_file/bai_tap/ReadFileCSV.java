package bai16_io_text_file.bai_tap;

import java.io.*;

public class ReadFileCSV {

    public static void main(String[] args)  {
        String path ="src\\bai16_io_text_file\\bai_tap\\Country.csv";
      try{
          BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = reader.readLine())!=null){
                System.out.println(line.split(",")[5]);
            }
            reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
