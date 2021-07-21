package bai_tap_lam_them.bai_lam_them_1.commons;

import bai_tap_lam_them.bai_lam_them_1.models.Car;
import bai_tap_lam_them.bai_lam_them_1.models.Motorcycle;
import bai_tap_lam_them.bai_lam_them_1.models.Truck;

import java.util.Scanner;

public class CreatVehicle {
    static Scanner scanner = new Scanner(System.in);
    public static Car createCar(){
        String numberPlate = Validate.validateNumberPlate("^[0-9]{2}[AB]-[0-9]{3}.[0-9]{2}$");
        String manufacture = Validate.validateManufacturer();
        String year = Validate.validateYear();
        String owner = Validate.validateOwner();
       int numberOfSeat = Validate.validateNumberOfSeat();
       String modelOfCar;
       if(numberPlate.contains("A")){
           modelOfCar="Du lịch";
       }else {
           modelOfCar="Xe Khách";
       }
       return new Car(numberPlate,manufacture,year,owner,numberOfSeat,modelOfCar);
    }

    public static Truck createTruck() {
        String numberPlate = Validate.validateNumberPlate("^[0-9]{2}C-[0-9]{3}.[0-9]{2}$");
        String manufacture = Validate.validateManufacturer();
        String year = Validate.validateYear();
        String owner = Validate.validateOwner();
        double payload = Validate.validateNumber();
        return new Truck(numberPlate, manufacture, year, owner, payload);
    }

    public static Motorcycle createMotorcycle(){
        String numberPlate = Validate.validateNumberPlate("^[0-9]{2}-[A-Z][A-Z0-9]-[0-9]{3}.[0-9]{2}$");
        String manufacture = Validate.validateManufacturer();
        String year = Validate.validateYear();
        String owner = Validate.validateOwner();
        double wattage = Validate.validateNumber();
        return new Motorcycle(numberPlate,manufacture,year,owner,wattage);
    }

}
