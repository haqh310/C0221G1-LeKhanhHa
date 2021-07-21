package case_study_module_2.exception;

public class PersonException {
    static String regex;


    public static void nameException(String name) throws Exception {
        regex = "^[ a-zA-Z]+$";
        if (!name.matches(regex)) {
            throw new Exception("Not is  character string");
        }
        String[] arrName = name.split(" ");
        String[] listString = null;
        boolean check;
        for (String string : arrName) {
            if (string.equals("")) {
                throw new Exception("You input error!!!");
            }
            listString = string.split("");
            for (int i = 0; i < listString.length; i++) {
                check = listString[i].toUpperCase().equals(listString[i]);
                if ((i == 0 && !check) || (i != 0 && check)) {
                    throw new Exception("You input error!!!");
                }
            }
        }
    }

    public static class DateException extends Exception {
        public DateException(String message) {
            super(message);
        }
    }

    public static void birthdayException(String birthday) throws DateException, Exception {
        regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}";
        if (!birthday.matches(regex)) {
            throw new DateException("Birthday must be format dd/mm/yyyy");
        }
        String[] listDay = birthday.split("/");
        boolean check = 2021 - Integer.parseInt(listDay[2]) > 18 && Integer.parseInt(listDay[2]) > 1900;
        if (!check) {
            throw new Exception("The year of birth must be greater than 1900 and less than the current is 18 years ");
        }
    }

    public static void emailException(String email) throws Exception {
        regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!email.matches(regex)) {
            throw new Exception("Email must be format abc@abc.abc");
        }
    }

    public static String genderException(String gender) throws Exception {
        regex = "^(male|female|unknown)$";
        if (gender.toLowerCase().matches(regex)) {
            return gender.toLowerCase();
        }
        throw new Exception("Gender must be Male, Female, Unknown");
    }

    public static void idCardException(String idCard) throws Exception {
        regex = "^[a-zA-Z0-9]{3} [a-zA-Z0-9]{3} [a-zA-Z0-9]{3}$";
        if (!idCard.matches(regex)) {
            throw new Exception("Id Card must have 9 digits and be in format XXX XXX XXX");
        }
    }


    public static void phoneException(String phone) throws Exception {
        regex = "^[0-9]{10}$";
        if (!phone.matches(regex)) {
            throw new Exception("Phone must be serial number ");
        }
    }

    public static String typeGuestException(String typeGuest) throws Exception {
        regex = "^(diamond|platinum|gold|silver|member)$";
        if (typeGuest.toLowerCase().matches(regex)) {
            return typeGuest.toLowerCase();
        }
        throw new Exception("Type guest must belong {Diamond, Platinum, Gold, Silver, Member}");
    }

    public static void addressException(String address) throws Exception {
        regex = "^[-,a-zA-z0-9]+$";
        if (address.matches(regex)) {
            throw new Exception("You input error!!!");
        }
    }

    public static String levelException(String level) throws Exception {
        regex = "^(intermediate|college|university|postgraduate)$";
        if (level.toLowerCase().matches(regex)) {
            return level.toLowerCase();
        }
        throw new Exception("Level must belong {Intermediate, College, University, Postgraduate}");
    }

    public static String positionException(String position) throws Exception {
        regex = "^(receptionist|waitress|specialist|supervisor|manager|director)$";
        if (position.toLowerCase().matches(regex)) {
            return position.toLowerCase();
        }
        throw new Exception("Position must belong  {receptionist, waitress, specialist, supervisor, manager, director}");
    }

}
