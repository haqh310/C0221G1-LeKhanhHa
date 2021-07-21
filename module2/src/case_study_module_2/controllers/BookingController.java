package case_study_module_2.controllers;

import case_study_module_2.commons.FileUtils;
import case_study_module_2.services.DisplayServices;
import case_study_module_2.models.*;

import java.io.File;
import java.util.*;

public class BookingController {
    public static Scanner scanner = new Scanner(System.in);
    static String filePerson = "person.csv";
    static String fileServices = "services.csv";
    static String fileSBooking = "booking.csv";

    public static void addNewBooking() {
        do {
            try {
                if(!addServicesBooking((Customer) chooseCustomer())){
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true);
    }

    public static boolean addServicesBooking(Customer customer) {
        if(customer == null){
            return false;
        }
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n" +
                "4.\tBack to menu\n");
        System.out.print("Enter choose services: ");
        int choose = Integer.parseInt(scanner.nextLine());
        List<Services> servicesList = FileUtils.readFileServices(fileServices);
        Services services = null;
        switch (choose) {
            case 1:
                services = chooseServices(DisplayServices.displayAllVilla(servicesList));
                break;
            case 2:
                services = chooseServices(DisplayServices.displayAllHouse(servicesList));
                break;
            case 3:
                services = chooseServices(DisplayServices.displayAllRoom(servicesList));
                break;
            case 4:
                return true;
        }
        customer.setServices(services);
        System.out.println(customer.showInfo());
        servicesList.remove(services);
        FileUtils.writeFileList(fileServices,servicesList,false);
        FileUtils.writeFileObject(fileSBooking,customer,true);
        return true;
    }

    public static <E> Services chooseServices(List<E> list) {
        int choose;
        do {
            try {
                System.out.print("Enter a service: ");
                choose = Integer.parseInt(scanner.nextLine());
                if (choose > 0 && choose <= list.size()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        return (Services) list.get(choose-1);
    }

    public static Person chooseCustomer() {
        List<Person> personList = FileUtils.readFilePerson(filePerson);
        List<Person> customerList = CustomerController.showInformationOfCustomer();
        if(customerList.isEmpty()){
            System.out.println("Not a customer");
            return null;
        }
        int choose;
        do {
            try {
                System.out.print("Enter a customer: ");
                choose = Integer.parseInt(scanner.nextLine());
                if (choose > 0 && choose <= customerList.size()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        Person person  =  personList.remove(choose-1);
       FileUtils.writeFileList(filePerson,personList,false);
        return person;
    }

}
