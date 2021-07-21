package case_study_module_2.controllers;

import case_study_module_2.services.DisplayServices;
import case_study_module_2.commons.*;
import case_study_module_2.services.CreateServices;
import case_study_module_2.models.Services;

import java.util.List;
import java.util.Scanner;

public class ServicesController {
    public static Scanner scanner = new Scanner(System.in);
    static String fileServices = "services.csv";

    public static void addNewServices() {
        int number = 0;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.print("Enter a number: ");
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    FileUtils.writeFileObject(fileServices, CreateServices.creatVilla(), true);
                    break;
                case 2:
                    FileUtils.writeFileObject(fileServices, CreateServices.creatHouse(), true);
                    break;
                case 3:
                    FileUtils.writeFileObject(fileServices, CreateServices.creatRoom(), true);
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("You input error!!!");
            }
        }
        while (number != 5);
    }

    public static void showServices() {
        int number = 0;
        List<Services> servicesList = FileUtils.readFileServices(fileServices);
        do {
            try {
                System.out.println("1.\tShow all Villa\n" +
                        "2.\tShow all House\n" +
                        "3.\tShow all Room\n" +
                        "4.\tShow All Name Villa Not Duplicate\n" +
                        "5.\tShow All Name House Not Duplicate\n" +
                        "6.\tShow All Name Name Not Duplicate\n" +
                        "7.\tBack to menu\n" +
                        "8.\tExit\n");
                System.out.print("Enter choice: ");
                number = Integer.parseInt(scanner.nextLine());
                switch (number) {
                    case 1:
                        DisplayServices.displayAllVilla(servicesList);
                        break;
                    case 2:
                        DisplayServices.displayAllHouse(servicesList);
                        break;
                    case 3:
                        DisplayServices.displayAllRoom(servicesList);
                        break;
                    case 4:
                        DisplayServices.displayNameVilla(servicesList);
                        break;
                    case 5:
                        DisplayServices.displayNameHouse(servicesList);
                        break;
                    case 6:
                        DisplayServices.displayNameRoom(servicesList);
                        break;
                    case 7:
                        return;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("You input error!!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true);
    }

}
