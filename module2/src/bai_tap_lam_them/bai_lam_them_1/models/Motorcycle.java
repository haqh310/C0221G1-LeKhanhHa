package bai_tap_lam_them.bai_lam_them_1.models;

public class Motorcycle extends Vehicle {
    private double wattage;

    public Motorcycle() {
    }

    public Motorcycle(Double wattage) {
        this.wattage = wattage;
    }

    public Motorcycle(String numberPlate, String manufacturer, String yearOfManufacture, String owner, double wattage) {
        super(numberPlate, manufacturer, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + wattage ;
    }

    @Override
    public String showInFor() {
        return "Motorcycle{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", yearOfManufacture='" + getYearOfManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "wattage=" + wattage +
                '}';
    }
}
