package bai_tap_lam_them.bai_lam_them_2.commons;

import bai_tap_lam_them.bai_lam_them_2.controller.TypeOfGuestController;

import java.util.Scanner;

public class Validate {
    public static Scanner scanner = new Scanner(System.in);

    public static String validateIdCustomer(String regex) {
        String idCustomer;
        do {
            try {
                System.out.print("Enter id customer: ");
                idCustomer = scanner.nextLine();
                if (!idCustomer.matches(regex)) {
                    throw new Exception("Id customer must be format KYY-XXXXX");
                }
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return idCustomer;
    }

    public static String validateName() {
        String name;
        String regex = "^\\D+$";
        do {
            try {
                System.out.print("Enter name customer: ");
                name = scanner.nextLine();
                if (!name.matches(regex)) {
                    throw new Exception("Name customer must be format character");
                }
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return name;
    }

    public static String validateTypeOfGuest() {
        return TypeOfGuestController.chooseType();
    }

    public static double validateConsumption() {
        double consumption;
        String regex = "^[1-9][0-9]*$";
        do {
            try {
                System.out.print("Enter consumption: ");
                String text = scanner.nextLine();
                if (text.matches(regex)) {
                    consumption = Integer.parseInt(text);
                    break;
                }
                throw new Exception("Consumption must be format Number!!!");
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return consumption;
    }

    public static String validateNationality() {
        String nationality;
        String regex = "^[a-zA-Z ]+$";
        do {
            try {
                System.out.print("Enter Nationality: ");
                nationality = scanner.nextLine();
                if (!nationality.matches(regex)) {
                    throw new Exception("Nationality must be format Character");
                }
                break;
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (true);
        return nationality;
    }

    public static String validateDate(){
        String date;
        String regex = "^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$";
        do{
            try{
                System.out.print("Enter date: ");
                date = scanner.nextLine();
                if(!date.matches(regex)){
                    throw new Exception("Date must be format XX/XX/XXXX");
                }
                break;
            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return date;
    }

    public static double validateNumber(String name){
        double number;
        String temp;
        String regex = "^[0-9]+$";
        do{
            try{
                System.out.print("Enter "+name+": ");
                temp = scanner.nextLine();
                if(temp.matches(regex)){
                    number =Integer.parseInt(temp);
                    break;
                }
                throw new Exception("Date must be format XX/XX/XXXX");
            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return number;
    }

}
