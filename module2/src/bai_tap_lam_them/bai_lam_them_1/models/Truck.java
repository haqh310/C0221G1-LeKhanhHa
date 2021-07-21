package bai_tap_lam_them.bai_lam_them_1.models;

public class Truck extends Vehicle {
    private double payload;

    public Truck() {
    }

    public Truck(double payload) {
        payload = payload;
    }

    public Truck(String numberPlate, String manufacturer, String yearOfManufacture, String owner, double payload) {
        super(numberPlate, manufacturer, yearOfManufacture, owner);
        payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(Double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + payload ;
    }

    @Override
    public String showInFor() {
        return "Truck{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", yearOfManufacture='" + getYearOfManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "payload=" + payload +
                '}';
    }
}
