package bai_tap_lam_them.bai_lam_them_2.commons;

import bai_tap_lam_them.bai_lam_them_2.models.Customer;
import bai_tap_lam_them.bai_lam_them_2.models.CustomerForeign;
import bai_tap_lam_them.bai_lam_them_2.models.CustomerVN;
import bai_tap_lam_them.bai_lam_them_2.models.Invoice;

import java.util.List;

public class CreateObject {
    public static CustomerVN createCustomerVn(){
       String idCustomer = Validate.validateIdCustomer("^KHVN-[0-9]{5}$");
       String name = Validate.validateName();
       String typeOfGuest = Validate.validateTypeOfGuest();
       double consumption = Validate.validateConsumption();
       return new CustomerVN(idCustomer,name,typeOfGuest,consumption);
    }

    public static CustomerForeign createCustomerForeign(){
        String idCustomer = Validate.validateIdCustomer("^KHNN-[0-9]{5}$");
        String name = Validate.validateName();
        String nationality = Validate.validateNationality();
        return new CustomerForeign(idCustomer,name,nationality);
    }

    public static Invoice createInvoice(Customer customer){
        List<Invoice> invoices = FileUtils.readFileObject("invoice.csv");
        String idInvoice ;
        int i=-1;
        if(invoices.isEmpty()){
            idInvoice = "MHD-001";
        }
        else {
            idInvoice = "MHD-00"+ (Integer.parseInt(invoices.get(invoices.size() -1).getIdInvoice().split("")[6])+1);
        }
         String idCustomer = customer.getIdCustomer();
         String date = Validate.validateDate();
         double count = Validate.validateNumber("count");
         double price = Validate.validateNumber("price");
        return new Invoice(idInvoice,idCustomer,date,count,price,customer);
    }
}
