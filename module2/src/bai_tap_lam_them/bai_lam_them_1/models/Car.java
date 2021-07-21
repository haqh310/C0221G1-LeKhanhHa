package bai_tap_lam_them.bai_lam_them_1.models;

public class Car extends Vehicle {
    private int numberOfSeat;
    private String modelOfCar;

    public Car() {
    }

    public Car(String numberPlate, String manufacturer, String yearOfManufacture, String owner, int numberOfSeat, String modelOfCar) {
        super(numberPlate, manufacturer, yearOfManufacture, owner);
        this.numberOfSeat = numberOfSeat;
        this.modelOfCar = modelOfCar;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }


     @Override
    public String toString() {
        return    getNumberPlate() +
                "," + getManufacturer() +
                "," + getYearOfManufacture() +
                "," + numberOfSeat +
                "," + getOwner()+
                "," + modelOfCar  ;
    }

    @Override
    public String showInFor() {
        return "Car{" +
                "numberPlate='" + getNumberPlate() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", yearOfManufacture='" + getYearOfManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "numberOfSeat='" + numberOfSeat + '\'' +
                ", modelOfCar='" + modelOfCar + '\'' +
                '}';
    }

}
