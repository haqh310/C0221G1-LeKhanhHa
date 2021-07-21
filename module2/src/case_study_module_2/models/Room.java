package case_study_module_2.models;

public class Room extends Services {
    private ExtraService extraService;

    public Room() {

    }

    public Room(String id, String nameServices, double areaUser, double rentCost, int numberOfPeople, String typeRent, ExtraService extraService) {
        super(id, nameServices, areaUser, rentCost, numberOfPeople, typeRent);
        this.extraService = extraService;
    }

    public Room(String[] arr) {
        super(arr);
        this.extraService = new ExtraService(arr[6],arr[7],Double.parseDouble(arr[8]));
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + extraService.toString();
    }

    @Override
    public String showInfo() {
        return "Room{" +
                "Id='" + id + '\'' +
                ", Name Services='" + nameServices + '\'' +
                ", Area User=" + areaUser +
                ", Rent Cost=" + rentCost +
                ", Number Of People=" + numberOfPeople +
                ", Type Rent='" + typeRent + '\'' +
                ", " + extraService.showInfo() +
                '}';
    }
}
