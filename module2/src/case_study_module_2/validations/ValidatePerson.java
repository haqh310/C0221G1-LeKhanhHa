package case_study_module_2.validations;

import case_study_module_2.exception.PersonException;

import java.util.Scanner;

public class ValidatePerson extends PersonException {
   static Scanner scanner = new Scanner(System.in);

    public static String validateName() {
        String name = null;
        do {
            try {
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                nameException(name);
                break;
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        while (true);
        return name;
    }

    public static String validateBirthday() {
        String birthday = null;
        do {
            try {
                System.out.print("Enter birthday: ");
                birthday = scanner.nextLine();
                birthdayException(birthday);
                break;

            } catch (DateException e) {
                System.err.println(e);
            } catch (Exception e) {
                System.err.println(e);
            }
        } while (true);
        return birthday;
    }

    public static String validateEmail() {
        String email = null;
        do {
            try {
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                emailException(email);
                break;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        while (true);
        return email;
    }

    public static String validateGender() {
        String gender = null;
        do {
            try {
                System.out.print("Enter gender: ");
                gender = scanner.nextLine();
                if (!genderException(gender).isEmpty()) {
                    return genderException(gender);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } while (true);
    }

    public static String validateIdCArd() {
        Scanner scanner = new Scanner(System.in);
        String idCard = null;
        do {
            try {
                System.out.print("Enter Id Card: ");
                idCard = scanner.nextLine();
                idCardException(idCard);
                break;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        while (true);
        return idCard;
    }

    public static String validatePhone(){
        String phone;
        do{
            try{
                System.out.print("Enter phone: ");
                phone = scanner.nextLine();
                phoneException(phone);
                break;
            }catch (Exception e){
                System.err.println(e);
            }
        }while (true);
        return phone;
    }

    public static String validateTypeGuest(){
        String typeGuest;
        do{
            try{
                System.out.print("Enter type guest: ");
                typeGuest = scanner.nextLine();
                typeGuestException(typeGuest);
                break;
            }catch (Exception e){
                System.err.println(e);
            }
        }while (true);
        return typeGuest;
    }

    public static String validateAddress(){
        String address;
        do{
            try{
                System.out.print("Enter address: ");
                address = scanner.nextLine();
                addressException(address);
                break;
            }catch (Exception e){
                System.err.println(e);
            }
        }while (true);
        return address;
    }

}
