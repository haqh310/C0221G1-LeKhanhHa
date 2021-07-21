package case_study_module_2.validations;

import case_study_module_2.exception.ServicesException;
import case_study_module_2.models.ExtraService;

import java.util.Scanner;

public class ValidateExtraService extends ServicesException {
    Scanner scanner = new Scanner(System.in);

    public String inputName() {
        String name;
        do {
            try {
                System.out.print("Enter name accompanied Services: ");
                name = nameExtraServiceException(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true);
        return name;
    }

    public String inputUnit() {
        String unit;
        do {
            try {
                System.out.print("Enter unit: ");
                unit = unitException(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true);
    }

    public double inputPrice() {
        double price;
        do {
            try {
                System.out.print("Enter price: ");
                price = Integer.parseInt(scanner.nextLine());
                priceException(price);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return price;
    }

}
