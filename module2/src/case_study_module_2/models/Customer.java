package case_study_module_2.models;

public class Customer extends Person implements Comparable<Customer>{
    private String typeOfCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String idCard, String phoneNumber, String email, String typeOfCustomer, String address) {
      super(name, birthday, gender, idCard, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }
    public Customer(String[] arr) {
        super(arr);
        this.typeOfCustomer = arr[6];
        this.address = arr[7];
    }
    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String showInFor() {
        return "Customer{" +
                "Full Name='" + super.getFullName() + '\'' +
                ", Date of Birth='" + super.getDateOfBirth() + '\'' +
                ", Gender='" + super.getGender() + '\'' +
                ", Id Card='" + super.getIdCard() + '\'' +
                ", Phone Number='" + super.getPhoneNumber() + '\'' +
                ", Email='" + super.getEmail() + '\'' +
                ", Type of Customer='" + typeOfCustomer + '\'' +
                ", Address='" + address +
                ", Service="+ services+
                '}';
    }

    @Override
    public int compareTo(Customer o) {
       if(this.getFullName().equals(o.getFullName())){
           return Integer.parseInt(getDateOfBirth().split("/")[2]) - Integer.parseInt(o.getDateOfBirth().split("/")[2]);
       }
       return getFullName().compareTo(o.getFullName());
    }


    @Override
    public String toString() {
        return super.toString() +
                "," + typeOfCustomer +
                "," + address +
                "," + services;
    }

    @Override
    public String showInfo() {
        return "Customer{" +
                "fullName='" + getFullName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", idCard='" + getIdCard() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }
}
