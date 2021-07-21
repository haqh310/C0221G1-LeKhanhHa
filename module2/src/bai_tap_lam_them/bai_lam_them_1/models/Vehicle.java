package bai_tap_lam_them.bai_lam_them_1.models;

public abstract class Vehicle {
    private String numberPlate;
    private String manufacturer;
    private String yearOfManufacture;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String numberPlate, String manufacturer, String yearOfManufacture, String owner) {
        this.numberPlate = numberPlate;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return        numberPlate +
                "," + manufacturer +
                "," + yearOfManufacture +
                "," + owner ;
    }

    public abstract String showInFor();
}
