package bai_tap_lam_them.bai_lam_them_1.controllers;

import java.util.Scanner;

public class MainController {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("----TRAFFIC VEHICLE MANAGEMENT PROGRAM----");
            System.out.println("1. Add new vehicle\n" +
                    "2. Display vehicle\n" +
                    "3. Delete vehicle\n" +
                    "4. Exit\n");
            System.out.print("Enter a choose: ");
             choose= Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    VehicleController.addNewVehicle();
                    break;
                case 2:
                    VehicleController.displayVehicle();
                    break;
                case 3:
                    VehicleController.deleteVehicle();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("You input error!!!");
            }
        }
        while(true);
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
