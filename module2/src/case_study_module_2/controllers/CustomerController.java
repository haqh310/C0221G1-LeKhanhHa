package case_study_module_2.controllers;

import case_study_module_2.commons.FileUtils;
import case_study_module_2.models.Customer;
import case_study_module_2.models.Employee;
import case_study_module_2.models.Person;
import case_study_module_2.services.CreatePerson;

import java.util.*;

public class CustomerController {
    static String filePerson ="person.csv";
    public static void addNewCustomer() {
        FileUtils.writeFileObject(filePerson, CreatePerson.createCustomer(),true);
    }
    public static List<Person> showInformationOfCustomer() {
        List<Person> personList = new ArrayList<>();
        int i=1;
        for(Person person :FileUtils.readFilePerson(filePerson)){
            if(person instanceof Customer){
                personList.add(person);
                System.out.println(i++ +". "+person.showInfo());
            }
        }
        return personList;
    }

}
