package bai_tap_lam_them.bai_lam_them_2.controller;

import bai_tap_lam_them.bai_lam_them_2.commons.CreateObject;
import bai_tap_lam_them.bai_lam_them_2.commons.FileUtils;
import bai_tap_lam_them.bai_lam_them_2.models.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_CUSTOMER = "customer.csv";
    public static void AddNewCustomer(){
        int choose;
        do{
            try{
                System.out.println("---You choice new Customer---");
                System.out.println("1. Add new Customer VN\n" +
                        "2. Add new Customer Foreign\n"+
                        "3. Back to menu\n"+
                        "4. Exit" );
                System.out.println("-----------------------------");
                System.out.print("Enter choose: ");
                choose= Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        FileUtils.writeFile(FILE_CUSTOMER,CreateObject.createCustomerVn().toString(),true);
                        break;
                    case 2:
                        FileUtils.writeFile(FILE_CUSTOMER,CreateObject.createCustomerForeign().toString(),true);
                        break;
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("You input error!!!");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }while (true);
    }
    public static void displayCustomer(){
        System.out.println("---List customer---");
        List<Customer>  listCustomer = FileUtils.readFileObject(FILE_CUSTOMER);
        for(Customer customer : listCustomer){
            System.out.println(listCustomer.indexOf(customer)+1+". "+customer.showInfo());
        }
    }

    public static void searchCustomer(){
        System.out.print("Enter name customer need find: ");
        String name = scanner.nextLine();
        List<Customer>  listCustomer = FileUtils.readFileObject(FILE_CUSTOMER);
        do{
            for(Customer customer : listCustomer){
                if(customer.getName().equals(name) ){
                    System.out.println(customer.showInfo());
                    return;
                }
            }
            System.out.println("Not found customer is name "+name);
        }while (true);
    }
}
