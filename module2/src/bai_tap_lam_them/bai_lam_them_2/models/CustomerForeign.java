package bai_tap_lam_them.bai_lam_them_2.models;

public class CustomerForeign  extends Customer {
    private String nationality;

    public CustomerForeign() {
    }

    public CustomerForeign(String nationality) {
        this.nationality = nationality;
    }

    public CustomerForeign(String id, String name, String nationality) {
        super(id, name);
        this.nationality = nationality;
    }
    public CustomerForeign(String[] arr) {
        super(arr);
        this.nationality = arr[2];
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + nationality ;
    }

    @Override
    public String showInfo() {
        return "CustomerForeign{" +
                "idCustomer='" + getIdCustomer() + '\'' +
                ", name='" + getName() + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }


}
