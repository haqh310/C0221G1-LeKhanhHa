package case_study_module_2.exception;

public class ServicesException {
    static String regex;

    public static void nameServicesException(String name) throws Exception {
        regex = "^[A-Z][a-z0-9]+$";
        if (!name.matches(regex)) {
            throw new Exception("You input error!!!");
        }
    }

    public static void idException(String id,String name) throws Exception {
        if (name.equals("Villa")){
            regex = "^SVVL-[0-9]{4}$";
        }else if(name.equals("House")){
            regex = "^SVHO-[0-9]{4}$";
        }else {
            regex="^SVRO-[0-9]{4}$";
        }
        if (!id.matches(regex)) {
            throw new Exception("Id must be format SVXX-YYYY");
        }
    }

    public static void priceException(double price) throws Exception {
        if (price < 0) {
            throw new Exception("Price must be greater than 0");
        }
    }

    public static void numPersonException(int numPerson) throws Exception {
        if (numPerson <= 0 && numPerson > 20) {
            throw new Exception("Number Person must be greater than 0 and smaller than 20");
        }
    }

    public static String nameExtraServiceException(String nameExtraService) throws Exception {
        regex="^(massage|karaoke|food|drink|car)$";
       if(nameExtraService.toLowerCase().matches(regex)){
           return nameExtraService.toLowerCase();
       }
        throw new Exception("Free Services must be {massage, karaoke, food, drink, car}");
    }

    public static void floorsException(double floor) throws Exception {
        if (floor <= 0) {
            throw new Exception("Floor must be greater than 0");
        }
    }

    public static void areaException(double poolArea) throws Exception {
        if (poolArea < 30) {
            throw new Exception("Pool Area must be great than 30 m2");
        }
    }

    public static String rentalTypeException(String rentalType) throws Exception {
        regex="^(year|month|day|hours)$";
        if(rentalType.toLowerCase().matches(regex)){
            return rentalType.toLowerCase();
        }
        throw new Exception("Rental Type must belong {year, month, day, hours}");
    }

    public static String unitException(String unit) throws Exception {

        regex = "^(VND|USD)$";
        if(unit.toUpperCase().matches(regex)){
            return unit.toUpperCase();
        }
        throw new Exception("Unit must belong {VND, USD}");
    }

    public static void roomStandardException(String roomStandard) throws Exception {
        regex = "^[*]+$";
        if (!roomStandard.matches(regex)) {
            throw new Exception("Room Standard must be *");
        }
    }

}
