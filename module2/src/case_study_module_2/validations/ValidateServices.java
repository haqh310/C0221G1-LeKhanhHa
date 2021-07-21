package case_study_module_2.validations;

import case_study_module_2.exception.ServicesException;

import java.util.Scanner;

public class ValidateServices extends ServicesException {
    static Scanner scanner = new Scanner(System.in);

    public static String validateName() {
        String name;
        do {
            try {
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                nameServicesException(name);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return name;
    }

    public static String validateId(String name) {
        String id;
        do {
            try {
                System.out.print("Enter id: ");
                id = scanner.nextLine();
                idException(id,name);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return id;
    }

    public static double validateArea(){
        double area;
        do {
            try{
                System.out.print("Enter area: ");
                area = Double.parseDouble(scanner.nextLine());
                areaException(area);
                break;

            }catch (Exception e){
                System.out.println(e);
            }
        }while (true);
        return area;
    }

    public static double validatePrice() {
        double price;
        do {
            try {
                System.out.print("Enter price: ");
                price = Double.parseDouble(scanner.nextLine());
                priceException(price);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return price;
    }

    public static int validateNumPerson() {
        int numPerson;
        do {
            try {
                System.out.print("Enter number people: ");
                numPerson = Integer.parseInt(scanner.nextLine());
                numPersonException(numPerson);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return numPerson;
    }

    public static String validateRentalType(){
        String type;
        do {
            try {
                System.out.print("Enter Rental Type: ");
                type = scanner.nextLine();
                rentalTypeException(type);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return type;
    }

    public static String validateRoomStandard() {
        String roomStandard;
        do {
            try {
                System.out.print("Enter room standard: ");
                roomStandard = scanner.nextLine();
                roomStandardException(roomStandard);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true);
        return roomStandard;
    }

    public static String validateConvenient() {
        String convenient;
        do {
            try {
                System.out.print("Enter convenient: ");
                convenient = scanner.nextLine();
                nameServicesException(convenient);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return convenient;
    }

    public static int validateFloors() {
        int floors;
        do {
            try {
                System.out.print("Enter number floor: ");
                floors = Integer.parseInt(scanner.nextLine());
                floorsException(floors);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true);
        return floors;
    }
    public static double validatePoolArea() {
        double poolArea;
        do {
            try {
                System.out.print("Enter pool area: ");
                poolArea = Double.parseDouble(scanner.nextLine());
                areaException(poolArea);
                break;

            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return poolArea;
    }

}
