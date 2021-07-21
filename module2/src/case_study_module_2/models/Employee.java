package case_study_module_2.models;

public class Employee extends Person implements ShowInfo {
    private String address;

    public Employee() {
    }

    public Employee(String fullName, String dateOfBirth, String address) {
        setFullName(fullName);
        setDateOfBirth(dateOfBirth);
        this.address = address;
    }
    public Employee(String[] arr) {
        setFullName(arr[0]);
        setDateOfBirth(arr[1]);
        this.address = arr[2];
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  getFullName() +
                "," + getDateOfBirth() +
                "," + address ;
    }

    @Override
    public String showInfo() {
        return "Employee{" +
                "fullName='" + getFullName() + '\'' +
                ", birthday='" +  getDateOfBirth() + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
