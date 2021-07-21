package bai16_io_text_file.bai_tap;

import java.io.*;
import java.util.*;

public class ReadWrite {
    public static void main(String[] args) {
        try{
            String pathSource="src\\bai16_io_text_file\\bai_tap\\source.txt";
            String pathTarget="src\\bai16_io_text_file\\bai_tap\\target.txt";
            BufferedReader reader = new BufferedReader(new FileReader(pathSource));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathTarget));
            String line =null;
            Set<Character> characters = new TreeSet<>();
            while ((line = reader.readLine()) != null){
                for (int i = 0; i <line.length() ; i++) {
                    characters.add(line.charAt(i));
                }
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.flush();
            writer.close();
            Iterator iterator = characters.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
}
