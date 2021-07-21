package case_study_module_2.models;

public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int numberOfFloors;

    public House() {

    }

    public House(String id, String nameServices, double areaUser, double rentCost, int numberOfPeople, String typeRent, String standardRoom, String otherDescription, int numberOfFloors) {
        super(id, nameServices, areaUser, rentCost, numberOfPeople, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloors = numberOfFloors;
    }
    public House(String[] arr) {
        super(arr);
        this.standardRoom = arr[6];
        this.otherDescription = arr[7];
        this.numberOfFloors = Integer.parseInt(arr[8]);
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + standardRoom+
                "," + otherDescription +
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
                ", standard room='" + standardRoom + '\'' +
                ", Other Description='" + otherDescription + '\'' +
                ", Number of Floors=" + numberOfFloors +
                '}';
    }
}
