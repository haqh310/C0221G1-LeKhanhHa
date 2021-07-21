package bai_tap_lam_them.bai_lam_them_1.controllers;

import bai_tap_lam_them.bai_lam_them_1.commons.CreatVehicle;
import bai_tap_lam_them.bai_lam_them_1.commons.Display;
import bai_tap_lam_them.bai_lam_them_1.commons.FileUtils;
import bai_tap_lam_them.bai_lam_them_1.commons.NotFoundVehicleException;

import java.util.List;
import java.util.Scanner;

public class VehicleController {
    static Scanner scanner = new Scanner(System.in);

    public static void addNewVehicle() {
        int choose;
        String vehicleToString;
        do {
            System.out.println("\n---Add new vehicle---");
            System.out.println("1. Add new Car\n" +
                    "2. Add new Truck \n" +
                    "3. Add new Motorcycle\n" +
                    "4. Return menu\n" +
                    "5. Exit");
            System.out.print("Enter a choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    vehicleToString = CreatVehicle.createCar().toString();
                    FileUtils.setPath("vehicle");
                    FileUtils.writeFile(vehicleToString);
                    break;
                case 2:
                    vehicleToString = CreatVehicle.createTruck().toString();
                    FileUtils.setPath("vehicle");
                    FileUtils.writeFile(vehicleToString);
                    break;
                case 3:
                    vehicleToString = CreatVehicle.createMotorcycle().toString();
                    FileUtils.setPath("vehicle");
                    FileUtils.writeFile(vehicleToString);
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("You input error!!!");
            }
        } while (true);
    }


    public static void displayVehicle() {
        int choose;
        do {
            System.out.println("\n---Display list vehicle---");
            System.out.println("1.Display list Car\n" +
                    "2. Display list Truck \n" +
                    "3. Display list Motorcycle\n" +
                    "4. Return menu\n" +
                    "5. Exit");
            System.out.print("Enter choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    Display.displayCar();
                    break;
                case 2:
                    Display.displayTruck();
                    break;
                case 3:
                    Display.displayMotorcycle();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("You input error!!!");
            }
        }
        while (true);
    }

    public static void deleteVehicle(){
        String numberDelete = scanner.nextLine();
        List<String> listVehicle =FileUtils.readFile();
        boolean check =false;
        do{
            try{
                System.out.println("\n---Delete vehicle by number plate---");
                System.out.print("Enter number plate: ");
                FileUtils.resetFile();
                for(String vehicle: listVehicle){
                    String numberPlate = vehicle.split(",")[0];
                    if(numberPlate.equals(numberDelete)){
                        check=true;
                        System.out.println("1.Yes\n" +
                                "2.No");
                        int choose = Integer.parseInt(scanner.nextLine());
                        switch (choose){
                            case 1:
                                System.out.println("Deleted vehicle!!!");
                                continue;
                            case 2:
                                break;
                        }
                    }
                    FileUtils.writeFile(vehicle);
                }
                if(!check){
                    throw new NotFoundVehicleException("Number plate not exist!!!");
                }
                break;
            }catch (NotFoundVehicleException e){
                System.out.println(e);
            }

        }
      while (true);
    }

}
