import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public static List<Customer> addCustomer(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mai Văn Hoàng","1983-08-20","Hà Nội","https://www.paratime.vn/wp-content/uploads/2020/02/TIME-Studio-headshot-3-elements.jpg"));
        customers.add(new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjZfHVdwISo5s3k2Mzbh-venrjCTwfjq8lFBkOLbg6UG11OPoE7N2WIRDcAuwER5Gr7bA&usqp=CAU"));
        customers.add(new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://www.paratime.vn/wp-content/uploads/2017/02/timestudio.vn-corporate-12.jpg"));
        customers.add(new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","https://bluemotionmedia.vn/wp-content/uploads/2020/11/mach-ban-dia-chi-chup-anh-chan-dung-ceo-chuyen-nghiep-o-hue_5fc4f6067839e.jpeg"));
        customers.add(new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://www.paratime.vn/wp-content/uploads/2019/09/timestudio.vn-headshot-eye-glasses-02.jpg"));
        return customers;
    }
}
