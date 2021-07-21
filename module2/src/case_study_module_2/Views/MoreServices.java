package case_study_module_2.Views;

import case_study_module_2.commons.FileUtils;
import case_study_module_2.models.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MoreServices {
    static String filePerson ="person.csv";
    public static void showCinema(){
        Queue<Person> queuePerson = new LinkedList<>();
        List<Person> personList = FileUtils.readFilePerson(filePerson);
        try{
            queuePerson.add(personList.get(1));
            queuePerson.add(personList.get(3));
            while (!queuePerson.isEmpty()){
                System.out.println(queuePerson.poll().showInfo());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void searchEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name Employee: ");
        String name = scanner.nextLine();
        for(Person person : FileUtils.readFilePerson(filePerson)){
            if(person.getFullName().equals(name)){
                System.out.println(person.showInfo());
                return;
            }
        }
        System.out.println("Not employee name is "+name);
    }
}
