package bai_tap_lam_them.bai_lam_them_2.controller;

import bai_tap_lam_them.bai_lam_them_2.commons.CreateObject;
import bai_tap_lam_them.bai_lam_them_2.commons.FileUtils;
import bai_tap_lam_them.bai_lam_them_2.models.Customer;
import bai_tap_lam_them.bai_lam_them_2.models.Invoice;

import java.util.*;

public class InvoiceController {
    static final String FILE_CUSTOMER = "customer.csv";
    static final String FILE_INVOICE="invoice.csv";
    static List<Invoice> invoiceList ;
    static List<Customer> customerList;
    static Scanner scanner = new Scanner(System.in);
    public static void addNewInvoice(){
        invoiceList = FileUtils.readFileObject(FILE_INVOICE);
        int choice;
        do{
            try{
                choice = choiceCustomer();
                if(choice >0 &&choice <= customerList.size()){
                    FileUtils.writeFile(FILE_INVOICE, CreateObject.createInvoice(customerList.get(choice-1)).toString(),true);
                    break;
                }else {
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("You input error!!!");
        }while (true);
    }

    public static void editInvoice(){
        invoiceList = FileUtils.readFileObject(FILE_INVOICE);
        int choice;
        int choiceCustomer;
        do{
            try{
                System.out.println("---List electric invoice---");
                for(Invoice invoice : invoiceList){
                    System.out.println((invoiceList.indexOf(invoice)+1) +". "+invoice.showInfo());
                }
                System.out.println(invoiceList.size()+1+". Back to menu");
                System.out.print("Enter choice invoice need edit (1-"+ (invoiceList.size()+1)+"): ");
                choice = Integer.parseInt(scanner.nextLine());
                if(choice > 0 && choice <= invoiceList.size()){
                    choiceCustomer = choiceCustomer();
                    if(choiceCustomer >0 && choiceCustomer <= customerList.size()){
                        invoiceList.get(choice-1).setIdCustomer(customerList.get(choiceCustomer-1).getIdCustomer());
                        System.out.println(invoiceList.get(choice-1));
                    }
                }
                else {
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("You input error!!!");
            }finally {
                FileUtils.writeFile(FILE_INVOICE,invoiceList,false);
            }
        }
        while (true);

    }

    public static void showInvoice(){
        invoiceList = FileUtils.readFileObject(FILE_INVOICE);
        do{
            try{
                System.out.println("---List electric invoice---");
                for(Invoice invoice : invoiceList){
                    System.out.println((invoiceList.indexOf(invoice)+1) +". "+invoice.showInfo());
                }
                System.out.println((invoiceList.size()+1)+". Back to menu");
                System.out.print("Enter choice invoice need view (1-"+ (invoiceList.size()+1)+"): ");
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice > 0 && choice <= invoiceList.size()){
                    customerList = FileUtils.readFileObject(FILE_CUSTOMER);
                    for(Customer customer : customerList){
                        if(customer.getIdCustomer().equals(invoiceList.get(choice-1).getIdCustomer())){
                            invoiceList.get(choice-1).setIdCustomer(customer.getName());
                            break;
                        }
                    }
                }
                else {
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("You input error!!!");
            }
        }
        while (true);
    }

    public static int choiceCustomer(){
        customerList= FileUtils.readFileObject(FILE_CUSTOMER);
        int choice;
        do{
            try{
                System.out.println("---List customer---");
                for(Customer customer : customerList){
                    System.out.println(customerList.indexOf(customer) +1 +". "+customer.showInfo());
                }
                System.out.println(customerList.size()+1 +". Back to menu");
                System.out.print("Enter customer :(1-"+(customerList.size()+1)+"): ");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (true);
        return choice;
    }

}
