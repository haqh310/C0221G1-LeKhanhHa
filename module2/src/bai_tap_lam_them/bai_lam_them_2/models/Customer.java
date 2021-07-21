package bai_tap_lam_them.bai_lam_them_2.models;

public abstract class Customer implements Show{
    private String idCustomer;
    private String name;

    public Customer() {
    }

    public Customer(String idCustomer, String name) {
        this.idCustomer = idCustomer;
        this.name = name;
    }
    public Customer(String[] arr) {
        this.idCustomer = arr[0];
        this.name = arr[1];
    }
    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return idCustomer +
                "," + name;
    }
}
