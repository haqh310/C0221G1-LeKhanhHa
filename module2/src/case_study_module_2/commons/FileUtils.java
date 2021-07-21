package case_study_module_2.commons;

import case_study_module_2.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static final String PATH="D:\\C0221G1-LeKhanhHa\\module2\\src\\case_study_module_2\\data\\";

    public static<E> void writeFileObject(String fileName, E e, boolean writeMode){
        FileWriter fw = null;
        try{
            fw = new FileWriter(PATH+fileName,writeMode);
            writer =new BufferedWriter(fw);
            writer.write(e.toString());
            writer.newLine();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                writer.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static<E> void writeFileList(String fileName, List<E>  list, boolean writeMode){
        FileWriter fw = null;
        try{
            fw = new FileWriter(PATH+fileName,writeMode);
            writer =new BufferedWriter(fw);
            for(E e : list){
                writer.write(e.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                writer.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static List<Services> readFileServices(String fileName){
        List<Services> servicesList = new ArrayList();
        FileReader fr=null;
        try{
            fr = new FileReader(PATH+fileName);
            reader = new BufferedReader(fr);
            String line ;
            String[] servicesString=null;
            Services service=null;
            while ((line = reader.readLine())!=null){
                servicesString = line.split(",");
                if(servicesString.length == 10){
                    service = new Villa(servicesString);
                }else if(servicesString[0].contains("SVHO")){
                    service = new House(servicesString);
                }else {
                    service= new Room(servicesString);
                }
                servicesList.add(service);
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
        return servicesList;
    }

    public static List<Person> readFilePerson(String fileName){
        List<Person> personList = new ArrayList();
        FileReader fr=null;
        try{
            fr = new FileReader(PATH+fileName);
            reader = new BufferedReader(fr);
            String line ;
            String[] personString=null;
            Person person=null;
            while ((line = reader.readLine())!=null){
                personString = line.split(",");
                if(personString.length == 9){
                    person = new Customer(personString);
                }else {
                    person = new Employee(personString);
                }
                personList.add(person);
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
        return personList;
    }

}
