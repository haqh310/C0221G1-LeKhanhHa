package case_study_module_2.services;

import case_study_module_2.models.*;

import java.util.*;

public class DisplayServices {
    public static void displayNameVilla(List<Services> listServices) {
        Set<String> setName = new TreeSet<>();
        listServices.forEach((element) -> {
            if (element instanceof Villa) {
                setName.add(element.getNameServices());
            }
        });
        for (String name : setName) {
            System.out.println(name);
        }
    }

    public static void displayNameHouse(List<Services> listServices) {
        Set<String> setName = new TreeSet<>();
        listServices.forEach((element) -> {
            if (element instanceof House) {
                setName.add(element.getNameServices());
            }
        });
        for (String name : setName) {
            System.out.println(name);
        }
    }

    public static void displayNameRoom(List<Services> listServices) {
        Set<String> setName = new TreeSet<>();
        listServices.forEach((element) -> {
            if (element instanceof Room) {
                setName.add(element.getNameServices());
            }
        });
        for (String name : setName) {
            System.out.println(name);
        }
    }

    public static List<Villa> displayAllVilla(List<Services> listServices) {
        List<Villa> villas = new ArrayList<>();
        int i=1;
        for (Services e : listServices) {
            if (e instanceof Villa) {
                villas.add((Villa) e);
                System.out.println(i+++". "+e.showInfo());
            }
        }
        return villas;
    }

    public static List<House> displayAllHouse(List<Services> listServices) {
        List<House> houses = new ArrayList<>();
        int i=1;
        for (Services e : listServices) {
            if (e instanceof House) {
                houses.add((House) e);
                System.out.println(i++ +". "+e.showInfo());
            }
        }
        return houses;
    }

    public static List<Room> displayAllRoom(List<Services> listServices) {
        List<Room> rooms = new ArrayList<>();
        int i=1;
        for (Services e : listServices) {
            if (e instanceof Room) {
                rooms.add((Room) e);
                System.out.println(i++ +". "+e.showInfo());
            }
        }
        return rooms;
    }
}
