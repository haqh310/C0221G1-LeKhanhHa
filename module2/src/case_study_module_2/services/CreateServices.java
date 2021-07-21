package case_study_module_2.services;


import case_study_module_2.models.*;
import case_study_module_2.validations.ValidateServices;
import case_study_module_2.validations.ValidateExtraService;

public  class CreateServices {
    public static Villa creatVilla() {
        String name = ValidateServices.validateName();
        String id = ValidateServices.validateId("Villa");
        double area = ValidateServices.validateArea();
        double price = ValidateServices.validatePrice();
        int numPerson = ValidateServices.validateNumPerson();
        String rentalType = ValidateServices.validateRentalType();
        String roomStandard = ValidateServices.validateRoomStandard();
        String convenient = ValidateServices.validateConvenient();
        int floors = ValidateServices.validateFloors();
        double poolArea = ValidateServices.validatePoolArea();
        return new Villa( id,name, area, price, numPerson, rentalType, roomStandard, convenient, poolArea, floors);
    }
    public static House creatHouse(){
        String name = ValidateServices.validateName();
        String id = ValidateServices.validateId("House");
        double area = ValidateServices.validateArea();
        double price = ValidateServices.validatePrice();
        int numPerson = ValidateServices.validateNumPerson();
        String rentalType = ValidateServices.validateRentalType();
        String roomStandard = ValidateServices.validateRoomStandard();
        String convenient = ValidateServices.validateConvenient();
        int floors = ValidateServices.validateFloors();
        return new House(id,name, area, price, numPerson, rentalType, roomStandard, convenient, floors);
    }
    public static Room creatRoom(){
        String name = ValidateServices.validateName();
        String id = ValidateServices.validateId("Room");
        double area = ValidateServices.validateArea();
        double price = ValidateServices.validatePrice();
        int numPerson = ValidateServices.validateNumPerson();
        String rentalType = ValidateServices.validateRentalType();
        return new Room(id, name,area,price, numPerson,rentalType,creatExtraService());
    }
    public static ExtraService creatExtraService(){
        ValidateExtraService services = new ValidateExtraService();
        return new ExtraService(services.inputName(),services.inputUnit(),services.inputPrice());
    }
}
