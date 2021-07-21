package model.service.common;

import java.sql.Date;

public class Validate {
    Regex regex = new Regex();
    public String validateCustomerCode(String code) {
        String message=null;
        if(!code.matches(regex.REGEX_CUSTOMER)){
            message =  "Customer code format KH-XXXX";
        }
        return message;
    }
    public String validateServiceCode(String code) {
        String message=null;
        if(!code.matches(regex.REGEX_SERVICE)){
            message ="service code format DV-XXXX";
        }
        return message;
    }
    public String validatePhone(String phone){
        String message=null;
        if (!phone.matches(regex.REGEX_PHONE)) {
           message ="Phone format 090XXXXXXX or 091090XXXXXXX ";
        }
        return message;
    }
    public String validateDate(Date date){
        String message=null;
        if (!date.toString().matches(regex.REGEX_DATE)){
            message="Date format YYYY-MM-DD";
        }
        return message;
    }
    public String validateIdCard(String id_card) {
        String message=null;
        if (!id_card.matches(regex.REGEX_ID_CARD)) {
            message ="Id card format 0-9";
        }
        return message;
    }
    public String validateEmail(String email){
        String message=null;
        if (email != null && !email.matches(regex.REGEX_EMAIL)) {
            message="email format abc@xyz.abc";
        }
        return message;
    }
    public String validateTypeInt(int num){
        String message=null;
        if(num <0 ){
            message ="number integer > 0";
        }
        return message;
    }
    public String validateTypeDouble(double num){
        String message=null;
        if(num < 0 ){
            message ="number double > 0";
        }
        return message;
    }
}
