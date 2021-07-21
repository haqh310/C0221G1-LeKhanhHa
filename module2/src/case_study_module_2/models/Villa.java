package case_study_module_2.models;

public class Villa extends Services {
    private String standardRoom;
    private String otherDescription;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String id, String nameServices, double areaUser, double rentCost, int numberOfPeople, String typeRent, String standardRoom, String otherDescription, double areaPool, int numberOfFloors) {
        super(id, nameServices, areaUser, rentCost, numberOfPeople, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }
    public Villa(String[] arr) {
        super(arr);
        this.standardRoom = arr[6];
        this.otherDescription = arr[7];
        this.areaPool = Double.parseDouble(arr[8]);
        this.numberOfFloors = Integer.parseInt(arr[9]);
    }
    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + standardRoom +
                "," + otherDescription +
                "," + areaPool +
                "," + numberOfFloors;
    }


    @Override
    public String showInfo() {
        return "Villa{" +
                "Id='" + id + '\'' +
                ", Name Services='" + nameServices + '\'' +
                ", Area User=" + areaUser +
                ", Rent Cost=" + rentCost +
                ", Number Of People=" + numberOfPeople +
                ", Type Rent='" + typeRent + '\''+
                ", Standard Room='" + standardRoom + '\'' +
                ", Other Description='" + otherDescription + '\'' +
                ", Area Pool=" + areaPool +
                ", Number of Floors=" + numberOfFloors +
                '}';
    }
}
