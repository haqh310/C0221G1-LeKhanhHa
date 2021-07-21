package case_study_module_2.models;

import java.io.Serializable;

public abstract class Services implements ShowInfo {
    protected String id;
    protected String nameServices;
    protected double areaUser;
    protected double rentCost;
    protected int numberOfPeople;
    protected String typeRent;

    public Services() {
    }

    public Services(String id, String nameServices, double areaUser, double rentCost, int numberOfPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUser = areaUser;
        this.rentCost = rentCost;
        this.numberOfPeople = numberOfPeople;
        this.typeRent = typeRent;
    }

    public Services(String[] arr) {
        this.id = arr[0];
        this.nameServices = arr[1];
        this.areaUser = Double.parseDouble(arr[2]);
        this.rentCost = Double.parseDouble(arr[3]);
        this.numberOfPeople = Integer.parseInt(arr[4]);
        this.typeRent = arr[5];
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAreaUser() {
        return areaUser;
    }

    public void setAreaUser(double areaUser) {
        this.areaUser = areaUser;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        typeRent = typeRent;
    }

    @Override
    public String toString() {
        return   id +
                "," + nameServices +
                "," + areaUser +
                "," + rentCost +
                "," + numberOfPeople +
                "," + typeRent ;
    }
}
