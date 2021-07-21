package bai_tap_lam_them.bai_lam_them_2.controller;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMenu(){
        int choose ;
        do{
            System.out.println("---ELECTRICAL BILL MANAGEMENT PROGRAM---");
            System.out.println("Select the function:\n" +
                    "1. Add new customer\n" +
                    "2. Display customer information \n" +
                    "3. Search customer\n" +
                    "4. Add new electric invoice\n" +
                    "5. Edit electric invoice\n" +
                    "6. Display invoice information\n" +
                    "7. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    CustomerController.AddNewCustomer();
                    break;
                case 2:
                    CustomerController.displayCustomer();
                    break;
                case 3:
                    CustomerController.searchCustomer();
                    break;
                case 4:
                    InvoiceController.addNewInvoice();
                    break;
                case 5:
                    InvoiceController.editInvoice();
                    break;
                case 6:
                    InvoiceController.showInvoice();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("You input error!!!");
            }
        }
       while (true);
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
