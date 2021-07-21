package bai_tap_lam_them.bai_lam_them_1.commons;

import bai_tap_lam_them.bai_lam_them_1.controllers.ManufactureController;

import java.util.Scanner;

public class Validate {
    static Scanner scanner = new Scanner(System.in);
    public static String validateNumberPlate(String regex){
        String numberPlate;
        do{
            try{
                System.out.print("Enter number plate: ");
                numberPlate = scanner.nextLine();
                if(!numberPlate.matches(regex)){
                    throw new Exception("Number plate must be format XXY-XXX.XXX");
                }
                break;
            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return numberPlate;
    }

    public static String validateManufacturer(){
        String manufacturer;
        do{
            try {
                manufacturer= ManufactureController.chooseManufacture();
                break;
            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
      return manufacturer;
    }

    public static String validateYear() {
        String year;
        do{
            try{
                System.out.print("Enter year of manufacture: ");
                year = scanner.nextLine();
                String regex = "^[1-2][0-9]{3}$";
                if(!year.matches(regex)){
                   throw new Exception("Year must be format Number");
                }
                break;
            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return year;
    }

    public static String validateOwner(){
        String owner;
        do{
            try{
                System.out.print("Enter owner: ");
                owner= scanner.nextLine();
                String[] arrOwner = owner.split(" ");
               // String regex = "^[\\ a-zA-Z]+$";
                String regex = "^\\D+$";
                if(!owner.matches(regex)){
                    throw new Exception("Name owner must be format character");
                }
                break;
            }
           catch (Exception e){
               System.out.println(e);
           }
        }while (true);
        return owner;
    }

    public static int validateNumberOfSeat(){
        int numberOfSeat;
        do{
            try{
                System.out.print("Enter number of seat: ");
                String regex = scanner.nextLine();
                if(!regex.matches("^[1-9][0-9]*$")){
                    throw new Exception("Number of seat must be format Number");
                }
                numberOfSeat= Integer.parseInt(regex);
                break;
            }
            catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return numberOfSeat;
    }

    public static double validateNumber() {
        double number;
        do {
            try {
                System.out.print("Enter payload: ");
                number = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("You input error");
            }
        } while (true);
        return number;
    }

}
