package bai_tap_lam_them.bai_lam_them_2.models;

public class CustomerVN  extends Customer{
    private String typeOfGuest;
    private double consumption;

    public CustomerVN() {
    }

    public CustomerVN(String id, String name, String typeOfGuest, double consumption) {
        super(id,name);
        this.typeOfGuest = typeOfGuest;
        this.consumption = consumption;
    }
    public CustomerVN(String[] arr) {
        super(arr);
        this.typeOfGuest = arr[2];
        this.consumption = Double.parseDouble(arr[3]) ;
    }
    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }


    @Override
    public String toString() {
        return super.toString() +
                "," + typeOfGuest +
                "," + consumption;
    }

    @Override
    public String showInfo() {
    return "CustomerVN{" +
            "idCustomer='" + getIdCustomer() + '\'' +
            ", name='" + getName() + '\'' +
            ", typeOfGuest='" + typeOfGuest + '\'' +
            ", consumption=" + consumption +
            '}';
    }
}
