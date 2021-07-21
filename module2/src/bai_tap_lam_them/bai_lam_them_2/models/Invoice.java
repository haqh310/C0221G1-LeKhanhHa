package bai_tap_lam_them.bai_lam_them_2.models;

public class Invoice implements Show{
    private String idInvoice;
    private String idCustomer;
    private String date;
    private double count;
    private double price;
    private double totalMoney;

    public Invoice() {
    }

    public Invoice(String idInvoice, String idCustomer, String date, double count, double price, Customer customer) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.date = date;
        this.count = count;
        this.price = price;
        setTotalMoney(customer);
    }
    public Invoice(String[] arr) {
        this.idInvoice = arr[0];
        this.idCustomer = arr[1];
        this.date = arr[2];
        this.count = Double.parseDouble(arr[3]);
        this.price = Double.parseDouble(arr[4]);
        this.totalMoney=Double.parseDouble(arr[5]);
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Customer customer) {
        boolean check = customer instanceof CustomerVN && count > ((CustomerVN) customer).getConsumption();
        if (check) {
            totalMoney = count * price * ((CustomerVN) customer).getConsumption() + (count-((CustomerVN) customer).getConsumption())*price*2.5;
        }
        totalMoney = count * price;
    }


    @Override
    public String toString() {
        return  idInvoice +
                "," + idCustomer +
                "," + date +
                "," + count +
                "," + price +
                "," + totalMoney ;
    }

    @Override
    public String showInfo() {
        return "ElectricInvoice{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", date='" + date + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
