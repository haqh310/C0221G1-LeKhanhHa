package case_study_module_2.services;

import case_study_module_2.models.Customer;
import case_study_module_2.validations.ValidatePerson;

public class CreatePerson {
    public static Customer createCustomer(){
            String name = ValidatePerson.validateName();
            String birthday = ValidatePerson.validateBirthday();
            String gender = ValidatePerson.validateGender();
            String idCard = ValidatePerson.validateIdCArd();
            String phone = ValidatePerson.validatePhone();
            String email = ValidatePerson.validateEmail();
            String typeGuest = ValidatePerson.validateTypeGuest();
            String address = ValidatePerson.validateAddress();
            return new Customer(name, birthday, gender, idCard, phone, email, typeGuest, address);
    }

}
