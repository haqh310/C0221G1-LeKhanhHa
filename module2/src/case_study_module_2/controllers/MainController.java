package case_study_module_2.controllers;

import java.util.*;

public class MainController  {
   static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {
        int number;
        do {
            System.out.println("1.\t Add New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    ServicesController.addNewServices();
                    break;
                case 2:
                    ServicesController.showServices();
                    break;
                case 3:
                    CustomerController.addNewCustomer();
                    break;
                case 4:
                    CustomerController.showInformationOfCustomer();
                    break;
                case 5:
                    BookingController.addNewBooking();
                    break;
                case 6:
                   EmployeeController.showInformationOfEmployee();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("You input error!!!");
            }
        }
        while (number != 7);
    }

}
